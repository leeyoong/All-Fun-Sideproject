package AllFun.SideProject.service.dashBoard;

import AllFun.SideProject.domain.dashBoard.DashGroup;
import AllFun.SideProject.domain.dashBoard.GroupMember;
import AllFun.SideProject.domain.member.Member;
import AllFun.SideProject.repository.dashBoard.GroupMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GroupMemberService {
    private final GroupMemberRepository groupMemberRepository;

    /**
     * get dash group id
     * @param member
     * @return
     */
    public List<DashGroup> getDashGroup(Member member){
        List<GroupMember> groupMembers = groupMemberRepository.findAllByMember(member).orElse(null);
        List<DashGroup> dashGroups = new ArrayList<>();
        for(GroupMember groupMember:groupMembers){
            dashGroups.add(groupMember.getGroup());
        }
        return dashGroups;
    }
}
