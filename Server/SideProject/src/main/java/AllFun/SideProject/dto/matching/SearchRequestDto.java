package AllFun.SideProject.dto.matching;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class SearchRequestDto {
    private String search; //제목 검색명
}
