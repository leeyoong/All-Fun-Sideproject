package AllFun.SideProject.controller.dashBoard;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class GroupController {

    /**
     * get dashboard main page (show group)
     * @return
     */
    @GetMapping("/main")
    public ResponseEntity<?> dashMain(){
        return null;
    }

    // POST ; create group -> 매칭글 작성
    // DELETE : delete group
    // 멤버 추가 -> matching board 에서 승인된 인원 충원

}
