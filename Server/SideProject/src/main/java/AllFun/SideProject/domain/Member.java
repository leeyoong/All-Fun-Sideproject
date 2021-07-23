package AllFun.SideProject.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue
    private Long memberId; // 회원 고유 id

    private String email; // 사용자 이메일 (로그인 ID)
    private String passwd; // 사용자 비밀번호
    private String birth; // 생년월일 (yyyy-mm-dd)
    private String name; // 사용자 본명
    private String nickname; // 사용자 활동명(별명)
    private String profileImg; // 프로필 이미지가 저장된 경로
    private String createDate; // 계정 생성 날짜 (yyyy-MM-dd HH:mm:ss)
    private String gender; // 성별


}
