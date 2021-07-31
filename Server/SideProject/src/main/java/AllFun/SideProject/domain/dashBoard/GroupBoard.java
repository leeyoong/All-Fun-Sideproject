package AllFun.SideProject.domain.dashBoard;

import AllFun.SideProject.domain.base.BaseEntity;
import AllFun.SideProject.domain.base.BoardKinds;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GroupBoard extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name="group_board_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="group_id")
    private Group group; // 그륩 + 작성자(member)

    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    private BoardKinds kinds;

}
