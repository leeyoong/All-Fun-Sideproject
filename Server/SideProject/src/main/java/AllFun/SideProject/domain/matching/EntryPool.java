package AllFun.SideProject.domain.matching;

//지원자 리스트

import AllFun.SideProject.domain.base.MatchingStatus;
import AllFun.SideProject.domain.member.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class EntryPool {

    @Id
    @GeneratedValue
    @Column(name="entry_id")
    private Long id;

    private String role; //지원 역할군

    @Enumerated(EnumType.STRING)
    private MatchingStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member; // 지원자 member id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="board_id")
    private Board board; // 매칭 게시판 id

}
