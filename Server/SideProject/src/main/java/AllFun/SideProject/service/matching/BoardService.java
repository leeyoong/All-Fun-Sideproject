package AllFun.SideProject.service.matching;

import AllFun.SideProject.domain.base.BoardStatus;
import AllFun.SideProject.domain.member.Member;
import AllFun.SideProject.domain.matching.Board;
import AllFun.SideProject.dto.matching.*;
import AllFun.SideProject.repository.matching.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {
    private final BoardRepository boardRepository;

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
    public Page<Board> boardList(Pageable pageable, String filter){
        Page<Board> boards = null;
        switch (filter){
            case "none":
                boards = boardRepository.findAllByStatus(BoardStatus.WAITING, pageable);
                break;
            case "backend":
                boards = boardRepository.findAllByStatusAndBackendExpectGreaterThanEqual(BoardStatus.WAITING,
                        1, pageable);
                break;
            case "frontend":
                boards = boardRepository.findAllByStatusAndFrontendExpectGreaterThanEqual(BoardStatus.WAITING,
                        1, pageable);
                break;
            case "pm":
                boards = boardRepository.findAllByStatusAndPmExpectGreaterThanEqual(BoardStatus.WAITING,
                        1, pageable);
                break;
            case "android":
                boards = boardRepository.findAllByStatusAndAndroidExpectGreaterThanEqual(BoardStatus.WAITING,
                        1, pageable);
                break;
            case "ios":
                boards = boardRepository.findAllByStatusAndIosExpectGreaterThanEqual(BoardStatus.WAITING,
                        1, pageable);
                break;
            case "ai":
                boards = boardRepository.findAllByStatusAndAiExpectGreaterThanEqual(BoardStatus.WAITING,
                        1, pageable);
                break;
            case "bigdata":
                boards = boardRepository.findAllByStatusAndBigdataExpectGreaterThanEqual(BoardStatus.WAITING,
                        1, pageable);
                break;
            case "blockchain":
                boards = boardRepository.findAllByStatusAndBlockchainExpectGreaterThanEqual(BoardStatus.WAITING,
                        1, pageable);
                break;
        }
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

        ReadDetailDto response = new ReadDetailDto(
                board.getTitle(),
                board.getContent(),
                board.getMember().getNickname(),
                board.getCreatedDate(),
                board.getEndDate(),
                getBoardRoleDto(board),
                board.getHit(),
                board.getMember().getId()
        );

        return response;

    }

    /**
     * Search List
     * @param keyword
     * @return
     */
    public Page<Board> searchList(String keyword, Pageable pageable, String filter){
        Page<Board> boards = null;
        switch (filter){
            case "none":
                boards = boardRepository.findAllByStatusAndTitleContaining(BoardStatus.WAITING,keyword, pageable);
                break;
            case "backend":
                boards = boardRepository.findAllByStatusAndBackendExpectGreaterThanEqualAndTitleContaining(BoardStatus.WAITING,
                        1,keyword, pageable);
                break;
            case "frontend":
                boards = boardRepository.findAllByStatusAndFrontendExpectGreaterThanEqualAndTitleContaining(BoardStatus.WAITING,
                        1,keyword, pageable);
                break;
            case "pm":
                boards = boardRepository.findAllByStatusAndPmExpectGreaterThanEqualAndTitleContaining(BoardStatus.WAITING,
                        1,keyword, pageable);
                break;
            case "android":
                boards = boardRepository.findAllByStatusAndAndroidExpectGreaterThanEqualAndTitleContaining(BoardStatus.WAITING,
                        1,keyword, pageable);
                break;
            case "ios":
                boards = boardRepository.findAllByStatusAndIosExpectGreaterThanEqualAndTitleContaining(BoardStatus.WAITING,
                        1,keyword, pageable);
                break;
            case "ai":
                boards = boardRepository.findAllByStatusAndAiExpectGreaterThanEqualAndTitleContaining(BoardStatus.WAITING,
                        1,keyword, pageable);
                break;
            case "bigdata":
                boards = boardRepository.findAllByStatusAndBigdataExpectGreaterThanEqualAndTitleContaining(BoardStatus.WAITING,
                        1,keyword, pageable);
                break;
            case "blockchain":
                boards = boardRepository.findAllByStatusAndBlockchainExpectGreaterThanEqualAndTitleContaining(BoardStatus.WAITING,
                        1,keyword, pageable);
                break;
        }
        return boards;
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

            selectBoard.setAiExpect(request.getAi());
            selectBoard.setBigdataExpect(request.getBigData());
            selectBoard.setBlockchainExpect(request.getBlockChain());
            selectBoard.setIosExpect(request.getIOS());
            selectBoard.setAndroidExpect(request.getAndroid());
            selectBoard.setPmExpect(request.getPm());
            selectBoard.setFrontendExpect(request.getFrontend());
            selectBoard.setBackendExpect(request.getBackend());

            boardRepository.save(selectBoard);
        });
        return request;
    }

    /**
     * change board status ACCEPT
     * @param boardId
     * @return
     */
    @Transactional
    public String changeStatus(Long boardId){
        Optional<Board> board = boardRepository.findById(boardId);

        if(board.isEmpty()){
            return null;
        }
        board.ifPresent(selectBoard->{
            selectBoard.setStatus(BoardStatus.ACCEPT);
            boardRepository.save(selectBoard);
        });
        return "ok";
    }

    /**
     * Delete Board
     * @param board
     * @return
     */
    @Transactional
    public void deleteBoard(Board board){
        boardRepository.delete(board);
    }

    /**
     * get boardRoleDto
     * @param board
     * @return
     */
    public List<BoardRoleDto> getBoardRoleDto(Board board){
        List<BoardRoleDto> response = new ArrayList<>();
        if(board.getBackendExpect()>0){
            response.add(new BoardRoleDto("#backend", board.getBackendExpect(), board.getBackendEntry()));
        }
        if(board.getFrontendExpect()>0){
            response.add(new BoardRoleDto("#frontend", board.getFrontendExpect(), board.getFrontendEntry()));
        }
        if(board.getPmExpect()>0){
            response.add(new BoardRoleDto("#pm", board.getPmExpect(), board.getPmEntry()));
        }
        if(board.getAndroidExpect()>0){
            response.add(new BoardRoleDto("#android", board.getAndroidExpect(), board.getAndroidEntry()));
        }
        if(board.getIosExpect()>0){
            response.add(new BoardRoleDto("#ios", board.getIosExpect(), board.getIosEntry()));
        }
        if(board.getAiExpect()>0){
            response.add(new BoardRoleDto("#ai", board.getAiExpect(), board.getAiEntry()));
        }
        if(board.getBigdataExpect()>0){
            response.add(new BoardRoleDto("#bigdata", board.getBigdataExpect(), board.getBigdataEntry()));
        }
        if(board.getBlockchainExpect()>0){
            response.add(new BoardRoleDto("#blockchain", board.getBlockchainExpect(), board.getBlockchainEntry()));
        }
        return response;
    }


}
