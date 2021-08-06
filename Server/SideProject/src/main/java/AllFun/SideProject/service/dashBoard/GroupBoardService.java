package AllFun.SideProject.service.dashBoard;

import AllFun.SideProject.domain.base.BoardKinds;
import AllFun.SideProject.domain.dashBoard.DashGroup;
import AllFun.SideProject.domain.dashBoard.GroupBoard;
import AllFun.SideProject.domain.matching.Board;
import AllFun.SideProject.dto.dashBoard.GroupBoardListDto;
import AllFun.SideProject.dto.mainPage.MyGroupBoardDto;
import AllFun.SideProject.dto.mainPage.MyGroupDto;
import AllFun.SideProject.repository.dashBoard.DashGroupRepository;
import AllFun.SideProject.repository.dashBoard.GroupBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        Page<GroupBoard> groupBoards = groupBoardRepository.findAllByGroupAndKinds(dashGroup, BoardKinds.NORMAL, pageable);
        return groupBoards;
    }

    /**
     * {group Id} 의 그룹 게시판 리스트 (공지사항)
     * @param groupId
     * @return
     */
    public List<GroupBoardListDto> boardNotice(Long groupId){
        DashGroup dashGroup = dashGroupRepository.findById(groupId).orElse(null);
        List<GroupBoard> groupBoards = groupBoardRepository.findAllByGroupAndKindsOrderByCreatedDateDesc(dashGroup,
                BoardKinds.NOTICE).orElse(null);
        List<GroupBoardListDto> response = new ArrayList<>();
        for (GroupBoard groupBoard : groupBoards) {
            response.add(
                    new GroupBoardListDto(
                            groupBoard.getId(),
                            groupBoard.getMember().getId(),
                            groupBoard.getMember().getNickname(),
                            groupBoard.getTitle(),
                            groupBoard.getCreatedDate(),
                            groupBoard.getKinds()
                    )
            );
        }
        return response;
    }

}
