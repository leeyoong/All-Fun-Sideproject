package AllFun.SideProject.repository;

import AllFun.SideProject.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long> {

}
