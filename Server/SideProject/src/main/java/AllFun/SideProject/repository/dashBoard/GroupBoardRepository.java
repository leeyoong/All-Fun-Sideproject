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

    Optional<GroupBoard> findFirstByGroupAndKindsOrderByCreatedDateDesc(DashGroup dashGroup, BoardKinds kinds);

    Page<GroupBoard> findAllByGroup(DashGroup dashGroup, Pageable pageable);
}
