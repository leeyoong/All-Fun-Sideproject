package AllFun.SideProject.repository;

import AllFun.SideProject.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long> {

    /**
     * 이메일 검색
     * @param email
     * @return
     */
    Optional<Member> findByEmail(String email);

    /**
     * 닉네임 검색
     * @param nickname
     * @return
     */
    Optional<List<Member>> findByNickname(String nickname);

}
