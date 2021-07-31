package AllFun.SideProject.repository.matching;

import AllFun.SideProject.domain.matching.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {

    /**
     * 제목으로 검색
     * @param title
     * @return
     */
    Optional<List<Board>> findByTitleContaining(String title);

    /**
     * 작성자로 검색
     * @param nickname
     * @return
     */
    Optional<List<Board>> findByNicknameContaining(String nickname);

    /**
     * 내용으로 검색
     * @param content
     * @return
     */
    Optional<List<Board>> findByContentContaining(String content);
}
