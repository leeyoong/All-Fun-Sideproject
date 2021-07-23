package AllFun.SideProject.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 회원 DB
 */
public class Member {

    private Long memberId; // 회원 고유 id

    private String email; // 사용자 이메일 (로그인 ID)
    private String passwd; // 사용자 비밀번호
    private String birth; // 생년월일 (yyyy-mm-dd)
    private String name; // 사용자 본명
    private String nickname; // 사용자 활동명(별명)
    private String profileImg; // 프로필 이미지가 저장된 경로
    private String createDate; // 계정 생성 날짜 (yyyy-MM-dd HH:mm:ss)

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
