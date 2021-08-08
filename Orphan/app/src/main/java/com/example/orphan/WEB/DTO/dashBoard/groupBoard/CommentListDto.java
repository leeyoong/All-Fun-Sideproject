package AllFun.SideProject.dto.dashBoard.groupBoard;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CommentListDto {
    private Long commentId;
    private String memberNickname;
    private String memberComment;
    private LocalDateTime createdDate;
}
