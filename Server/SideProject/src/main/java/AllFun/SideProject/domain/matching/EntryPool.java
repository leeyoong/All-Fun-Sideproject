package AllFun.SideProject.domain.matching;

//지원자 리스트

import AllFun.SideProject.domain.user.Member;
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

    @OneToOne(mappedBy = "member")
    private Member member; // 지원자 member id

    @ManyToOne
    private Board board; // 매칭 게시판 id
}
