package AllFun.SideProject.dto.note;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class NoteDataDto {
    private Long sendMemberId;
    private String sendMemberNickname;
    private String sendMemberImg; // 일단 str 처리
    private String sendMessage;
    private LocalDateTime sendTime;
}
