package AllFun.SideProject.domain;

import lombok.*;
import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue
    private Long memberId; // member id (pk)

    private String email; // Log-In Id
    private String passwd; // password
    private String birth; // yyyy-mm-dd
    private String name; // user korean name
    private String nickname; // nickname
    private String profileImg; // profile image location
    private String createDate; // create member time (yyyy-mm-dd hh:mm:ss)
    private String gender; // gender

    public static Member createMember(String email, String passwd, String birth, String name, String nickname,
                                String profileImg, String createDate, String gender){
        Member member = new Member();
        member.setEmail(email);
        member.setPasswd(passwd);
        member.setBirth(birth);
        member.setName(name);
        member.setNickname(nickname);
        member.setProfileImg(profileImg);
        member.setCreateDate(createDate);
        member.setGender(gender);
        return member;
    }
}
