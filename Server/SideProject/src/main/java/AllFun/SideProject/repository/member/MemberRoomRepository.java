package AllFun.SideProject.repository.member;

import AllFun.SideProject.domain.member.Member;
import AllFun.SideProject.domain.member.MemberRoom;
import AllFun.SideProject.domain.member.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRoomRepository extends JpaRepository<MemberRoom,Long> {
    Optional<MemberRoom> findByRoomAndMemberNot(Room room, Member member);


}
