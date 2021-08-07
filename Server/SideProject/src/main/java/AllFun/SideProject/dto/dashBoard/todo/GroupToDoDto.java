package AllFun.SideProject.dto.dashBoard.todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class GroupToDoDto {
    private Long todoId;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String title;
}
