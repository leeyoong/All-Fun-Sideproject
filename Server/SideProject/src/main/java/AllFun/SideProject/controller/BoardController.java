package AllFun.SideProject.controller;

import AllFun.SideProject.domain.matching.Board;
import AllFun.SideProject.domain.Member;
import AllFun.SideProject.dto.board.*;
import AllFun.SideProject.service.BoardService;
import AllFun.SideProject.service.MemberService;
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
    private final MemberService memberService;
    /**
     * Write Side-Project board (Use Member Id)
     * @param request
     * @return
     */
    @PostMapping("/create/{id}")
    public ResponseEntity<?> create(@RequestBody CreateBoardRequestDto request, @PathVariable("id") Long memberId){
        Member find = memberService.findById(memberId);
        if (find == null){
            HashMap<String, String> result = new HashMap<String, String>();
            result.put("Error","Wrong Member Id");
            return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
        }
        Board newBoard = Board.createBoard(
                find.getNickname(),
                request.getTitle(),
                request.getContent(),
                request.getProjectMembers()
                );
        CreateBoardResponseDto response = boardService.save(newBoard);
        return ResponseEntity.ok(response);
    }

    /**
     * get board list
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<?> listRecent(){
        SearchResponseDto response = boardService.listAll();
        return ResponseEntity.ok(response);
    }

    /**
     * Read Detail Board and Increase hit.
     * @param id
     * @return
     */
    @GetMapping("/{id}/detail")
    public ResponseEntity<?> readDetail(@PathVariable("id") Long id){
        ReadDetailDto response = boardService.readDetail(id);
        if (response==null){
            HashMap<String, String> result = new HashMap<String,String>();
            result.put("Error","Wrong Board Id");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        } else{
            return ResponseEntity.ok(response);
        }
    }

    /**
     * Search by Title
     * @param request
     * @return
     */
    @GetMapping("/search/title")
    public ResponseEntity<?> search(@RequestBody SearchRequestDto request){
        SearchResponseDto response = boardService.searchList(request.getSearch(), "title");
        return ResponseEntity.ok(response);
    }

    /**
     * Search By Content
     * @param request
     * @return
     */
    @GetMapping("/search/content")
    public ResponseEntity<?> searchContent(@RequestBody SearchRequestDto request){
        SearchResponseDto response = boardService.searchList(request.getSearch(), "content");
        return ResponseEntity.ok(response);
    }

    /**
     * Search By Writer
     * @param request
     * @return
     */
    @GetMapping("search/nickname")
    public ResponseEntity<?> searchNickname(@RequestBody SearchRequestDto request){
        SearchResponseDto response = boardService.searchList(request.getSearch(), "nickname");
        return ResponseEntity.ok(response);
    }

    /**
     * Edit Board
     * @param request
     * @return
     */
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(@RequestBody EditBoardDto request, @PathVariable("id") Long id){
        EditBoardDto response = boardService.editBoard(id, request);
        if (response==null){
            HashMap<String, String> result = new HashMap<String,String>();
            result.put("Error","Wrong Board Id");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        } else{
            return ResponseEntity.ok(response);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        Board board = boardService.findById(id);
        if (board == null){
            HashMap<String, String> result = new HashMap<String,String>();
            result.put("Error","Wrong Board Id");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        } else{
            return ResponseEntity.ok(boardService.deleteBoard(board));
        }
    }

}
