package AllFun.SideProject.controller.dashBoard;

import AllFun.SideProject.dto.dashBoard.groupBoard.CommentListDto;
import AllFun.SideProject.service.dashBoard.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard/{groupId}/board/{groupBoardId}")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    /**
     * 댓글 불러오기
     * @param groupBoardId
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<?> getCommentList(@PathVariable("groupBoardId")Long groupBoardId){
        List<CommentListDto> response = commentService.getCommentList(groupBoardId);
        return ResponseEntity.ok(response);
    }

    /**
     * 댓글 작성
     * @param groupBoardId
     * @param request
     * @return
     */
    @PostMapping("/comment/member/{memberId}")
    public ResponseEntity<?> postComment(@PathVariable("groupBoardId")Long groupBoardId,
                                         @PathVariable("memberId") Long memberId,
                                         @RequestBody String request){
        commentService.createComment(groupBoardId, memberId, request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * 댓글 수정
     * @param commentId
     * @param request
     * @return
     */
    @PatchMapping("/comment/{commentId}/member/{memberId}")
    public ResponseEntity<?> editComment(
                                         @PathVariable("commentId")Long commentId,
                                         @RequestBody String request){
        commentService.editComment(commentId, request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * 댓글 삭제
     * @param commentId
     * @return
     */
    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable("commentId")Long commentId){
        commentService.deleteComment(commentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
