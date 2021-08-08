package AllFun.SideProject.dto.dashBoard.todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CreateToDoDto {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String title;
}
