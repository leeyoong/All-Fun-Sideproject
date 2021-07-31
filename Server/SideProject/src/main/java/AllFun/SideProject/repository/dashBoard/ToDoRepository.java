package AllFun.SideProject.repository.dashBoard;

import AllFun.SideProject.domain.dashBoard.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo,Long> {
}
