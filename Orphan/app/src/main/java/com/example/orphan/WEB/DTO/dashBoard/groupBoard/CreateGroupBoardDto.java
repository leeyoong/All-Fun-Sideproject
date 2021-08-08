package AllFun.SideProject.dto.dashBoard.groupBoard;

import AllFun.SideProject.domain.base.BoardKinds;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CreateGroupBoardDto {
    private String title;
    private String content;

    private BoardKinds kinds;
}
