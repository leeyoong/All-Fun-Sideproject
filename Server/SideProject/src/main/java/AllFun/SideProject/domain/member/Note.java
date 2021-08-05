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

    public static Note createNote(String message, Member member){
        Note note = new Note();
        note.setMessage(message);
        note.setMember(member);
        return note;
    }
}
