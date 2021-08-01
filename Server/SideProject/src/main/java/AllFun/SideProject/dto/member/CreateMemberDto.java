package AllFun.SideProject.dto.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CreateMemberDto {
    private String email; //중복체크 & 이메일 인증 완료된 이메일
    private String passwd;
    private String birth; //yyyy-mm-dd
    private String name;
    private String phone;
    private String nickname; //중복없는 닉네임
    private String gender; // Male Female
}
