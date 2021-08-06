package AllFun.SideProject.repository.dashBoard;

import AllFun.SideProject.domain.base.BoardKinds;
import AllFun.SideProject.domain.dashBoard.DashGroup;
import AllFun.SideProject.domain.dashBoard.GroupBoard;
import AllFun.SideProject.domain.member.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GroupBoardRepository extends JpaRepository<GroupBoard,Long> {
    Optional<List<GroupBoard>> findAllByGroupOrderByCreatedDateDesc(DashGroup dashGroup);

    Optional<List<GroupBoard>> findAllByGroupAndKindsOrderByCreatedDateDesc(DashGroup dashGroup, BoardKinds kinds);

    Page<GroupBoard> findAllByGroupAndKinds(DashGroup dashGroup, BoardKinds kinds, Pageable pageable);
}
