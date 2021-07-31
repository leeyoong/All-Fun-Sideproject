package AllFun.SideProject.controller.dashBoard;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard/{dashId}/todo")
@RequiredArgsConstructor
public class ToDoController {

    /**
     * Write To Do
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<?> create(){
        return null;
    }

    /**
     * get to-do list
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<?> toDoList(){
        return null;
    }

    /**
     * get to-do list detail
     * @return
     */
    @GetMapping("/list/{toDoId}")
    public ResponseEntity<?> toDoDetail(){
        return null;
    }

    /**
     * edit [todoId]
     * @return
     */
    @PostMapping("/edit/{todoId}")
    public ResponseEntity<?> editTodo(){
        return null;
    }

    /**
     * delete [todoId]
     * @return
     */
    @PostMapping("/delete/{todoId}")
    public ResponseEntity<?> deleteTodo(){
        return null;
    }
}
