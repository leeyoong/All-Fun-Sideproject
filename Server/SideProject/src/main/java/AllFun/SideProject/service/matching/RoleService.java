package AllFun.SideProject.service.matching;

import AllFun.SideProject.domain.matching.Role;
import AllFun.SideProject.repository.matching.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RoleService {
    private final RoleRepository roleRepository;

    public Role findById (Long id){
        return roleRepository.findById(id)
                .orElse(null);
    }
}
