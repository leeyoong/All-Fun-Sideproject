package AllFun.SideProject.controller;

import AllFun.SideProject.domain.Board;
import AllFun.SideProject.dto.board.CreateBoardDto;
import AllFun.SideProject.dto.board.EditBoardDto;
import AllFun.SideProject.dto.board.ReadDetailDto;
import AllFun.SideProject.dto.board.SearchRequestDto;
import AllFun.SideProject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    /**
     * Write Side-Project board
     * @param request
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateBoardDto request){
        Board newBoard = Board.createBoard(
                request.getNickname(),
                request.getTitle(),
                request.getContent(),
                request.getProjectMembers()
                );
        CreateBoardDto response = boardService.save(newBoard);
        return ResponseEntity.ok(response);
    }

    /**
     * get board list (recently)
     * @return
     */
    @GetMapping("/list/recent")
    public ResponseEntity<?> listRecent(){

        return ResponseEntity.ok(null);
    }

    /**
     * Read Detail Board and Increase hit.
     * @param id
     * @return
     */
    @GetMapping("/{id}/detail")
    public ResponseEntity<?> readDetail(@PathVariable("id") Long id){
        Board find = boardService.findById(id);
        if (find==null){
            HashMap<String, String> result = new HashMap<String,String>();
            result.put("Error","Wrong Board Id");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        } else{
            System.out.println("기존 조회수 : "+find.getHit());
            ReadDetailDto response = boardService.readDetail(id);
            System.out.println("올라간 조회수 : "+response.getHit());
            return ResponseEntity.ok(response);
        }
    }

    /**
     * Search by Title
     * @param request
     * @return
     */
    @GetMapping("/search/title")
    public ResponseEntity<?> searchTitle(@RequestBody SearchRequestDto request){
        return ResponseEntity.ok(null);
    }

    /**
     * Search By Content
     * @param request
     * @return
     */
    @GetMapping("/search/content")
    public ResponseEntity<?> searchContent(@RequestBody SearchRequestDto request){
        return ResponseEntity.ok(null);
    }

    /**
     * Search By Writer
     * @param request
     * @return
     */
    @GetMapping("search/writer")
    public ResponseEntity<?> searchWriter(@RequestBody SearchRequestDto request){
        return ResponseEntity.ok(null);
    }

    /**
     * Edit Board
     * @param request
     * @return
     */
    @PostMapping("/edit")
    public ResponseEntity<?> edit(@RequestBody EditBoardDto request){

        return ResponseEntity.ok(null);
    }
}
