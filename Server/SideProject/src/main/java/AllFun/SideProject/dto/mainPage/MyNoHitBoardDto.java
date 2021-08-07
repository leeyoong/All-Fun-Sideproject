package AllFun.SideProject.dto.mainPage;

import AllFun.SideProject.domain.base.BoardKinds;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class MyNoHitBoardDto {
    private Long groupId;
    private Long groupBoardId;

    private String title;
    private String content;
    private LocalDateTime createdDate;

    private Long memberId;
    private String memberNickname;

    private String groupName;

    private BoardKinds kinds;
}
