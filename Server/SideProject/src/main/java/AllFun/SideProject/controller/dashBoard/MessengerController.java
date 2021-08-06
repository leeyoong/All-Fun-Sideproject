package AllFun.SideProject.controller.dashBoard;

import AllFun.SideProject.dto.dashBoard.MessengerListDto;
import AllFun.SideProject.service.dashBoard.MessengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard/{groupId}/messenger")
@RequiredArgsConstructor
public class MessengerController {
    private final MessengerService messengerService;
    /**
     * get group messenger list data
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<?> groupMessage(@PathVariable("groupId") Long groupId){
        List<MessengerListDto> response = messengerService.getMessengerList();
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
