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
     *
     * @return
     */
    @GetMapping("/calendar")
    public ResponseEntity<?> totalCalendar(){
        return null;
    }
}
