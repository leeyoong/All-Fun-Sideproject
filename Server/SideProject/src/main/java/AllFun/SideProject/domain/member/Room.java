package AllFun.SideProject.domain.member;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Room {
    @Id
    @GeneratedValue
    @Column(name="room_id")
    private Long id;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Note> notes = new ArrayList<>();

    public static Room createRoom(){
        Room room = new Room();
        return room;
    }

    public void addNotes(Note note){
        notes.add(note);
        note.setRoom(this);
    }
}
