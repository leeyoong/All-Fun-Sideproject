package AllFun.SideProject.controller;

import AllFun.SideProject.domain.matching.Board;
import AllFun.SideProject.domain.member.Member;
import AllFun.SideProject.domain.matching.BoardRole;
import AllFun.SideProject.domain.matching.Role;
import AllFun.SideProject.dto.board.*;
import AllFun.SideProject.service.matching.BoardService;
import AllFun.SideProject.service.member.MemberService;
import AllFun.SideProject.service.matching.RoleService;
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
    private final RoleService roleService;
    /**
     * Write Side-Project board (Use Member Id)
     * @param request
     * @return
     */
    @PostMapping("/create/{memberId}")
    public ResponseEntity<?> create(@RequestBody CreateBoardRequestDto request, @PathVariable("memberId") Long memberId){
        Member find = memberService.findById(memberId);
        if (find == null){
            HashMap<String, String> result = new HashMap<String, String>();
            result.put("Error","Wrong Member Id");
            return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
        }
        int projMembers = request.getHope().stream().mapToInt(Integer::intValue).sum();

        Board newBoard = Board.createBoard(
                find.getNickname(),
                request.getTitle(),
                request.getContent(),
                projMembers
                );

        CreateBoardResponseDto response = boardService.save(newBoard, find);

        for (int i = 0;i<request.getHope().size();i++){
            if (request.getHope().get(i) != 0){
                Long roleId = Long.valueOf(i + 1);
                Role role = roleService.findById(roleId);
                BoardRole boardRole = BoardRole.createBoardRole(role.getName(), request.getHope().get(i));
                newBoard.addBoardRole(boardRole);
            }
        }

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
     * @param boardId
     * @return
     */
    @GetMapping("/{boardId}/detail")
    public ResponseEntity<?> readDetail(@PathVariable("boardId") Long boardId){
        ReadDetailDto response = boardService.readDetail(boardId);
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
    @PostMapping("/edit/{boardId}")
    public ResponseEntity<?> edit(@RequestBody EditBoardDto request, @PathVariable("boardId") Long boardId){
        EditBoardDto response = boardService.editBoard(boardId, request);
        if (response==null){
            HashMap<String, String> result = new HashMap<String,String>();
            result.put("Error","Wrong Board Id");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        } else{
            return ResponseEntity.ok(response);
        }
    }

    /**
     * Done Matching 'waiting' -> 'done'
     * @return
     */
    @PostMapping("/edit/{boardId}/status")
    public ResponseEntity<?> changeStatus(){
        return null;
    }

    /**
     * delete board
     * @param boardId
     * @return
     */
    @PostMapping("/delete/{boardId}")
    public ResponseEntity<?> delete(@PathVariable("boardId") Long boardId){
        Board board = boardService.findById(boardId);
        if (board == null){
            HashMap<String, String> result = new HashMap<String,String>();
            result.put("Error","Wrong Board Id");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        } else{
            return ResponseEntity.ok(boardService.deleteBoard(board));
        }
    }


}
