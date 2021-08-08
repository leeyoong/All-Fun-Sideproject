package AllFun.SideProject.service.dashBoard;

import AllFun.SideProject.domain.dashBoard.DashGroup;
import AllFun.SideProject.domain.dashBoard.ToDo;
import AllFun.SideProject.dto.dashBoard.todo.CreateToDoDto;
import AllFun.SideProject.dto.dashBoard.todo.EditToDoDto;
import AllFun.SideProject.dto.dashBoard.todo.GroupToDoDto;
import AllFun.SideProject.dto.mainPage.MyToDoDto;
import AllFun.SideProject.repository.dashBoard.DashGroupRepository;
import AllFun.SideProject.repository.dashBoard.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ToDoService {
    private final ToDoRepository toDoRepository;
    private final DashGroupRepository dashGroupRepository;
    public List<MyToDoDto> getGroupTodo(List<DashGroup> dashGroups,
                                        LocalDateTime startDateTime,
                                        LocalDateTime endDateTime){
        List<MyToDoDto> response = new ArrayList<>();
        for(DashGroup dashGroup:dashGroups){
            List<ToDo> toDos = toDoRepository.findAllByGroupAndEndDateBetween(dashGroup,
                                                                                startDateTime,
                                                                                endDateTime)
                                                                                .orElse(null);
            for (ToDo toDo : toDos) {
                MyToDoDto myToDoDto = new MyToDoDto(
                        toDo.getStartDate(),
                        toDo.getEndDate(),
                        dashGroup.getGroupName(),
                        toDo.getTitle()
                        );
                response.add(myToDoDto);
            }
        }
        return response;
    }

    @Transactional
    public void createTodo(Long groupId, CreateToDoDto request){
        DashGroup dashGroup = dashGroupRepository.findById(groupId).orElse(null);
        LocalDateTime start = LocalDateTime.parse(request.getStartTime(),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime end = LocalDateTime.parse(request.getEndTime(),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        ToDo toDo = ToDo.createToDo(request.getTitle(), start, end);
        dashGroup.addToDo(toDo);

        toDoRepository.save(toDo);

    }

    public List<GroupToDoDto> getToDoList(Long groupId, LocalDateTime startDateTime, LocalDateTime endDateTime){
        DashGroup dashGroup = dashGroupRepository.findById(groupId).orElse(null);
        List<ToDo> toDos = toDoRepository.findAllByGroupAndEndDateBetween(dashGroup,
                startDateTime,
                endDateTime)
                .orElse(null);

        List<GroupToDoDto> response = new ArrayList<>();

        for (ToDo toDo : toDos) {
            GroupToDoDto groupToDoDto = new GroupToDoDto(
                    toDo.getId(),
                    toDo.getStartDate(),
                    toDo.getEndDate(),
                    toDo.getTitle()
            );
            response.add(groupToDoDto);
        }
        return response;
    }

    public EditToDoDto getToDo(Long todoId){
        ToDo toDo = toDoRepository.findById(todoId).orElse(null);
        EditToDoDto response = new EditToDoDto(
                toDo.getStartDate(),
                toDo.getEndDate(),
                toDo.getTitle()
        );
        return response;
    }

    @Transactional
    public void editToDo(Long todoId, EditToDoDto request){
        ToDo toDo = toDoRepository.findById(todoId).orElse(null);
        toDo.setEndDate(request.getEndTime());
        toDo.setTitle(request.getTitle());

    }

    @Transactional
    public void deleteToDo(Long todoId){
        ToDo toDo = toDoRepository.findById(todoId).orElse(null);
        toDoRepository.delete(toDo);
    }
}
