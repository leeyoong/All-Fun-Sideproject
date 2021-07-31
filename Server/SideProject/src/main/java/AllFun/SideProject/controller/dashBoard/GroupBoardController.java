package AllFun.SideProject.controller.dashBoard;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 그룹 게시판
 */

@RestController
@RequestMapping("/dashboard/{groupId}/board")
@RequiredArgsConstructor
public class GroupBoardController {

    /**
     * get board list
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<?> groupBoardList(){
        return null;
    }

    /**
     * groupBoardId detail = 게시판 클릭
     * @return
     */
    @GetMapping("/list/{groupBoardId}")
    public ResponseEntity<?> groupBoardDetail(){
        return null;
    }

    /**
     * create group board
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<?> createBoard(){
        return null;
    }

    /**
     * edit group board
     * @return
     */
    @PostMapping("/edit/{groupBoardId}")
    public ResponseEntity<?> editBoard(){
        return null;
    }

    /**
     * delete group board
     * @return
     */
    @PostMapping("/delete/{groupBoardId}")
    public ResponseEntity<?> deleteCalendar(){
        return null;
    }
}
