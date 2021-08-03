package AllFun.SideProject.dto.mainPage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class MyGroupBoardDto {
    private String groupName;
    private Long groupBoardId;
    private String title;
    private String writer;
    private LocalDateTime createdDate;
}
