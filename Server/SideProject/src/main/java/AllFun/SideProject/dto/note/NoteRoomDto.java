package AllFun.SideProject.dto.note;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class NoteRoomDto {
    private Long roomId;

    private Long opponentId; // 상대방 id
    private String opponentNickname; // 상대방 닉네임
    private LocalDateTime recentNoteDate;
    private String recentMessage;
}
