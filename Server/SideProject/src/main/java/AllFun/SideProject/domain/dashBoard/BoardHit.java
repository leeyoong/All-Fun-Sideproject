package AllFun.SideProject.domain.dashBoard;

import AllFun.SideProject.domain.base.HitStatus;
import AllFun.SideProject.domain.member.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardHit {
    @Id
    @GeneratedValue
    @Column(name="board_hit_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="group_board_id")
    private GroupBoard groupBoard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @Enumerated(EnumType.STRING)
    private HitStatus hit;

    public static BoardHit createBoardHit(){
        BoardHit boardHit = new BoardHit();
        return boardHit;
    }
}
