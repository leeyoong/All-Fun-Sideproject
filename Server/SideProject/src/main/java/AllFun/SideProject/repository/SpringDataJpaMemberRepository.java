package AllFun.SideProject.repository;

import AllFun.SideProject.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
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
     * @param gender
     * @return
     */
    Optional<Member> findByNameAndBirthAndPhoneAndGender(String name, String birth, String phone, String gender);

    /**
     * find user password
     * @param name
     * @param birth
     * @param phone
     * @param gender
     * @param email
     * @return
     */
    Optional<Member> findByNameAndBirthAndPhoneAndGenderAndEmail
                        (String name, String birth, String phone, String gender,String email);
}
