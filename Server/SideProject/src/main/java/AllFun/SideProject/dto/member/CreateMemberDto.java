package AllFun.SideProject.dto.member;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateMemberDto {
    private String email;
    private String passwd;
    private String birth;
    private String name;
    private String phone;
    private String nickname;
    private String gender;
}
