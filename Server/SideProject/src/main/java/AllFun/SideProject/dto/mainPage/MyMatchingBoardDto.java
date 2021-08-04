package AllFun.SideProject.dto.mainPage;

import AllFun.SideProject.domain.base.BoardStatus;
import AllFun.SideProject.dto.matching.BoardRoleDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class MyMatchingBoardDto {
    private Long boardId;
    private String title;
    private String writer;
    private LocalDateTime createdDate;
    private LocalDateTime endDate;

    private List<BoardRoleDto> expect;

    private BoardStatus status;

}
