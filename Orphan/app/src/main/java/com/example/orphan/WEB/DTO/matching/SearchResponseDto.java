package AllFun.SideProject.dto.matching;

import AllFun.SideProject.domain.base.BoardStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class SearchResponseDto {
    private Long boardId;
    private String title;
    private String writer;
    private LocalDateTime createdDate;
    private LocalDateTime endDate;

    private List<BoardRoleDto> expect;

}
