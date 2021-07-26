package AllFun.SideProject.domain;

import lombok.*;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member{

    @Id
    @GeneratedValue
    private Long memberId; // member id (pk)

    private String email; // Log-In Id
    private String passwd; // password
    private String birth; // yyyy-mm-dd
    private String name; // user korean name
    private String phone; //phone number
    private String nickname; // nickname
    //private String profileImg; // profile image location
    private String createDate; // create member time (yyyy-mm-dd hh:mm:ss)
    private String gender; // gender

    //private String type; // naver, google, kakao

    public static Member createMember(String email, String passwd, String birth, String name, String phone,
                                      String nickname, String createDate, String gender){
        Member member = new Member();
        member.setEmail(email);
        member.setPasswd(passwd);
        member.setBirth(birth);
        member.setName(name);
        member.setPhone(phone);
        member.setNickname(nickname);
        //member.setProfileImg(profileImg);
        member.setCreateDate(createDate);
        member.setGender(gender);
        return member;
    }

}
