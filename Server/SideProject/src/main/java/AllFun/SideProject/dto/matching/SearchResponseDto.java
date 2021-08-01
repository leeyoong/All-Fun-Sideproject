package AllFun.SideProject.dto.matching;

import AllFun.SideProject.domain.matching.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class SearchResponseDto {
    private List<Board> response;
}
