package AllFun.SideProject.controller.matching;

import AllFun.SideProject.Exception.ErrorHeader;
import AllFun.SideProject.domain.base.MatchingStatus;
import AllFun.SideProject.domain.matching.Board;
import AllFun.SideProject.domain.matching.EntryPool;
import AllFun.SideProject.domain.member.Member;
import AllFun.SideProject.dto.matching.EntryPoolResponseDto;
import AllFun.SideProject.service.matching.BoardService;
import AllFun.SideProject.service.matching.EntryPoolService;
import AllFun.SideProject.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class MatchingEntryController {
    private final BoardService boardService;
    private final MemberService memberService;
    private final EntryPoolService entryPoolService;

    /**
     * 지원자가 role 에 지원했을 때
     * @param boardId
     * @param memberId
     * @param role
     * @return
     */
    @PostMapping("/{boardId}/role/{role}/member/{memberId}")
    public ResponseEntity<?> clickEntry(@PathVariable("boardId")Long boardId,
                                        @PathVariable("memberId")Long memberId,
                                        @PathVariable("role")String role){
        EntryPool entryPool = EntryPool.createEntryPool(role);

        Board board = boardService.findById(boardId);
        board.addEntryPool(entryPool);

        Member member = memberService.findById(memberId);
        member.addEntryPool(entryPool);

        entryPoolService.save(entryPool);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * 지원자가 지원한 role 을 취소한 경우
     * @param boardId
     * @param memberId
     * @param role
     * @return
     */
    @DeleteMapping("/{boardId}/role/{role}/member/{memberId}")
    public ResponseEntity<?> cancelEntry(@PathVariable("boardId")Long boardId,
                                         @PathVariable("memberId")Long memberId,
                                         @PathVariable("role")String role){
        Board board = boardService.findById(boardId);
        Member member = memberService.findById(memberId);
        String out = entryPoolService.deleteEntryPool(board, member, role);
        if (out == null){
            return ErrorHeader.errorMessage("error", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * 작성자가 role 에 지원한 리스트 불러오는 경우
     * @param boardId
     * @param role
     * @return
     */
    @GetMapping("/{boardId}/role/{role}")
    public ResponseEntity<?> checkEntry(@PathVariable("boardId")Long boardId,
                                        @PathVariable("role")String role){
        Board board = boardService.findById(boardId);
        List<EntryPool> entryPools = entryPoolService.findAllByBoardAndRole(board,role);
        List<EntryPoolResponseDto> response = new ArrayList<>();
        for (EntryPool entryPool : entryPools) {
            response.add(new EntryPoolResponseDto(
                    entryPool.getMember().getId(),
                    entryPool.getMember().getNickname(),
                    entryPool.getMember().getProfileImg(),
                    entryPool.getStatus()
            ));
        }
        return ResponseEntity.ok(response);
    }

    /**
     * 참여 성공 or 실패 (일괄 처리 / 단일 처리)
     *
     * ******* 참여 성공 시 group 생성.(아직 미완성) // 추후 진행 ********
     *
     * @param boardId
     * @param role
     * @param memberId
     * @param status
     * @return
     */
    @PatchMapping("/{boardId}/role/{role}/member/{memberId}/status/{status}")
    public ResponseEntity<?> resultEntry(@PathVariable("boardId")Long boardId,
                                         @PathVariable("role")String role,
                                         @PathVariable("memberId")Long memberId,
                                         @PathVariable("status")String status){

        Board board = boardService.findById(boardId);
        Member member = memberService.findById(memberId);

        MatchingStatus matchingStatus = MatchingStatus.valueOf(status.toUpperCase());

        entryPoolService.changeStatus(board, member, role,matchingStatus);

        if(matchingStatus.equals(MatchingStatus.ACCEPT)){
            boardService.updateEntry(board,role);
        }

        if((board.getBackendExpect() == board.getBackendEntry()) &&
            role.equals("backend")){
            entryPoolService.changeBatchStatus(board,role);
        }else if((board.getFrontendEntry() == board.getFrontendExpect()) &&
                role.equals("frontend")){
            entryPoolService.changeBatchStatus(board,role);
        }else if((board.getAiEntry() == board.getAiExpect()) &&
                role.equals("ai")){
            entryPoolService.changeBatchStatus(board,role);
        }else if((board.getBigdataExpect() == board.getBigdataEntry()) &&
                role.equals("bigdata")){
            entryPoolService.changeBatchStatus(board,role);
        }else if((board.getBlockchainExpect() == board.getBlockchainEntry()) &&
                role.equals("blockchain")){
            entryPoolService.changeBatchStatus(board,role);
        }else if((board.getIosExpect() == board.getIosEntry()) &&
                role.equals("ios")){
            entryPoolService.changeBatchStatus(board,role);
        }else if((board.getPmExpect() == board.getPmEntry()) &&
                role.equals("pm")){
            entryPoolService.changeBatchStatus(board,role);
        }else if((board.getAndroidExpect() == board.getAndroidEntry()) &&
                role.equals("android")){
            entryPoolService.changeBatchStatus(board,role);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
