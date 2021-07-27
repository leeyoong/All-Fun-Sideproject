package AllFun.SideProject.repository;

import AllFun.SideProject.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaBoardRepository extends JpaRepository<Board, Long> {
}
