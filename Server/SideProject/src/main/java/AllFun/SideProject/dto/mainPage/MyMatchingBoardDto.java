package AllFun.SideProject.dto.mainPage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class MyMatchingBoardDto {
    private Long boardId;
    private String title;
    private int hope;
    private int entry;
}
