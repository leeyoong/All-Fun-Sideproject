package AllFun.SideProject.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.time.LocalDateTime;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member{

    @Id
    @GeneratedValue
    private Long id; // member id (pk)

    private String email; // Log-In Id
    private String passwd; // password
    private String birth; // yyyy-mm-dd
    private String name; // user korean name
    private String phone; //phone number
    private String nickname; // nickname
    //private String profileImg; // profile image location
    private LocalDateTime createDate; // create member time (yyyy-mm-dd hh:mm:ss)
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
        //member.setProfileImg(profileImg);
        member.setGender(gender);
        return member;
    }

    @PrePersist
    public void createdAt(){
        this.createDate = LocalDateTime.now();
    }
}
