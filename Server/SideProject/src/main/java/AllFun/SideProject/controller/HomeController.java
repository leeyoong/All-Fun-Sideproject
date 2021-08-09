package AllFun.SideProject.controller;

import AllFun.SideProject.domain.dashBoard.DashGroup;
import AllFun.SideProject.domain.matching.Board;
import AllFun.SideProject.dto.mainPage.*;
import AllFun.SideProject.service.dashBoard.DashGroupService;
import AllFun.SideProject.service.dashBoard.GroupBoardService;
import AllFun.SideProject.service.dashBoard.GroupMemberService;
import AllFun.SideProject.service.dashBoard.ToDoService;
import AllFun.SideProject.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/home/{memberId}")
@RequiredArgsConstructor
public class HomeController {
    private final DashGroupService dashGroupService;
    private final GroupMemberService groupMemberService;
    private final ToDoService toDoService;
    private final MemberService memberService;
    private final GroupBoardService groupBoardService;


    /**
     * 월별 그룹 일정 보기
     * @param memberId
     * @param year
     * @param month
     * @return
     */
    @GetMapping("/todo/{year}/{month}")
    public ResponseEntity<?> getMonthTodo(@PathVariable("memberId")Long memberId, @PathVariable("year")String year,
                                        @PathVariable("month")String month){
        if(month.length()==1)
            month="0"+month;

        LocalDateTime startDateTime = LocalDateTime.parse(year+"-"+month+"-"+"01 00:00:00",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime endDateTime = startDateTime.plusMonths(1).minusSeconds(1);

        List<DashGroup> dashGroups = groupMemberService.getDashGroup(memberId);
        // 아직 그룹이 없는 경우
        if (dashGroups==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        // 그룹이 있는 경우
        List<MyToDoDto> response = toDoService.getGroupTodo(dashGroups, startDateTime, endDateTime);

        // 일정이 없는 경우
        if(response == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(response);
    }

    /**
     * 내가 쓴 매칭 글
     * @param memberId
     * @return
     */
    @GetMapping("/matching/board")
    public ResponseEntity<?> getMyMatchingBoard(@PathVariable("memberId")Long memberId){
        List<MyMatchingBoardDto> response = memberService.getMyMatchingBoard(memberId);
        if(response == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(response);
    }

    /**
     * 내가 신청한 매칭글에 대한 결과
     * @param memberId
     * @return
     */
    @GetMapping("/matching/status")
    public ResponseEntity<?> getMyMatchingStatus(@PathVariable("memberId")Long memberId){
        List<MyMatchingStatusDto> response = memberService.getMyMatchingStatus(memberId);
        if(response == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(response);
    }

    /**
     * 스크랩한 게시판
     * @param memberId
     * @return
     */
    @GetMapping("/matching/scrap")
    public ResponseEntity<?> getMatchingScrap(@PathVariable("memberId")Long memberId){
        List<MyScrapDto> response = memberService.getScrapMatchingBoard(memberId);
        if(response == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(response);
    }

    /**
     * 그룹게시판 5개(통합 최신순 5개)
     * @param memberId
     * @return
     */
    @GetMapping("/group/board")
    public ResponseEntity<?> getGroupBoardIntegrated(@PathVariable("memberId")Long memberId){
        List<DashGroup> dashGroups = groupMemberService.getDashGroup(memberId);
        if(dashGroups == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<MyGroupBoardDto> response = groupBoardService.getGroupBoardIntegrated(dashGroups);
        return ResponseEntity.ok(response);
    }

    /**
     * 내가 읽지 않은 게시판
     */
    @GetMapping("/group/board/no/hit")
    public  ResponseEntity<?> boardNoHit(@PathVariable("memberId")Long memberId){
        List<MyNoHitBoardDto> response = groupBoardService.noHitBoardList(memberId);
        return ResponseEntity.ok(response);
    }

}
