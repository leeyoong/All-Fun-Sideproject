package AllFun.SideProject.dto.board;

import AllFun.SideProject.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SearchResponseDto {
    private List<Board> response;
}
