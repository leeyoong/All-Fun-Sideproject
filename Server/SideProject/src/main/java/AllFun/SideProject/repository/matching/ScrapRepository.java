package AllFun.SideProject.repository.matching;

import AllFun.SideProject.domain.matching.Board;
import AllFun.SideProject.domain.matching.Scrap;
import AllFun.SideProject.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScrapRepository extends JpaRepository<Scrap, Long> {
    Optional<Scrap> findByMemberAndBoard(Member member, Board board);


}
