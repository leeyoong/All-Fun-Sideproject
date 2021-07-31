package AllFun.SideProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {


    /**
     * 그룹별 공지 5개
     * @return List<Dto> / Dto -> groupName, notice(5개, 리스트 형식)
     */
    @GetMapping("/notice")
    public ResponseEntity<?> recentFiveNotice(){
        return null;
    }

    /**
     * 소속된 일정 전체보기 (월 별)
     * @return
     */
    @GetMapping("/calendar/{month}")
    public ResponseEntity<?> totalCalendar(){
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
