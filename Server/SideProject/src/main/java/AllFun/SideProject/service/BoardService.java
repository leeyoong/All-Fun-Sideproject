package AllFun.SideProject.service;

import AllFun.SideProject.domain.user.Member;
import AllFun.SideProject.domain.matching.Board;
import AllFun.SideProject.dto.board.*;
import AllFun.SideProject.repository.SpringDataJpaBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {
    private final SpringDataJpaBoardRepository boardRepository;
    /**
     * Write Side-Project board
     * @param board
     * @return
     */
    @Transactional
    public CreateBoardResponseDto save(Board board, Member member){
        member.addBoard(board);
        boardRepository.save(board);
        return new CreateBoardResponseDto(board.getNickname(), board.getTitle(), board.getContent(), board.getCreatedDate(),
                                    board.getProjectMembers(),board.getHit());
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
     * get all board list
     * @return
     */
    public SearchResponseDto listAll(){
        SearchResponseDto response = null;
        response.setResponse(boardRepository.findAll());
        return response;
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

        return new ReadDetailDto(board.getTitle(), board.getContent(), board.getNickname(), board.getModifiedDate()
                ,board.getProjectMembers(),board.getEntryMembers(),board.getHit());

    }

    /**
     * Search List
     * @param keyword
     * @param searchType
     * @return
     */
    public SearchResponseDto searchList(String keyword, String searchType){
        SearchResponseDto response = null;
        if (searchType.equals("title")){
            response.setResponse(boardRepository.findByTitleContaining(keyword).orElse(null));
        }else if(searchType.equals("nickname")){
            response.setResponse(boardRepository.findByNicknameContaining(keyword).orElse(null));
        }else if(searchType.equals("content")){
            response.setResponse(boardRepository.findByContentContaining(keyword).orElse(null));
        }
        return response;
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
