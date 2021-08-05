package AllFun.SideProject.domain.matching;

import AllFun.SideProject.domain.base.MatchingStatus;
import AllFun.SideProject.domain.member.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Scrap {
    @Id
    @GeneratedValue
    @Column(name="scrap_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member; // 스크랩한 member id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="board_id")
    private Board board; // 스크랩한 board id

    public static Scrap createScrap(Board board){
        Scrap scrap = new Scrap();
        scrap.setBoard(board);
        return scrap;
    }
}

