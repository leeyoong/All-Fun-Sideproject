package AllFun.SideProject.service.dashBoard;

import AllFun.SideProject.domain.base.GroupMemberStatus;
import AllFun.SideProject.domain.dashBoard.DashGroup;
import AllFun.SideProject.domain.dashBoard.GroupMember;
import AllFun.SideProject.domain.member.Member;
import AllFun.SideProject.dto.matching.CreateBoardPossibleDto;
import AllFun.SideProject.repository.dashBoard.GroupMemberRepository;
import AllFun.SideProject.repository.member.MemberRepository;
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
    private final MemberRepository memberRepository;
    /**
     * get dash group id
     * @param memberId
     * @return
     */
    public List<DashGroup> getDashGroup(Long memberId){
        Member member = memberRepository.findById(memberId).orElse(null);
        List<GroupMember> groupMembers = groupMemberRepository.findAllByMember(member).orElse(null);
        List<DashGroup> dashGroups = new ArrayList<>();
        for(GroupMember groupMember:groupMembers){
            dashGroups.add(groupMember.getGroup());
        }
        return dashGroups;
    }

    /**
     * get dash group id (only owner)
     * @param memberId
     * @return
     */
    public List<DashGroup> getDashGroupOwner(Long memberId){
        Member member = memberRepository.findById(memberId).orElse(null);
        List<GroupMember> groupMembers = groupMemberRepository.findAllByMemberAndStatus
                (member, GroupMemberStatus.OWNER).orElse(null);
        List<DashGroup> dashGroups = new ArrayList<>();
        for(GroupMember groupMember:groupMembers){
            dashGroups.add(groupMember.getGroup());
        }
        return dashGroups;
    }
}
