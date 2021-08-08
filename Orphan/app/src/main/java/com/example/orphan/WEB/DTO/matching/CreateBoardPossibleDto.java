package AllFun.SideProject.dto.matching;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CreateBoardPossibleDto {
    private Long groupId;
    private String groupName;
}
