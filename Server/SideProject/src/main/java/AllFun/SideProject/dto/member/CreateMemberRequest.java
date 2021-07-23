package AllFun.SideProject.dto.member;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CreateMemberRequest {
    private String email;
    private String passwd;
    private String birth;
    private String name;
    private String nickname;
    private String profileImg;
    private String createDate;
    private String gender;
}