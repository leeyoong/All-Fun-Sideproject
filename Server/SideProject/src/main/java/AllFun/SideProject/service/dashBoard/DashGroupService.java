package AllFun.SideProject.service.dashBoard;

import AllFun.SideProject.domain.base.GroupMemberStatus;
import AllFun.SideProject.domain.dashBoard.DashGroup;
import AllFun.SideProject.domain.dashBoard.GroupMember;
import AllFun.SideProject.domain.member.Member;
import AllFun.SideProject.dto.dashBoard.group.MyGroupListDto;
import AllFun.SideProject.dto.mainPage.MyGroupDto;
import AllFun.SideProject.repository.dashBoard.DashGroupRepository;
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
public class DashGroupService {
    private final DashGroupRepository dashGroupRepository;
    private final MemberRepository memberRepository;
    private final GroupMemberRepository groupMemberRepository;

    public DashGroup findById(Long groupId){
        return dashGroupRepository.findById(groupId)
                .orElse(null);
    }

    public List<MyGroupListDto>  getMyGroups(Long memberId){
        Member member = memberRepository.findById(memberId).orElse(null);
        List<GroupMember> groupMembers = member.getGroupMembers();
        List<MyGroupListDto> response = new ArrayList<>();
        for (GroupMember groupMember : groupMembers) {
            MyGroupListDto myGroupListDto = new MyGroupListDto(
                    groupMember.getGroup().getId(),
                    groupMember.getGroup().getGroupName()

            );
            response.add(myGroupListDto);
        }
        return response;
    }

    @Transactional
    public void createGroup(Long memberId, String groupName){
        Member member = memberRepository.findById(memberId).orElse(null);
        DashGroup dashGroup = DashGroup.createDashGroup(groupName);
        dashGroupRepository.save(dashGroup);

        GroupMember groupMember = GroupMember.createGroupMember();
        groupMember.setMember(member);
        groupMember.setStatus(GroupMemberStatus.OWNER);
        dashGroup.addGroupMember(groupMember);
        groupMemberRepository.save(groupMember);
    }

    @Transactional
    public void deleteGroup(Long groupId){
        DashGroup dashGroup = dashGroupRepository.findById(groupId).orElse(null);
        dashGroupRepository.delete(dashGroup);
    }
}
