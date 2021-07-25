package AllFun.SideProject.domain;

import AllFun.SideProject.domain.base.MemberRole;
import lombok.*;
import org.hibernate.annotations.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class Member implements UserDetails {

    @Id
    @GeneratedValue
    private Long memberId; // member id (pk)

    private String email; // Log-In Id
    private String passwd; // password
    private String birth; // yyyy-mm-dd
    private String name; // user korean name
    private String phone; //phone number
    private String nickname; // nickname
    private String profileImg; // profile image location
    private String createDate; // create member time (yyyy-mm-dd hh:mm:ss)
    private String gender; // gender

    @Enumerated(EnumType.STRING)
    private MemberRole role;

    //private String type; // naver, google, kakao

    public static Member createMember(String email, String passwd, String birth, String name, String phone,
                                      String nickname, String profileImg, String createDate, String gender,
                                        MemberRole role){
        Member member = new Member();
        member.setEmail(email);
        member.setPasswd(passwd);
        member.setBirth(birth);
        member.setName(name);
        member.setPhone(phone);
        member.setNickname(nickname);
        member.setProfileImg(profileImg);
        member.setCreateDate(createDate);
        member.setGender(gender);
        member.setRole(role);
        return member;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

        list.add(new SimpleGrantedAuthority(this.role.toString()));

        return list;
    }

    @Override
    public String getPassword() {
        return this.passwd;
    }


    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
