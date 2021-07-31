package AllFun.SideProject.domain.dashBoard;

import AllFun.SideProject.domain.user.Member;
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

    @ManyToOne
    @JoinColumn(name="group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

}
