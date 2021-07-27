package AllFun.SideProject.repository;

import AllFun.SideProject.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataJpaBoardRepository extends JpaRepository<Board, Long> {
    Optional<List<Board>> findByTitleContainingOrderByCreateDesc(String title);
    Optional<List<Board>> findByNicknameContainingOrderByCreateDesc(String nickname);
    Optional<List<Board>> findByContentContainingOrderByCreateDesc(String content);
    Optional<List<Board>> findAllOrderByCreateDesc();
}
