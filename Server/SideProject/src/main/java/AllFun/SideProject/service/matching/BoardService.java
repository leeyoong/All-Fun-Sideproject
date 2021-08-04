package AllFun.SideProject.service.matching;

import AllFun.SideProject.domain.base.RoleType;
import AllFun.SideProject.domain.matching.BoardRole;
import AllFun.SideProject.domain.member.Member;
import AllFun.SideProject.domain.matching.Board;
import AllFun.SideProject.dto.matching.*;
import AllFun.SideProject.repository.matching.BoardRepository;
import AllFun.SideProject.repository.matching.BoardRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardRoleRepository boardRoleRepository;

    /**
     * Write Side-Project board
     * @param board
     * @return
     */
    @Transactional
    public void save(Board board, Member member){
        member.addBoard(board);
        boardRepository.save(board);

        //return new CreateBoardResponseDto(board.getNickname(), board.getTitle(), board.getContent(), board.getCreatedDate(),
        //                           board.getProjectMembers(),board.getHit());
    }

    /**
     * Find by Board ID
     * @param id
     * @return
     */
    public Board findById(Long id){
        return boardRepository.findById(id)
                .orElse(null);
    }

    /**
     * get all board list (recently)
     * @return
     */
    public Page<Board> boardList(Pageable pageable){
        Page<Board> boards = boardRepository.findAll(pageable);
        return boards;
    }

    /**
     * read detail board page and increase hit
     * @param boardId
     * @return
     */
    public ReadDetailDto readDetail(Long boardId){
        Optional<Board> hitUp = Optional.ofNullable(boardRepository.findById(boardId).orElse(null));
        if (hitUp.isEmpty()){
            return null;
        }
        hitUp.ifPresent(selectBoard->{
            selectBoard.setHit(selectBoard.getHit()+1);
            boardRepository.save(selectBoard);
        });
        Board board = hitUp.get();
        List<BoardRole> boardRoles = boardRoleRepository.findAllByBoard(board).orElse(null);
        List<BoardRoleDto> roles = new ArrayList<>();
        for (BoardRole boardRole : boardRoles) {
            roles.add(new BoardRoleDto(boardRole.getRole(), boardRole.getHope(), boardRole.getEntry()));
        }
        return new ReadDetailDto(board.getTitle(), board.getContent(), board.getMember().getNickname(),
                board.getModifiedDate(), board.getEndDate(), roles,board.getHit(), board.getMember().getId());

    }

    /**
     * Search List
     * @param keyword
     * @param searchType
     * @return
     */
    public Page<Board> searchList(String keyword, String searchType, Pageable pageable){
        if (searchType.equals("title")){
            Page<Board> boards = boardRepository.findAllByTitleContaining(keyword, pageable);
            return boards;
        }else if(searchType.equals("nickname")){
            //response.setResponse(boardRepository.findByNicknameContaining(keyword).orElse(null));
        }else if(searchType.equals("content")){
            //response.setResponse(boardRepository.findByContentContaining(keyword).orElse(null));
        }
        return null;
    }

    /**
     * Edit Board
     * @param boardId
     * @param request
     * @return
     */
    @Transactional
    public EditBoardDto editBoard(Long boardId, EditBoardDto request){
        Optional<Board> editData = Optional.ofNullable(boardRepository.findById(boardId).orElse(null));
        if (editData.isEmpty()){
            return null;
        }
        editData.ifPresent(selectBoard->{
            selectBoard.setTitle(request.getTitle());
            selectBoard.setContent(request.getContent());
            boardRepository.save(selectBoard);
        });
        return request;
    }

    /**
     * Delete Board
     * @param board
     * @return
     */
    @Transactional
    public String deleteBoard(Board board){
        boardRepository.delete(board);
        return null;
    }

}
