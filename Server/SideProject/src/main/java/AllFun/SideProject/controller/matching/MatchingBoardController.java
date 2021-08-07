package AllFun.SideProject.controller.matching;

import AllFun.SideProject.Exception.ErrorHeader;
import AllFun.SideProject.domain.dashBoard.DashGroup;
import AllFun.SideProject.domain.matching.Board;
import AllFun.SideProject.domain.member.Member;
import AllFun.SideProject.dto.matching.*;
import AllFun.SideProject.service.dashBoard.DashGroupService;
import AllFun.SideProject.service.dashBoard.GroupMemberService;
import AllFun.SideProject.service.matching.BoardService;
import AllFun.SideProject.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class MatchingBoardController {
    private final BoardService boardService;
    private final MemberService memberService;
    private final DashGroupService dashGroupService;
    private final GroupMemberService groupMemberService;

    /**
     * 그룹의 OWNER 권한을 가진 사용자가 글쓰기 작성 시 작성 가능한 그룹 반환
     * @param memberId
     * @return
     */
    @GetMapping("/create/member/{memberId}")
    public ResponseEntity<?> createForm(@PathVariable("memberId")Long memberId){
        List<DashGroup> dashGroups = groupMemberService.getDashGroupOwner(memberId);
        if (dashGroups == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        // 그룹이 있는 경우
        List<CreateBoardPossibleDto> response = new ArrayList<>();
        for(DashGroup dashGroup : dashGroups){
            CreateBoardPossibleDto createBoardPossibleDto = new CreateBoardPossibleDto(dashGroup.getId(),
                                                                                        dashGroup.getGroupName());

            response.add(createBoardPossibleDto);
        }

        return ResponseEntity.ok(response);
    }

    /**
     * Write Side-Project board (Use group Id & member Id)
     *
     * @param request
     * @return
     */
    @PostMapping("/create/group/{groupId}/member/{memberId}")
    public ResponseEntity<?> create(@RequestBody CreateBoardRequestDto request, @PathVariable("groupId") Long groupId,
                                    @PathVariable("memberId") Long memberId) {
        Member find = memberService.findById(memberId);
        DashGroup dashGroup = dashGroupService.findById(groupId);

        if (dashGroup == null || find == null) {
            return ErrorHeader.errorMessage("wrong id", HttpStatus.BAD_REQUEST);
        }

        Board newBoard = Board.createBoard(
                request.getTitle(),
                request.getContent(),
                request.getEndDate(),

                request.getBackend(),
                request.getFrontend(),
                request.getPm(),
                request.getAndroid(),
                request.getIOS(),
                request.getAi(),
                request.getBigData(),
                request.getBlockChain()
        );
        dashGroup.setBoard(newBoard);
        boardService.save(newBoard, find);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * get board list recently
     * @param pageable
     * @return
     */

    @GetMapping("/list/recently/filter/{filter}")
    public ResponseEntity<?> listRecently (@PageableDefault(size = 20, sort = "board_id", direction = Sort.Direction.DESC) Pageable pageable,
                                           @PathVariable("filter") String filter){
        Page<Board> boards = boardService.boardList(pageable, filter);
        Page<SearchResponseDto> response = boards.map(
                board->new SearchResponseDto(
                        board.getId(),
                        board.getTitle(),
                        board.getMember().getNickname(),
                        board.getCreatedDate(),
                        board.getEndDate(),
                        boardService.getBoardRoleDto(board)
                )
        );
        return ResponseEntity.ok(response);
    }

    /**
     * get board list deadline(마감순)
     *
     * @return
     */
    @GetMapping("/list/deadline/filter/{filter}")
    public ResponseEntity<?> listDeadline(@PageableDefault(size = 20, sort = "end_date", direction = Sort.Direction.ASC) Pageable pageable,
                                          @PathVariable("filter") String filter) {
        Page<Board> boards = boardService.boardList(pageable, filter);
        Page<SearchResponseDto> response = boards.map(
                board->new SearchResponseDto(
                        board.getId(),
                        board.getTitle(),
                        board.getMember().getNickname(),
                        board.getCreatedDate(),
                        board.getEndDate(),
                        boardService.getBoardRoleDto(board)
                )
        );
        return ResponseEntity.ok(response);
    }

    /**
     * Search by Title (recently & filter)
     * @return
     */
    @GetMapping("/search/title/{keyword}/recently/filter/{filter}")
    public ResponseEntity<?> searchRecently(@PathVariable("keyword")String keyword, @PathVariable("filter")String filter,
                                            @PageableDefault(size = 20, sort = "end_date", direction = Sort.Direction.ASC) Pageable pageable){
        Page<Board> boards = boardService.searchList(keyword, pageable, filter);
        Page<SearchResponseDto> response = boards.map(
                board->new SearchResponseDto(
                        board.getId(),
                        board.getTitle(),
                        board.getMember().getNickname(),
                        board.getCreatedDate(),
                        board.getEndDate(),
                        boardService.getBoardRoleDto(board)
                )
        );
        return ResponseEntity.ok(response);
    }

    /**
     * Search by Title (deadline)
     * @return
     */
    @GetMapping("/search/title/{keyword}/deadline/filter/{filter}")
    public ResponseEntity<?> searchDeadline(@PathVariable("keyword")String keyword, @PathVariable("filter")String filter,
                                            @PageableDefault(size = 20, sort = "end_date", direction = Sort.Direction.ASC) Pageable pageable){
        Page<Board> boards = boardService.searchList(keyword, pageable, filter);
        Page<SearchResponseDto> response = boards.map(
                board->new SearchResponseDto(
                        board.getId(),
                        board.getTitle(),
                        board.getMember().getNickname(),
                        board.getCreatedDate(),
                        board.getEndDate(),
                        boardService.getBoardRoleDto(board)
                )
        );
        return ResponseEntity.ok(response);
    }

    /**
     * Read Detail Board and Increase hit.
     * @param boardId
     * @return
     */
    @GetMapping("/{boardId}/detail")
    public ResponseEntity<?> readDetail(@PathVariable("boardId") Long boardId){
        ReadDetailDto response = boardService.readDetail(boardId);
        if (response==null){
            return ErrorHeader.errorMessage("error", HttpStatus.BAD_REQUEST);
        } else{
            return ResponseEntity.ok(response);
        }
    }

    /**
     * Edit Board(get)
     * @return
     */
    @GetMapping("/edit/{boardId}")
    public ResponseEntity<?> getEdit(@PathVariable("boardId") Long boardId){
        ReadDetailDto response = boardService.readDetail(boardId);
        if (response==null){
            return ErrorHeader.errorMessage("error", HttpStatus.BAD_REQUEST);
        } else{
            return ResponseEntity.ok(response);
        }
    }

    /**
     * Edit Board
     * @param request
     * @return
     */
    @PatchMapping("/edit/{boardId}")
    public ResponseEntity<?> edit(@RequestBody EditBoardDto request, @PathVariable("boardId") Long boardId){
        EditBoardDto response = boardService.editBoard(boardId, request);
        if (response==null){
            return ErrorHeader.errorMessage("error", HttpStatus.BAD_REQUEST);
        } else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    /**
     * Done Matching 'waiting' -> 'done'
     * @return
     */
    @PatchMapping("/edit/{boardId}/status")
    public ResponseEntity<?> changeStatus(@PathVariable("boardId")Long boardId){
        String out = boardService.changeStatus(boardId);
        if(out==null){
            return ErrorHeader.errorMessage("error", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * delete board
     * @param boardId
     * @return
     */
    @DeleteMapping("/delete/{boardId}")
    public ResponseEntity<?> delete(@PathVariable("boardId") Long boardId){
        Board board = boardService.findById(boardId);
        if (board == null){
            return ErrorHeader.errorMessage("error", HttpStatus.BAD_REQUEST);
        } else{
            boardService.deleteBoard(board);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    /**
     * add scrap
     * @param boardId
     * @param memberId
     * @return
     */
    @PostMapping("/{boardId}/scrap/{memberId}")
    public ResponseEntity<?> scrapBoard(@PathVariable("boardId")Long boardId,
                                        @PathVariable("memberId") Long memberId){
        boardService.scrapBoard(boardId, memberId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * delete scrap
     * @param boardId
     * @param memberId
     * @return
     */
    @DeleteMapping("/{boardId}/scrap/{memberId}")
    public ResponseEntity<?> deleteScrapBoard(@PathVariable("boardId") Long boardId,
                                              @PathVariable("memberId")Long memberId){
        boardService.deleteScrap(boardId, memberId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
