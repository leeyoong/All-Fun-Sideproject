package AllFun.SideProject.repository.matching;

import AllFun.SideProject.domain.base.RoleType;
import AllFun.SideProject.domain.matching.Board;
import AllFun.SideProject.domain.matching.BoardRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRoleRepository extends JpaRepository<BoardRole, Long> {

    Optional<List<BoardRole>> findAllByBoard(Board board);

    /**
     * role type filter (get board)
     * @param roleType
     * @return
     */
    Page<BoardRole> findAllByRole(RoleType roleType, Pageable pageable);
}
