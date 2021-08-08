package AllFun.SideProject.dto.dashBoard.groupBoard;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class EditGroupBoardDto {

    private Long groupBoardId;

    private String title;

    private String content;

}
