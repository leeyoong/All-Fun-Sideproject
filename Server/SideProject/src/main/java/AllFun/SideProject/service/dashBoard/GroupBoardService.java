package AllFun.SideProject.service.dashBoard;

import AllFun.SideProject.domain.dashBoard.DashGroup;
import AllFun.SideProject.domain.dashBoard.GroupBoard;
import AllFun.SideProject.dto.mainPage.MyGroupBoardDto;
import AllFun.SideProject.dto.mainPage.MyGroupDto;
import AllFun.SideProject.repository.dashBoard.GroupBoardRepository;
import lombok.RequiredArgsConstructor;
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
}
