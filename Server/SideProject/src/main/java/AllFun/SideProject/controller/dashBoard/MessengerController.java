package AllFun.SideProject.controller.dashBoard;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard/{dashId}/messenger")
@RequiredArgsConstructor
public class MessengerController {

    /**
     * get group messenger list data
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<?> groupMessage(){
        return null;
    }

    /**
     * send message
     * @return
     */
    @PostMapping("/{memberId}")
    public ResponseEntity<?> sendMessage(){
        return null;
    }
}
