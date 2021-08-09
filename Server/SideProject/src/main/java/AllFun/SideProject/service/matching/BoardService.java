package AllFun.SideProject.service.matching;

import AllFun.SideProject.domain.base.BoardStatus;
import AllFun.SideProject.domain.matching.Scrap;
import AllFun.SideProject.domain.member.Member;
import AllFun.SideProject.domain.matching.Board;
import AllFun.SideProject.dto.matching.*;
import AllFun.SideProject.repository.matching.BoardRepository;
import AllFun.SideProject.repository.matching.ScrapRepository;
import AllFun.SideProject.repository.member.MemberRepository;
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
    private final MemberRepository memberRepository;
    private final ScrapRepository scrapRepository;
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
    public List<SearchResponseDto> boardList(String filter){
        List<Board> boards = null;
        switch (filter){
            case "none":
                boards = boardRepository.findAllByStatusOrderByCreatedDateDesc(BoardStatus.WAITING).orElse(null);
                break;
            case "backend":
                boards = boardRepository.findAllByStatusAndBackendExpectGreaterThanEqualOrderByCreatedDateDesc(BoardStatus.WAITING,
                        1).orElse(null);
                break;
            case "frontend":
                boards = boardRepository.findAllByStatusAndFrontendExpectGreaterThanEqualOrderByCreatedDateDesc(BoardStatus.WAITING,
                        1).orElse(null);
                break;
            case "pm":
                boards = boardRepository.findAllByStatusAndPmExpectGreaterThanEqualOrderByCreatedDateDesc(BoardStatus.WAITING,
                        1).orElse(null);
                break;
            case "android":
                boards = boardRepository.findAllByStatusAndAndroidExpectGreaterThanEqualOrderByCreatedDateDesc(BoardStatus.WAITING,
                        1).orElse(null);
                break;
            case "ios":
                boards = boardRepository.findAllByStatusAndIosExpectGreaterThanEqualOrderByCreatedDateDesc(BoardStatus.WAITING,
                        1).orElse(null);
                break;
            case "ai":
                boards = boardRepository.findAllByStatusAndAiExpectGreaterThanEqualOrderByCreatedDateDesc(BoardStatus.WAITING,
                        1).orElse(null);
                break;
            case "bigdata":
                boards = boardRepository.findAllByStatusAndBigdataExpectGreaterThanEqualOrderByCreatedDateDesc(BoardStatus.WAITING,
                        1).orElse(null);
                break;
            case "blockchain":
                boards = boardRepository.findAllByStatusAndBlockchainExpectGreaterThanEqualOrderByCreatedDateDesc(BoardStatus.WAITING,
                        1).orElse(null);
                break;
        }
        List<SearchResponseDto> response = new ArrayList<>();
        for (Board board : boards) {
            response.add(
            new SearchResponseDto(
                    board.getId(),
                    board.getTitle(),
                    board.getMember().getNickname(),
                    board.getCreatedDate(),
                    board.getEndDate(),
                    board.getContent(),
                    getRole(board)
            ));
        }
        return response;
    }
    /**
     * get all board list (deadline)
     * @return
     */
    public List<SearchResponseDto> boardListDead(String filter){
        List<Board> boards = null;
        switch (filter){
            case "none":
                boards = boardRepository.findAllByStatusOrderByCreatedDateDesc(BoardStatus.WAITING).orElse(null);
                break;
            case "backend":
                boards = boardRepository.findAllByStatusAndBackendExpectGreaterThanEqualOrderByCreatedDateDesc(BoardStatus.WAITING,
                        1).orElse(null);
                break;
            case "frontend":
                boards = boardRepository.findAllByStatusAndFrontendExpectGreaterThanEqualOrderByCreatedDateDesc(BoardStatus.WAITING,
                        1).orElse(null);
                break;
            case "pm":
                boards = boardRepository.findAllByStatusAndPmExpectGreaterThanEqualOrderByCreatedDateDesc(BoardStatus.WAITING,
                        1).orElse(null);
                break;
            case "android":
                boards = boardRepository.findAllByStatusAndAndroidExpectGreaterThanEqualOrderByCreatedDateDesc(BoardStatus.WAITING,
                        1).orElse(null);
                break;
            case "ios":
                boards = boardRepository.findAllByStatusAndIosExpectGreaterThanEqualOrderByCreatedDateDesc(BoardStatus.WAITING,
                        1).orElse(null);
                break;
            case "ai":
                boards = boardRepository.findAllByStatusAndAiExpectGreaterThanEqualOrderByCreatedDateDesc(BoardStatus.WAITING,
                        1).orElse(null);
                break;
            case "bigdata":
                boards = boardRepository.findAllByStatusAndBigdataExpectGreaterThanEqualOrderByCreatedDateDesc(BoardStatus.WAITING,
                        1).orElse(null);
                break;
            case "blockchain":
                boards = boardRepository.findAllByStatusAndBlockchainExpectGreaterThanEqualOrderByCreatedDateDesc(BoardStatus.WAITING,
                        1).orElse(null);
                break;
        }
        List<SearchResponseDto> response = new ArrayList<>();
        for (Board board : boards) {
            response.add(
                    new SearchResponseDto(
                            board.getId(),
                            board.getTitle(),
                            board.getMember().getNickname(),
                            board.getCreatedDate(),
                            board.getEndDate(),
                            board.getContent(),
                            getRole(board)
                    ));
        }
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
            response.add(new BoardRoleDto("#백", board.getBackendExpect(), board.getBackendEntry()));
        }
        if(board.getFrontendExpect()>0){
            response.add(new BoardRoleDto("#프론트", board.getFrontendExpect(), board.getFrontendEntry()));
        }
        if(board.getPmExpect()>0){
            response.add(new BoardRoleDto("#PM", board.getPmExpect(), board.getPmEntry()));
        }
        if(board.getAndroidExpect()>0){
            response.add(new BoardRoleDto("#Android", board.getAndroidExpect(), board.getAndroidEntry()));
        }
        if(board.getIosExpect()>0){
            response.add(new BoardRoleDto("#iOS", board.getIosExpect(), board.getIosEntry()));
        }
        if(board.getAiExpect()>0){
            response.add(new BoardRoleDto("#AI", board.getAiExpect(), board.getAiEntry()));
        }
        if(board.getBigdataExpect()>0){
            response.add(new BoardRoleDto("#빅데이터", board.getBigdataExpect(), board.getBigdataEntry()));
        }
        if(board.getBlockchainExpect()>0){
            response.add(new BoardRoleDto("#블록체인", board.getBlockchainExpect(), board.getBlockchainEntry()));
        }
        return response;
    }

    public List<String> getRole(Board board){
        List<String> response = new ArrayList<>();
        if(board.getBackendExpect()>0){
            response.add("#백");
        }
        if(board.getFrontendExpect()>0){
            response.add("#프론트");
        }
        if(board.getPmExpect()>0){
            response.add("#PM");
        }
        if(board.getAndroidExpect()>0){
            response.add("#Android");
        }
        if(board.getIosExpect()>0){
            response.add("#iOS");
        }
        if(board.getAiExpect()>0){
            response.add("#AI");
        }
        if(board.getBigdataExpect()>0){
            response.add("#빅데이터");
        }
        if(board.getBlockchainExpect()>0){
            response.add("#블록체인");
        }
        return response;
    }




    /**
     * update status (ACCEPT case)
     * @param board
     * @param role
     */
    @Transactional
    public void updateEntry(Board board, String role){
        if(role.equals("backend")){
            board.setBackendEntry(board.getBackendEntry()+1);
        }else if(role.equals("frontend")){
            board.setFrontendEntry(board.getFrontendEntry()+1);
        }else if(role.equals("pm")){
            board.setPmEntry(board.getPmEntry()+1);
        }else if(role.equals("android")){
            board.setAndroidEntry(board.getAndroidEntry()+1);
        }else if(role.equals("ios")){
            board.setIosEntry(board.getIosEntry()+1);
        }else if(role.equals("ai")){
            board.setAiEntry(board.getAiEntry()+1);
        }else if(role.equals("bigdata")){
            board.setBigdataEntry(board.getBigdataEntry()+1);
        }else if(role.equals("blockchain")){
            board.setBlockchainEntry(board.getBlockchainEntry()+1);
        }
        boardRepository.save(board);
    }

    @Transactional
    public void scrapBoard(Long boardId, Long memberId){
        Board board = boardRepository.findById(boardId).orElse(null);
        Member member = memberRepository.findById(memberId).orElse(null);

        Scrap scrap = Scrap.createScrap(board);
        member.addScrap(scrap);

        scrapRepository.save(scrap);

    }

    @Transactional
    public void deleteScrap(Long boardId, Long memberId){
        Board board = boardRepository.findById(boardId).orElse(null);
        Member member = memberRepository.findById(memberId).orElse(null);

        Scrap scrap = scrapRepository.findByMemberAndBoard(member, board).orElse(null);
        scrapRepository.delete(scrap);
    }

}
