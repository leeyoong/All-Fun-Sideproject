package AllFun.SideProject.repository;

import AllFun.SideProject.domain.matching.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaRoleRepository extends JpaRepository<Role,Long> {
}
