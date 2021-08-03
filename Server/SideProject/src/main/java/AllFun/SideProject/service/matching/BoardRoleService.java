package AllFun.SideProject.service.matching;

import AllFun.SideProject.domain.base.RoleType;
import AllFun.SideProject.domain.matching.Board;
import AllFun.SideProject.domain.matching.BoardRole;
import AllFun.SideProject.repository.matching.BoardRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardRoleService {
    private final BoardRoleRepository boardRoleRepository;

    /**
     * create (board - proj member - role)
     * @param boardRole
     */
    @Transactional
    public void save(BoardRole boardRole){
        boardRoleRepository.save(boardRole);
    }

    /**
     * get board - role type
     * @param board
     * @return
     */
    public List<RoleType> getRoleType(Board board){
        List<BoardRole> boardRoles = boardRoleRepository.findAllByBoard(board).orElse(null);
        List<RoleType> response = new ArrayList<>();
        for (BoardRole boardRole : boardRoles) {
            if(boardRole.getHope() != 0)
                response.add(boardRole.getRole());
        }
        return response;
    }
}
