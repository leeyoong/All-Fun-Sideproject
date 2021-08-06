package AllFun.SideProject.repository.dashBoard;

import AllFun.SideProject.domain.dashBoard.Comment;
import AllFun.SideProject.domain.dashBoard.GroupBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<List<Comment>> findAllByGroupBoardOrderByCreatedDateDesc(GroupBoard groupBoard);
}
