package AllFun.SideProject.repository.dashBoard;

import AllFun.SideProject.domain.dashBoard.Messenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessengerRepository extends JpaRepository<Messenger, Long> {
}
