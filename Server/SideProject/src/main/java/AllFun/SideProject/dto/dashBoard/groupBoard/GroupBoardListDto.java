package AllFun.SideProject.dto.dashBoard.groupBoard;

import AllFun.SideProject.domain.base.BoardKinds;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class GroupBoardListDto {
    private Long groupBoardId;

    private Long memberId;

    private String memberNickname;

    private String title;

    private LocalDateTime createdDate;

    private BoardKinds kinds;
}
