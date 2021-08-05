package AllFun.SideProject.repository.matching;

import AllFun.SideProject.domain.matching.Board;
import AllFun.SideProject.domain.matching.EntryPool;
import AllFun.SideProject.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntryPoolRepository extends JpaRepository<EntryPool, Long> {
    Optional<EntryPool> findByBoardAndMemberAndRole(Board board, Member member, String role);
}
