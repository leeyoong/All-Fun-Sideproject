package AllFun.SideProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 쪽지 API
@RestController
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {

    /**
     * 내가 쪽지보낸 사용자 리스트
     * @return
     */
    @GetMapping("/list/{myId}")
    public ResponseEntity<?> myNoteList(){
        return null;
    }

    /**
     * [userId] 에 해당하는 사람과 나눈 쪽지 리스트
     * @return
     */
    @GetMapping("/list/{myId}/{userId}")
    public ResponseEntity<?> getUserIdList(){
        return null;
    }

    /**
     * 쪽지 보내기
     * @return
     */
    @PostMapping("/from/{myId}/to/{userId}")
    public ResponseEntity<?> sendNote(){
        return null;
    }
}
