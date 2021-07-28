package AllFun.SideProject.service;

import AllFun.SideProject.domain.Board;
import AllFun.SideProject.dto.board.CreateBoardRequestDto;
import AllFun.SideProject.dto.board.EditBoardDto;
import AllFun.SideProject.dto.board.ReadDetailDto;
import AllFun.SideProject.dto.board.SearchResponseDto;
import AllFun.SideProject.repository.SpringDataJpaBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private final SpringDataJpaBoardRepository boardRepository;
    /**
     * Write Side-Project board
     * @param board
     * @return
     */
    public CreateBoardRequestDto save(Board board){
        boardRepository.save(board);
        return new CreateBoardRequestDto(board.getNickname(), board.getTitle(), board.getContent(), board.getCreatedDate(),
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

    public SearchResponseDto listAll(){
        SearchResponseDto response = null;
        response.setResponse(boardRepository.findAllOrderByCreateDesc().orElse(null));
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
            response.setResponse(boardRepository.findByTitleContainingOrderByCreateDesc(keyword).orElse(null));
        }else if(searchType.equals("nickname")){
            response.setResponse(boardRepository.findByNicknameContainingOrderByCreateDesc(keyword).orElse(null));
        }else if(searchType.equals("content")){
            response.setResponse(boardRepository.findByContentContainingOrderByCreateDesc(keyword).orElse(null));
        }
        return response;
    }

    /**
     * Edit Board
     * @param boardId
     * @param request
     * @return
     */
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
    public String deleteBoard(Board board){
        boardRepository.delete(board);
        return null;
    }

}
