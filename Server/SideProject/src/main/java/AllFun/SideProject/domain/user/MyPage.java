package AllFun.SideProject.domain.user;

import AllFun.SideProject.domain.user.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MyPage {
    @Id
    @GeneratedValue
    @Column(name="mypage_id")
    private Long id;

    private String introduce; //자기소개

    private String profileImg; // 프로필사진 저장경로

    @OneToOne(mappedBy="mypage")
    private Member member;
}
