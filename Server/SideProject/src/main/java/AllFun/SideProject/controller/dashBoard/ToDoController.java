package AllFun.SideProject.controller.dashBoard;

import AllFun.SideProject.dto.dashBoard.todo.CreateToDoDto;
import AllFun.SideProject.dto.dashBoard.todo.EditToDoDto;
import AllFun.SideProject.dto.dashBoard.todo.GroupToDoDto;
import AllFun.SideProject.service.dashBoard.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/dashboard/{groupId}/todo")
@RequiredArgsConstructor
public class ToDoController {
    private final ToDoService toDoService;
    /**
     * Write To Do
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<?> create(@PathVariable("groupId")Long groupId, @RequestBody CreateToDoDto request){
        toDoService.createTodo(groupId, request);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * get to-do list
     * @return
     */
    @GetMapping("/list/{year}/{month}")
    public ResponseEntity<?> toDoList(@PathVariable("groupId")Long groupId, @PathVariable("year")String year,
                                      @PathVariable("month")String month){
        LocalDateTime startDateTime = LocalDateTime.parse(year+"-"+month+"-"+"1 00:00:00",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime endDateTime = startDateTime.plusMonths(1).minusSeconds(1);

        List<GroupToDoDto> response = toDoService.getToDoList(groupId, startDateTime, endDateTime);

        return ResponseEntity.ok(response);
    }

    /**
     * get to-do list detail
     * @return
     */

    /*
    @GetMapping("/list/{toDoId}")
    public ResponseEntity<?> toDoDetail(){
        return null;
    }
     */
    /**
     * edit [todoId] (get)
     * @return
     */
    @GetMapping("/edit/{todoId}")
    public ResponseEntity<?> getEditTodo(@PathVariable("todoId")Long todoId){
        EditToDoDto response = toDoService.getToDo(todoId);
        return ResponseEntity.ok(response);
    }

    /**
     * edit [todoId] (patch)
     * @return
     */
    @PatchMapping("/edit/{todoId}")
    public ResponseEntity<?> editTodo(@PathVariable("todoId")Long todoId,
                                      @RequestBody EditToDoDto request){
        toDoService.editToDo(todoId, request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * delete [todoId]
     * @return
     */
    @PostMapping("/delete/{todoId}")
    public ResponseEntity<?> deleteTodo(@PathVariable("todoId")Long todoId){
        toDoService.deleteToDo(todoId);
        return null;
    }
}
