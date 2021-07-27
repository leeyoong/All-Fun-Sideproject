package AllFun.SideProject.service;

import AllFun.SideProject.domain.Board;
import AllFun.SideProject.dto.board.CreateBoardDto;
import AllFun.SideProject.dto.board.ReadDetailDto;
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
    public CreateBoardDto save(Board board){
        boardRepository.save(board);
        return new CreateBoardDto(board.getNickname(), board.getTitle(), board.getContent(), board.getCreateDate(),
                                    board.getProjectMembers(),board.getHit());
    }


    public Board findById(Long id){
        return boardRepository.findById(id)
                .orElse(null);
    }


    /**
     * read detail board page and increase hit
     * @param boardId
     * @return
     */
    public ReadDetailDto readDetail(Long boardId){

        Optional<Board> hitUp = boardRepository.findById(boardId);
        hitUp.ifPresent(selectBoard->{
            selectBoard.setHit(selectBoard.getHit()+1);
            boardRepository.save(selectBoard);
        });

        Board board = boardRepository.findById(boardId).orElse(null);

        if(board.getEditDate() == null){
            return new ReadDetailDto(board.getTitle(), board.getContent(), board.getNickname(), board.getCreateDate()
                    ,board.getProjectMembers(),board.getEntryMembers(),board.getHit());
        }else{
            return new ReadDetailDto(board.getTitle(), board.getContent(), board.getNickname(), board.getEditDate()
                    ,board.getProjectMembers(),board.getEntryMembers(),board.getHit());
        }
    }

}
