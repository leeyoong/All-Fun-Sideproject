package AllFun.SideProject.dto.dashBoard.groupBoard;

import AllFun.SideProject.dto.matching.BoardRoleDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class GroupBoardDetailDto {

    private Long groupBoardId;

    private String title;

    private String content;

    private String writer;

    private LocalDateTime createdDate; //작성(수정) 날짜

    private Long memberId; // 사용자 id

}
