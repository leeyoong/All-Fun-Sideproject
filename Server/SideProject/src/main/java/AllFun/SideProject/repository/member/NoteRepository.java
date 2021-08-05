package AllFun.SideProject.repository.member;

import AllFun.SideProject.domain.member.Note;
import AllFun.SideProject.domain.member.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note,Long> {
    Optional<Note> findFirstByRoomOrderByCreatedDateDesc(Room room);

    Optional<List<Note>> findAllByRoomOrderByCreatedDateDesc(Room room);
}
