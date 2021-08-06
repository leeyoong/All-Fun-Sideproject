package AllFun.SideProject.dto.dashBoard;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class MessengerListDto {
    private Long memberId;

    private String memberImg; //임시
    private String memberNickname;

    private String message;
    private LocalDateTime createdDate;

}
