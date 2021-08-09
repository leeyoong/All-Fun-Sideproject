package AllFun.SideProject.controller.dashBoard;

import AllFun.SideProject.domain.dashBoard.GroupBoard;
import AllFun.SideProject.dto.dashBoard.groupBoard.CreateGroupBoardDto;
import AllFun.SideProject.dto.dashBoard.groupBoard.EditGroupBoardDto;
import AllFun.SideProject.dto.dashBoard.groupBoard.GroupBoardDetailDto;
import AllFun.SideProject.dto.dashBoard.groupBoard.GroupBoardListDto;
import AllFun.SideProject.service.dashBoard.GroupBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 그룹 게시판
 */

@RestController
@RequestMapping("/dashboard/{groupId}/board")
@RequiredArgsConstructor
public class GroupBoardController {
    private final GroupBoardService groupBoardService;

    /**
     * get board list (공지사항)
     * @return
     */
    @GetMapping("/list/notice")
    public ResponseEntity<?> groupBoardNotice(@PathVariable("groupId")Long groupId){
        GroupBoardListDto response = groupBoardService.boardNotice(groupId);
        return ResponseEntity.ok(response);
    }

    /**
     * get board list (일반)
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<?> groupBoardList(@PathVariable("groupId")Long groupId){
        List<GroupBoardListDto> groupBoards = groupBoardService.boardList(groupId);
        return ResponseEntity.ok(groupBoards);
    }

    /**
     * groupBoardId detail = 게시판 클릭
     * @return
     */
    @PatchMapping("/list/{groupBoardId}/member/{memberId}")
    public ResponseEntity<?> groupBoardDetail(@PathVariable("groupBoardId")Long groupBoardId,
                                              @PathVariable("memberId") Long memberId){
        GroupBoardDetailDto response = groupBoardService.boardDetail(groupBoardId, memberId);
        return ResponseEntity.ok(response);
    }

    /**
     * create group board
     * @return
     */
    @PostMapping("/create/{memberId}")
    public ResponseEntity<?> createBoard(@PathVariable("groupId")Long groupId, @PathVariable("memberId") Long memberId,
                                         @RequestBody CreateGroupBoardDto request){
        groupBoardService.createBoard(groupId, memberId, request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * 수정하기 위해 기존 데이터 반환
     * @param groupBoardId
     * @return
     */
    @GetMapping("/edit/{groupBoardId}")
    public ResponseEntity<?> getEditBoard(@PathVariable("groupBoardId") Long groupBoardId){
        EditGroupBoardDto response = groupBoardService.getGroupBoardData(groupBoardId);
        return ResponseEntity.ok(response);
    }


    /**
     * edit group board
     * @return
     */
    @PatchMapping("/edit")
    public ResponseEntity<?> editBoard(@RequestBody EditGroupBoardDto request){
        groupBoardService.editGroupBoard(request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * delete group board
     * @return
     */
    @DeleteMapping("/delete/{groupBoardId}")
    public ResponseEntity<?> deleteCalendar(@PathVariable("groupBoardId")Long groupBoardId){
        groupBoardService.deleteBoard(groupBoardId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
