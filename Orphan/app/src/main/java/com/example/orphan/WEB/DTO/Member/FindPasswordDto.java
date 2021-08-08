package AllFun.SideProject.dto.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class FindPasswordDto {
    private String name;
    private String birth;
    private String phone;
    private String email;
}
