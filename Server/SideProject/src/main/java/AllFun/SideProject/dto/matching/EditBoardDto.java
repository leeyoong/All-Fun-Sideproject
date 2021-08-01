package AllFun.SideProject.dto.matching;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class EditBoardDto {
    private String title; // 제목
    private String content; // 내용
}
