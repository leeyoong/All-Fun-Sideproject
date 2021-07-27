package AllFun.SideProject.repository;

import AllFun.SideProject.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long> {

    /**
     * check duplicated email
     * @param email
     * @return
     */
    Optional<Member> findByEmail(String email);

    /**
     * check duplicated nickname
     * @param nickname
     * @return
     */
    Optional<Member> findByNickname(String nickname);

    /**
     * find user email
     * @param name
     * @param birth
     * @param phone
     * @return
     */
    Optional<Member> findByNameAndBirthAndPhone(String name, String birth, String phone);

    /**
     * find user password
     * @param name
     * @param birth
     * @param phone
     * @param email
     * @return
     */
    Optional<Member> findByNameAndBirthAndPhoneAndEmail
                        (String name, String birth, String phone,String email);
}
