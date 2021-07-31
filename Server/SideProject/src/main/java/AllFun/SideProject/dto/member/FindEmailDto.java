package AllFun.SideProject.dto.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class FindEmailDto {
    private String name;
    private String birth;
    private String phone;
}
