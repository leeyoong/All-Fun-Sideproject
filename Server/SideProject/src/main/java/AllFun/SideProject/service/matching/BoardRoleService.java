package AllFun.SideProject.service.matching;

import AllFun.SideProject.domain.matching.BoardRole;
import AllFun.SideProject.repository.matching.BoardRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
