package AllFun.SideProject.controller;

import AllFun.SideProject.Exception.ErrorHeader;
import AllFun.SideProject.domain.base.RoleType;
import AllFun.SideProject.domain.dashBoard.DashGroup;
import AllFun.SideProject.domain.matching.Board;
import AllFun.SideProject.domain.member.Member;
import AllFun.SideProject.domain.matching.BoardRole;
import AllFun.SideProject.domain.matching.Role;
import AllFun.SideProject.dto.mainPage.MyGroupDto;
import AllFun.SideProject.dto.matching.*;
import AllFun.SideProject.service.dashBoard.DashGroupService;
import AllFun.SideProject.service.dashBoard.GroupMemberService;
import AllFun.SideProject.service.matching.BoardRoleService;
import AllFun.SideProject.service.matching.BoardService;
import AllFun.SideProject.service.member.MemberService;
import AllFun.SideProject.service.matching.RoleService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardOnlyController {
    private final BoardService boardService;
    private final MemberService memberService;
    private final RoleService roleService;
    private final DashGroupService dashGroupService;
    private final BoardRoleService boardRoleService;
    private final GroupMemberService groupMemberService;

    /**
     * 그룹의 OWNER 권한을 가진 사용자가 글쓰기 작성 시 작성 가능한 그룹 반환
     * @param memberId
     * @return
     */
    @GetMapping("/create/member/{memberId}")
    public ResponseEntity<?> createForm(@PathVariable("memberId")Long memberId){
        List<DashGroup> dashGroups = groupMemberService.getDashGroupOwner(memberId);
        if (dashGroups == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        // 그룹이 있는 경우
        List<CreateBoardPossibleDto> response = new ArrayList<>();
        for(DashGroup dashGroup : dashGroups){
            CreateBoardPossibleDto createBoardPossibleDto = new CreateBoardPossibleDto(dashGroup.getId(),
                                                                                        dashGroup.getGroupName());

            response.add(createBoardPossibleDto);
        }

        return ResponseEntity.ok(response);
    }

    /**
     * Write Side-Project board (Use group Id & member Id)
     *
     * @param request
     * @return
     */
    @PostMapping("/create/group/{groupId}/member/{memberId}")
    public ResponseEntity<?> create(@RequestBody CreateBoardRequestDto request, @PathVariable("groupId") Long groupId,
                                    @PathVariable("memberId") Long memberId) {
        Member find = memberService.findById(memberId);
        DashGroup dashGroup = dashGroupService.findById(groupId);

        if (dashGroup == null || find == null) {
            return ErrorHeader.errorMessage("wrong id", HttpStatus.BAD_REQUEST);
        }
        int projMembers = request.getBackend() + request.getFrontend() + request.getPm()
                + request.getAndroid() + request.getIOS() + request.getAi()
                + request.getBigData() + request.getBlockChain();

        Board newBoard = Board.createBoard(
                request.getTitle(),
                request.getContent(),
                projMembers,
                request.getEndDate()
        );

        List<BoardRole> boardRoles = new ArrayList<>();

        boardRoles.add(BoardRole.createBoardRole(RoleType.BACKEND, request.getBackend()));
        boardRoles.add(BoardRole.createBoardRole(RoleType.FRONTEND, request.getFrontend()));
        boardRoles.add(BoardRole.createBoardRole(RoleType.PM, request.getPm()));
        boardRoles.add(BoardRole.createBoardRole(RoleType.ANDROID, request.getAndroid()));
        boardRoles.add(BoardRole.createBoardRole(RoleType.IOS, request.getIOS()));
        boardRoles.add(BoardRole.createBoardRole(RoleType.AI, request.getAi()));
        boardRoles.add(BoardRole.createBoardRole(RoleType.BIGDATA, request.getBigData()));
        boardRoles.add(BoardRole.createBoardRole(RoleType.BLOCKCHAIN, request.getBlockChain()));

        for (BoardRole boardRole : boardRoles) {
            newBoard.addBoardRole(boardRole);
            boardRoleService.save(boardRole);
        }

        boardService.save(newBoard, find);

        return ResponseEntity.ok(null);
    }

    /**
     * get board list recently
     * @param pageable
     * @return
     */

    @GetMapping("/list/recently/filter/{filter}")
    public ResponseEntity<?> listRecently (@PageableDefault(size = 20, sort = "board_id", direction = Sort.Direction.DESC) Pageable pageable,
                                           @PathVariable("filter") String filter){

        if(!filter.equals("none")){
            RoleType roleType = RoleType.valueOf(filter.toUpperCase(Locale.ROOT));
            Page<BoardRole> boardRoles = boardRoleService.boardListFilter(pageable, roleType);
            Page<SearchResponseDto> response = boardRoles.map(
                    boardRole -> new SearchResponseDto(
                            boardRole.getBoard().getId(),
                            boardRole.getBoard().getTitle(),
                            boardRole.getBoard().getMember().getNickname(),
                            boardRole.getBoard().getCreatedDate(),
                            boardRole.getBoard().getEndDate(),
                            boardRole.getBoard().getProjectMembers(),
                            boardRole.getBoard().getEntryMembers(),
                            boardRoleService.getRoleType(boardRole.getBoard()),
                            boardRole.getBoard().getStatus()
                    )
            );
            return ResponseEntity.ok(response);
        }
        else{
            Page<Board> boards = boardService.boardList(pageable);
            Page<SearchResponseDto> response = boards.map(
                    board -> new SearchResponseDto(
                            board.getId(), board.getTitle(), board.getMember().getNickname(),
                            board.getCreatedDate(), board.getEndDate(), board.getProjectMembers(),
                            board.getEntryMembers(),
                            boardRoleService.getRoleType(board),
                            board.getStatus()
                    ));
            return ResponseEntity.ok(response);
        }
    }

    /**
     * get board list deadline(마감순)
     *
     * @return
     */
    @GetMapping("/list/deadline/filter/{filter}")
    public ResponseEntity<?> listDeadline(@PageableDefault(size = 20, sort = "end_date", direction = Sort.Direction.ASC) Pageable pageable,
                                          @PathVariable("filter") String filter) {
        if (!filter.equals("none")) {
            RoleType roleType = RoleType.valueOf(filter.toUpperCase(Locale.ROOT));
            Page<BoardRole> boardRoles = boardRoleService.boardListFilter(pageable, roleType);
            Page<SearchResponseDto> response = boardRoles.map(
                    boardRole -> new SearchResponseDto(
                            boardRole.getBoard().getId(),
                            boardRole.getBoard().getTitle(),
                            boardRole.getBoard().getMember().getNickname(),
                            boardRole.getBoard().getCreatedDate(),
                            boardRole.getBoard().getEndDate(),
                            boardRole.getBoard().getProjectMembers(),
                            boardRole.getBoard().getEntryMembers(),
                            boardRoleService.getRoleType(boardRole.getBoard()),
                            boardRole.getBoard().getStatus()
                    )
            );
            return ResponseEntity.ok(response);
        } else {
            Page<Board> boards = boardService.boardList(pageable);
            Page<SearchResponseDto> response = boards.map(
                    board -> new SearchResponseDto(
                            board.getId(), board.getTitle(), board.getMember().getNickname(),
                            board.getCreatedDate(), board.getEndDate(), board.getProjectMembers(),
                            board.getEntryMembers(),
                            boardRoleService.getRoleType(board),
                            board.getStatus()
                    ));
            return ResponseEntity.ok(response);
        }
    }

    /*
    1. keyword ->pageable -> filter
    2. filter -> pageable -> keyword
    3. list<> -> android pageable

    4. List<> -> pageable
     */

    /**
     * Search by Title (recently & filter)
     * @return
     */
    @GetMapping("/search/title/{keyword}/recently/filter/{filter}")
    public ResponseEntity<?> searchRecently(@PathVariable("keyword")String keyword, @PathVariable("filter")String filter,
                                            @PageableDefault(size = 20, sort = "end_date", direction = Sort.Direction.ASC) Pageable pageable){
        if(filter.equals("none")){
            Page<Board> boards = boardService.searchList(keyword, "title", pageable);
            Page<SearchResponseDto> response = boards.map(
                    board -> new SearchResponseDto(
                            board.getId(), board.getTitle(), board.getMember().getNickname(),
                            board.getCreatedDate(), board.getEndDate(), board.getProjectMembers(),
                            board.getEntryMembers(),
                            boardRoleService.getRoleType(board),
                            board.getStatus()
                    ));
            return ResponseEntity.ok(response);
        }else{
            /*
                filter & keyword pageable 미완성
             */
            RoleType roleType = RoleType.valueOf(filter.toUpperCase(Locale.ROOT));
            Page<BoardRole> boardRoles = boardRoleService.boardListFilter(pageable, roleType);
            Page<SearchResponseDto> response = boardRoles.map(
                    boardRole -> new SearchResponseDto(
                            boardRole.getBoard().getId(),
                            boardRole.getBoard().getTitle(),
                            boardRole.getBoard().getMember().getNickname(),
                            boardRole.getBoard().getCreatedDate(),
                            boardRole.getBoard().getEndDate(),
                            boardRole.getBoard().getProjectMembers(),
                            boardRole.getBoard().getEntryMembers(),
                            boardRoleService.getRoleType(boardRole.getBoard()),
                            boardRole.getBoard().getStatus()
                    )
            );
            return ResponseEntity.ok(response);
        }
    }

    /**
     * Search by Title (deadline)
     * @return
     */
    @GetMapping("/search/title/{keyword}/deadline/filter/{filter}")
    public ResponseEntity<?> searchDeadline(@PathVariable("keyword")String keyword, @PathVariable("filter")String filter,
                                            @PageableDefault(size = 20, sort = "end_date", direction = Sort.Direction.ASC) Pageable pageable){
        if(filter.equals("none")){
            Page<Board> boards = boardService.searchList(keyword, "title", pageable);
            Page<SearchResponseDto> response = boards.map(
                    board -> new SearchResponseDto(
                            board.getId(), board.getTitle(), board.getMember().getNickname(),
                            board.getCreatedDate(), board.getEndDate(), board.getProjectMembers(),
                            board.getEntryMembers(),
                            boardRoleService.getRoleType(board),
                            board.getStatus()
                    ));
            return ResponseEntity.ok(response);
        }else{
            /*
                filter & keyword pageable 미완성
             */
            RoleType roleType = RoleType.valueOf(filter.toUpperCase(Locale.ROOT));
            Page<BoardRole> boardRoles = boardRoleService.boardListFilter(pageable, roleType);
            Page<SearchResponseDto> response = boardRoles.map(
                    boardRole -> new SearchResponseDto(
                            boardRole.getBoard().getId(),
                            boardRole.getBoard().getTitle(),
                            boardRole.getBoard().getMember().getNickname(),
                            boardRole.getBoard().getCreatedDate(),
                            boardRole.getBoard().getEndDate(),
                            boardRole.getBoard().getProjectMembers(),
                            boardRole.getBoard().getEntryMembers(),
                            boardRoleService.getRoleType(boardRole.getBoard()),
                            boardRole.getBoard().getStatus()
                    )
            );
            return ResponseEntity.ok(response);
        }
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
            return ErrorHeader.errorMessage("error", HttpStatus.BAD_REQUEST);
        } else{
            return ResponseEntity.ok(response);
        }
    }

    /**
     * Search By Content
     * @param request
     * @return
     */
    /*
    @GetMapping("/search/content")
    public ResponseEntity<?> searchContent(@RequestBody SearchRequestDto request){
        SearchResponseDto response = boardService.searchList(request.getSearch(), "content");
        return ResponseEntity.ok(response);
    }
     */

    /**
     * Search By Writer
     * @param request
     * @return
     */
    /*
    @GetMapping("search/nickname")
    public ResponseEntity<?> searchNickname(@RequestBody SearchRequestDto request){
        SearchResponseDto response = boardService.searchList(request.getSearch(), "nickname");
        return ResponseEntity.ok(response);
    }
     */

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
