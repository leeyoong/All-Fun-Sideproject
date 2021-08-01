package AllFun.SideProject.controller;

import AllFun.SideProject.domain.dashBoard.DashGroup;
import AllFun.SideProject.domain.member.Member;
import AllFun.SideProject.dto.mainPage.MyGroupDto;
import AllFun.SideProject.repository.member.MemberRepository;
import AllFun.SideProject.service.dashBoard.DashGroupService;
import AllFun.SideProject.service.dashBoard.GroupMemberService;
import AllFun.SideProject.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/home/{memberId}")
@RequiredArgsConstructor
public class HomeController {
    private final MemberService memberService;
    private final DashGroupService dashGroupService;
    private final GroupMemberService groupMemberService;

    /**
     * my group
     * @param memberId
     * @return
     */
    @GetMapping("/group")
    public ResponseEntity<?> getMyGroup(@PathVariable("memberId")Long memberId){
        Member member = memberService.findById(memberId);
        List<DashGroup> dashGroups = groupMemberService.getDashGroup(member);

        // 아직 그룹이 없는 경우
        if (dashGroups==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        // 그룹이 있는 경우
        List<MyGroupDto> response = new ArrayList<>();
        for(DashGroup dashGroup : dashGroups){
            MyGroupDto myGroupDto = new MyGroupDto(dashGroup.getId(),dashGroup.getGroupName());
            response.add(myGroupDto);
        }
        return ResponseEntity.ok(response);
    }

    /**
     * 소속된 일정 전체보기 (월 별)
     * @return
     */
    @GetMapping("/todo/{year}/{month}")
    public ResponseEntity<?> getMonthTodo(@PathVariable("memberId")Long memberId, @PathVariable("year")String year,
                                        @PathVariable("month")String month){
        LocalDateTime startDateTime = LocalDateTime.parse(year+"-"+month+"-"+"1 00:00:00",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime endDateTime = startDateTime.plusMonths(1).minusSeconds(1);

        return null;
    }



    /**
     * 내가 신청한 매칭 게시판 현황 (진행중, 실패, 성공)
     * @return
     */
    @GetMapping("/matching")
    public ResponseEntity<?> matchingBoard(){
        return null;
    }

}
