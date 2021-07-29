package AllFun.SideProject.service;

import AllFun.SideProject.domain.matching.Role;
import AllFun.SideProject.repository.SpringDataJpaRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RoleService {
    private final SpringDataJpaRoleRepository roleRepository;

    public Role findById (Long id){
        return roleRepository.findById(id)
                .orElse(null);
    }
}
