package AllFun.SideProject.domain.member;

import AllFun.SideProject.domain.base.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Note extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name="note_id")
    private Long id;

    private String message;

    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;
}
