package AllFun.SideProject.repository.dashBoard;

import AllFun.SideProject.domain.base.GroupMemberStatus;
import AllFun.SideProject.domain.dashBoard.GroupMember;
import AllFun.SideProject.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GroupMemberRepository extends JpaRepository<GroupMember,Long> {
    Optional<List<GroupMember>> findAllByMember(Member member);

    Optional<List<GroupMember>> findAllByMemberAndStatus(Member member, GroupMemberStatus status);
}
