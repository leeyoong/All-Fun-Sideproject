package AllFun.SideProject.repository.dashBoard;

import AllFun.SideProject.domain.dashBoard.BoardHit;
import AllFun.SideProject.domain.dashBoard.GroupBoard;
import AllFun.SideProject.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardHitRepository extends JpaRepository<BoardHit,Long> {
    Optional<BoardHit> findByGroupBoardAndMember(GroupBoard groupBoard, Member member);
}
