package AllFun.SideProject.dto.dashBoard.todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CreateToDoDto {
    private String startTime;
    private String endTime;
    private String title;
}
