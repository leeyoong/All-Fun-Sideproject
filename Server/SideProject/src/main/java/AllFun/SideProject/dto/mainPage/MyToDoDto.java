package AllFun.SideProject.dto.mainPage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class MyToDoDto {
    private LocalDateTime startDateTime;//8/8
    private LocalDateTime endDateTime;//8/15

    private String groupName;
    private String title;

}
