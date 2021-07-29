package AllFun.SideProject.controller.DashBoard;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard/{dashId}/calendar")
@RequiredArgsConstructor
public class GroupBoardController {

    /**
     * get calendar data
     * @return
     */
    @GetMapping("/get")
    public ResponseEntity<?> groupCalendar(){
        return null;
    }

    /**
     * post calendar data
     * @return
     */
    @PostMapping("/post")
    public ResponseEntity<?> postCalendar(){
        return null;
    }

    /**
     * edit calendar data
     * @return
     */
    @PostMapping("/edit/{calendarId}")
    public ResponseEntity<?> editCalendar(){
        return null;
    }

    /**
     * delete calendar data
     * @return
     */
    @PostMapping("/delete/{calendarId}")
    public ResponseEntity<?> deleteCalendar(){
        return null;
    }
}
