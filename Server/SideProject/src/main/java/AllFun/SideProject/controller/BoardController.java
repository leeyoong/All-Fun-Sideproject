package AllFun.SideProject.controller;

import AllFun.SideProject.domain.Board;
import AllFun.SideProject.dto.board.CreateBoardDto;
import AllFun.SideProject.dto.board.EditBoardDto;
import AllFun.SideProject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
                request.getCreateDate()
                );
        CreateBoardDto response = boardService.save(newBoard);
        return ResponseEntity.ok(response);
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
