package AllFun.SideProject.service.dashBoard;

import AllFun.SideProject.domain.dashBoard.DashGroup;
import AllFun.SideProject.domain.dashBoard.ToDo;
import AllFun.SideProject.dto.mainPage.MyToDoDto;
import AllFun.SideProject.repository.dashBoard.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ToDoService {
    private final ToDoRepository toDoRepository;

    public List<MyToDoDto> getGroupTodo(List<DashGroup> dashGroups,
                                        LocalDateTime startDateTime,
                                        LocalDateTime endDateTime){
        List<MyToDoDto> response = new ArrayList<>();
        for(DashGroup dashGroup:dashGroups){
            List<ToDo> toDos = toDoRepository.findAllByDashGroupAndEndDateBetween(dashGroup,
                                                                                startDateTime,
                                                                                endDateTime)
                                                                                .orElse(null);
            for (ToDo toDo : toDos) {
                MyToDoDto myToDoDto = new MyToDoDto(
                        toDo.getEndDate(),
                        dashGroup.getGroupName(),
                        toDo.getTitle(),
                        toDo.getContent()
                        );
                response.add(myToDoDto);
            }
        }
        return response;
    }
}
