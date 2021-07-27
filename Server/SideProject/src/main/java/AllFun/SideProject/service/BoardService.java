package AllFun.SideProject.service;

import AllFun.SideProject.domain.Board;
import AllFun.SideProject.domain.Member;
import AllFun.SideProject.dto.board.CreateBoardDto;
import AllFun.SideProject.dto.member.CreateMemberDto;
import AllFun.SideProject.repository.SpringDataJpaBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return new CreateBoardDto(board.getNickname(), board.getTitle(), board.getContent(), board.getCreateDate()
                                    ,board.getHit());
    }

}
