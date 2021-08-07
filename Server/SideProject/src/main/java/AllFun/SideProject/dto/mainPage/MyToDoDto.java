package AllFun.SideProject.dto.mainPage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class MyToDoDto {
    private LocalDateTime endDateTime;
    private String groupName;
    private String title;

}
