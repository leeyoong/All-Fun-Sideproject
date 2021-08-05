package AllFun.SideProject.controller;

import AllFun.SideProject.domain.member.Note;
import AllFun.SideProject.domain.member.Room;
import AllFun.SideProject.dto.note.NoteDataDto;
import AllFun.SideProject.dto.note.NoteRoomDto;
import AllFun.SideProject.service.member.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 쪽지 API
@RestController
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;
    /**
     * 내가 쪽지보낸 사용자 리스트
     * @return
     */
    @GetMapping("/list/{myId}")
    public ResponseEntity<?> myNoteList(@PathVariable("myId")Long myMemberId){
        List<NoteRoomDto> response = noteService.getNoteRoom(myMemberId);
        return ResponseEntity.ok(response);
    }

    /**
     * [userId] 에 해당하는 사람과 나눈 쪽지 리스트
     * @return
     */
    @GetMapping("/list/{roomId}")
    public ResponseEntity<?> getUserIdList(@PathVariable("roomId")Long roomId){
        List<NoteDataDto> response = noteService.getNoteData(roomId);
        return ResponseEntity.ok(response);
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
