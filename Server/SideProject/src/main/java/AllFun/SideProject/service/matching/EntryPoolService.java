package AllFun.SideProject.service.matching;

import AllFun.SideProject.domain.base.GroupMemberStatus;
import AllFun.SideProject.domain.base.MatchingStatus;
import AllFun.SideProject.domain.dashBoard.DashGroup;
import AllFun.SideProject.domain.dashBoard.GroupMember;
import AllFun.SideProject.domain.matching.Board;
import AllFun.SideProject.domain.matching.EntryPool;
import AllFun.SideProject.domain.member.Member;
import AllFun.SideProject.repository.dashBoard.GroupMemberRepository;
import AllFun.SideProject.repository.matching.EntryPoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EntryPoolService {
    private final EntryPoolRepository entryPoolRepository;
    private final GroupMemberRepository groupMemberRepository;
    /**
     * create entry pool
     * @param entryPool
     */
    @Transactional
    public void save(EntryPool entryPool){
        entryPoolRepository.save(entryPool);
    }

    /**
     * delete entry pool
     * @param board
     * @param member
     * @param role
     * @return
     */
    @Transactional
    public String deleteEntryPool(Board board, Member member, String role){
        EntryPool entryPool = entryPoolRepository.findByBoardAndMemberAndRole(board, member, role)
                .orElse(null);
        if (entryPool == null){
            return null;
        }
        entryPoolRepository.delete(entryPool);
        return "ok";
    }

    @Transactional
    public void changeStatus(Board board, Member member, String role, MatchingStatus status){
        Optional<EntryPool> entryPool = entryPoolRepository.findByBoardAndMemberAndRole(board, member, role);
        entryPool.ifPresent(selectEntry->{
            selectEntry.setStatus(status);
            entryPoolRepository.save(selectEntry);
        });

        // 멤버 추가
        if(status.equals(MatchingStatus.ACCEPT)){
            DashGroup dashGroup = board.getGroup();
            GroupMember groupMember = GroupMember.createGroupMember();
            groupMember.setStatus(GroupMemberStatus.OTHER);
            dashGroup.addGroupMember(groupMember);
            member.addGroupMember(groupMember);
            groupMemberRepository.save(groupMember);
        }
    }

    @Transactional
    public void changeBatchStatus(Board board, String role){
        List<EntryPool> entryPools = findAllByBoardAndRole(board, role);
        for (EntryPool entryPool : entryPools) {
            entryPool.setStatus(MatchingStatus.FAIL);
            entryPoolRepository.save(entryPool);
        }
    }

    public List<EntryPool> findAllByBoardAndRole(Board board, String role){
        return entryPoolRepository.findAllByBoardAndRole(board, role).orElse(null);
    }



}
