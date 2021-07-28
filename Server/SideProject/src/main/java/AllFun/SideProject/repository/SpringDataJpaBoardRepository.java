package AllFun.SideProject.repository;

import AllFun.SideProject.domain.matching.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataJpaBoardRepository extends JpaRepository<Board, Long> {
    Optional<List<Board>> findByTitleContaining(String title);
    Optional<List<Board>> findByNicknameContaining(String nickname);
    Optional<List<Board>> findByContentContaining(String content);
}
