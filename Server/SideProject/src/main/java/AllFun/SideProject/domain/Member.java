package AllFun.SideProject.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id; // member id (pk)

    private String email; // Log-In Id
    private String passwd; // password
    private String birth; // yyyy-mm-dd
    private String name; // user korean name
    private String phone; //phone number
    private String nickname; // nickname
    private String gender; // gender(M / F)


    public static Member createMember(String email, String passwd, String birth, String name, String phone,
                                      String nickname, String gender){
        Member member = new Member();
        member.setEmail(email);
        member.setPasswd(passwd);
        member.setBirth(birth);
        member.setName(name);
        member.setPhone(phone);
        member.setNickname(nickname);
        member.setGender(gender);
        return member;
    }

}
