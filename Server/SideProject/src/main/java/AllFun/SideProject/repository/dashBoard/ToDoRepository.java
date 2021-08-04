package AllFun.SideProject.repository.dashBoard;

import AllFun.SideProject.domain.dashBoard.DashGroup;
import AllFun.SideProject.domain.dashBoard.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ToDoRepository extends JpaRepository<ToDo,Long> {
    /**
     * use groupId and between startDateTime and endDateTime
     * @param dashGroup
     * @param startDateTime
     * @param endDateTime
     * @return
     */
    Optional<List<ToDo>> findAllByGroupAndEndDateBetween(DashGroup dashGroup,
                                                             LocalDateTime startDateTime,
                                                             LocalDateTime endDateTime);
}
