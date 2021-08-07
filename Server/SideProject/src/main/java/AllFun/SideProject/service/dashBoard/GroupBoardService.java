package AllFun.SideProject.service.dashBoard;

import AllFun.SideProject.domain.base.BoardKinds;
import AllFun.SideProject.domain.base.HitStatus;
import AllFun.SideProject.domain.dashBoard.BoardHit;
import AllFun.SideProject.domain.dashBoard.DashGroup;
import AllFun.SideProject.domain.dashBoard.GroupBoard;
import AllFun.SideProject.domain.dashBoard.GroupMember;
import AllFun.SideProject.domain.member.Member;
import AllFun.SideProject.dto.dashBoard.groupBoard.CreateGroupBoardDto;
import AllFun.SideProject.dto.dashBoard.groupBoard.EditGroupBoardDto;
import AllFun.SideProject.dto.dashBoard.groupBoard.GroupBoardDetailDto;
import AllFun.SideProject.dto.dashBoard.groupBoard.GroupBoardListDto;
import AllFun.SideProject.dto.mainPage.MyGroupBoardDto;
import AllFun.SideProject.dto.mainPage.MyNoHitBoardDto;
import AllFun.SideProject.repository.dashBoard.BoardHitRepository;
import AllFun.SideProject.repository.dashBoard.DashGroupRepository;
import AllFun.SideProject.repository.dashBoard.GroupBoardRepository;
import AllFun.SideProject.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GroupBoardService {
    private final GroupBoardRepository groupBoardRepository;
    private final DashGroupRepository dashGroupRepository;
    private final MemberRepository memberRepository;
    private final BoardHitRepository boardHitRepository;

    /**
     * 내가 속한 그룹의 게시판중 최신 5개 반환
     * @param dashGroups
     * @return
     */
    public List<MyGroupBoardDto> getGroupBoardIntegrated(List<DashGroup> dashGroups){
        List<MyGroupBoardDto> response = new ArrayList<>();
        for (DashGroup dashGroup : dashGroups) {
            List<GroupBoard> groupBoards = groupBoardRepository.findAllByGroupOrderByCreatedDateDesc(dashGroup).orElse(null);
            int cnt = 0;
            for (GroupBoard groupBoard : groupBoards) {
                if (cnt < 5) {
                    MyGroupBoardDto myGroupBoardDto = new MyGroupBoardDto(
                            dashGroup.getGroupName(),
                            groupBoard.getId(),
                            groupBoard.getTitle(),
                            groupBoard.getMember().getNickname(),
                            groupBoard.getCreatedDate()
                    );
                    response.add(myGroupBoardDto);
                }else{
                    break;
                }
            }
        }
        Collections.sort(response, new Comparator<MyGroupBoardDto>() {
            public int compare(MyGroupBoardDto o1, MyGroupBoardDto o2) {
                if(o1.getCreatedDate().isAfter(o2.getCreatedDate())) {
                    return 1;
                }else if(o1.getCreatedDate().isBefore(o2.getCreatedDate())) {
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        if(response.size()<5)
            return response;
        response = response.subList(0,5);
        return response;
    }

    /**
     * {group Id} 의 그룹게시판 (pageable)
     * @param pageable
     * @param groupId
     * @return
     */
    public Page<GroupBoard> boardList(Pageable pageable, Long groupId){
        DashGroup dashGroup = dashGroupRepository.findById(groupId).orElse(null);
        Page<GroupBoard> groupBoards = groupBoardRepository.findAllByGroup(dashGroup, pageable);
        return groupBoards;
    }

    /**
     * {group Id} 의 그룹 게시판 리스트 (공지사항)
     * @param groupId
     * @return
     */
    public GroupBoardListDto boardNotice(Long groupId){
        DashGroup dashGroup = dashGroupRepository.findById(groupId).orElse(null);
        GroupBoard groupBoard = groupBoardRepository.findFirstByGroupAndKindsOrderByCreatedDateDesc(dashGroup,
                BoardKinds.NOTICE).orElse(null);
        GroupBoardListDto groupBoardListDto = new GroupBoardListDto(
                groupBoard.getId(),
                groupBoard.getMember().getId(),
                groupBoard.getMember().getNickname(),
                groupBoard.getTitle(),
                groupBoard.getCreatedDate(),
                groupBoard.getKinds()
        );
        return groupBoardListDto;
    }

    /**
     * get detail, member hit
     * @param groupBoardId
     * @param memberId
     * @return
     */
    @Transactional
    public GroupBoardDetailDto boardDetail(Long groupBoardId, Long memberId){
        GroupBoard groupBoard = groupBoardRepository.findById(groupBoardId).orElse(null);

        Member member = memberRepository.findById(memberId).orElse(null);
        BoardHit boardHit = boardHitRepository.findByGroupBoardAndMember(groupBoard, member).orElse(null);

        if(boardHit.getHit().equals(HitStatus.NOT_READ)){
            boardHit.setHit(HitStatus.READ);
            boardHitRepository.save(boardHit);
        }

        GroupBoardDetailDto response = new GroupBoardDetailDto(
                groupBoard.getId(),
                groupBoard.getTitle(),
                groupBoard.getContent(),
                groupBoard.getMember().getNickname(),
                groupBoard.getCreatedDate(),
                groupBoard.getMember().getId()
        );

        return response;
    }

    /**
     * create board
     * @param groupId
     * @param memberId
     * @param request
     */
    @Transactional
    public void createBoard(Long groupId, Long memberId, CreateGroupBoardDto request){
        DashGroup group = dashGroupRepository.findById(groupId).orElse(null);
        Member member = memberRepository.findById(memberId).orElse(null);

        GroupBoard groupBoard = GroupBoard.createGroupBoard(request.getTitle(), request.getContent(),
                request.getKinds(), member);
        group.addGroupBoard(groupBoard);
        groupBoardRepository.save(groupBoard);

        for(GroupMember groupMember : group.getGroupMembers()){
            BoardHit boardHit = BoardHit.createBoardHit();
            if(groupMember.getMember().getId() == memberId){
                boardHit.setHit(HitStatus.READ);
            }else{
                boardHit.setHit(HitStatus.NOT_READ);
            }
            groupMember.getMember().addBoardHit(boardHit);
            groupBoard.addBoardHit(boardHit);
            boardHitRepository.save(boardHit);
        }

    }

    /**
     * delete board
     * @param groupBoardId
     */
    @Transactional
    public void deleteBoard(Long groupBoardId){
        GroupBoard groupBoard = groupBoardRepository.findById(groupBoardId).orElse(null);
        groupBoardRepository.delete(groupBoard);
    }

    public EditGroupBoardDto getGroupBoardData(Long groupBoardId){
        GroupBoard groupBoard = groupBoardRepository.findById(groupBoardId).orElse(null);
        EditGroupBoardDto response = new EditGroupBoardDto(
                groupBoard.getId(),
                groupBoard.getTitle(),
                groupBoard.getContent()
        );
        return response;
    }

    @Transactional
    public void editGroupBoard(EditGroupBoardDto request){
        GroupBoard groupBoard = groupBoardRepository.findById(request.getGroupBoardId()).orElse(null);
        groupBoard.setTitle(request.getTitle());
        groupBoard.setContent(request.getContent());
        groupBoardRepository.save(groupBoard);
    }

    public List<MyNoHitBoardDto> noHitBoardList(Long memberId){
        Member member = memberRepository.findById(memberId).orElse(null);
        List<BoardHit> boardHits = member.getBoardHits();
        List<MyNoHitBoardDto> response = new ArrayList<>();
        for (BoardHit boardHit : boardHits) {
            MyNoHitBoardDto myNoHitBoardDto = new MyNoHitBoardDto(
                    boardHit.getGroupBoard().getGroup().getId(),
                    boardHit.getGroupBoard().getId(),
                    boardHit.getGroupBoard().getTitle(),
                    boardHit.getGroupBoard().getContent(),
                    boardHit.getGroupBoard().getCreatedDate(),
                    boardHit.getGroupBoard().getMember().getId(),
                    boardHit.getGroupBoard().getMember().getNickname(),
                    boardHit.getGroupBoard().getGroup().getGroupName(),
                    boardHit.getGroupBoard().getKinds()
            );
            response.add(myNoHitBoardDto);
        }
        return response;
    }

}
