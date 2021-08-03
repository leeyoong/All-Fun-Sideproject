package AllFun.SideProject.domain.dashBoard;

import AllFun.SideProject.domain.base.GroupMemberStatus;
import AllFun.SideProject.domain.member.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class GroupMember {

    @Id
    @GeneratedValue
    @Column(name="group_member_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="group_id")
    private DashGroup group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @Enumerated(EnumType.STRING)
    private GroupMemberStatus status;
}
