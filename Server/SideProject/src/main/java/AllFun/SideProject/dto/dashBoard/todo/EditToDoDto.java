package AllFun.SideProject.dto.dashBoard.todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class EditToDoDto {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String title;
}
