package AllFun.SideProject.controller.dashBoard;

import AllFun.SideProject.domain.dashBoard.GroupBoard;
import AllFun.SideProject.dto.dashBoard.GroupBoardListDto;
import AllFun.SideProject.dto.matching.SearchResponseDto;
import AllFun.SideProject.service.dashBoard.GroupBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 그룹 게시판
 */

@RestController
@RequestMapping("/dashboard/{groupId}/board")
@RequiredArgsConstructor
public class GroupBoardController {
    private final GroupBoardService groupBoardService;

    /**
     * get board list (공지사항)
     * @return
     */
    @GetMapping("/list/notice")
    public ResponseEntity<?> groupBoardNotice(@PathVariable("groupId")Long groupId){
        List<GroupBoardListDto> response = groupBoardService.boardNotice(groupId);
        return ResponseEntity.ok(response);
    }

    /**
     * get board list (일반)
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<?> groupBoardList(@PathVariable("groupId")Long groupId,
                                            @PageableDefault(size = 20, sort = "group_board_id", direction = Sort.Direction.DESC) Pageable pageable){
        Page<GroupBoard> groupBoards = groupBoardService.boardList(pageable, groupId);
        Page<GroupBoardListDto> response = groupBoards.map(
                groupBoard -> new GroupBoardListDto(
                        groupBoard.getId(),
                        groupBoard.getMember().getId(),
                        groupBoard.getMember().getNickname(),
                        groupBoard.getTitle(),
                        groupBoard.getCreatedDate(),
                        groupBoard.getKinds()
                )
        );

        return ResponseEntity.ok(response);
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
