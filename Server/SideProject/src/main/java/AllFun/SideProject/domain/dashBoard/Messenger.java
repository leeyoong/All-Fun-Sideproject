package AllFun.SideProject.domain.dashBoard;

import AllFun.SideProject.domain.member.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Messenger {
    @Id
    @GeneratedValue
    @Column(name="messenger_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="group_id")
    private DashGroup group; //그룹 id, 채팅 작성자 id 및 닉네임

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member; // member id

    @Lob
    private String content; // 글 내용


}
