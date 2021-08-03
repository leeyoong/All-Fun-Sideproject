package AllFun.SideProject.dto.mainPage;

import AllFun.SideProject.domain.base.MatchingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class MyMatchingStatusDto {
    private Long boardId;
    private String boardTitle;
    private String role;
    private MatchingStatus status;
}
