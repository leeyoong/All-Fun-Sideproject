package AllFun.SideProject.repository.matching;

import AllFun.SideProject.domain.base.BoardStatus;
import AllFun.SideProject.domain.matching.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    /**
     * list pageable
     * @param pageable
     * @return
     */
    Page<Board> findAllByStatus(BoardStatus status, Pageable pageable);

    Page<Board> findAllByStatusAndBackendExpectGreaterThanEqual(BoardStatus status, int backendExpect, Pageable pageable);

    Page<Board> findAllByStatusAndFrontendExpectGreaterThanEqual(BoardStatus status, int frontendExpect, Pageable pageable);

    Page<Board> findAllByStatusAndPmExpectGreaterThanEqual(BoardStatus status, int pmExpect, Pageable pageable);

    Page<Board> findAllByStatusAndAndroidExpectGreaterThanEqual(BoardStatus status, int androidExpect, Pageable pageable);

    Page<Board> findAllByStatusAndIosExpectGreaterThanEqual(BoardStatus status, int iosExpect, Pageable pageable);

    Page<Board> findAllByStatusAndAiExpectGreaterThanEqual(BoardStatus status, int aiExpect, Pageable pageable);

    Page<Board> findAllByStatusAndBigdataExpectGreaterThanEqual(BoardStatus status, int bigdataExpect, Pageable pageable);

    Page<Board> findAllByStatusAndBlockchainExpectGreaterThanEqual(BoardStatus status, int blockchainExpect, Pageable pageable);

    /**
     * title 검색
     */
    Page<Board> findAllByStatusAndTitleContaining(BoardStatus status,String title, Pageable pageable);

    Page<Board> findAllByStatusAndBackendExpectGreaterThanEqualAndTitleContaining(BoardStatus status,
                                                                                  int backendExpect,
                                                                                  String title,
                                                                                  Pageable pageable);

    Page<Board> findAllByStatusAndFrontendExpectGreaterThanEqualAndTitleContaining(BoardStatus status,
                                                                                   int frontendExpect,
                                                                                   String title,
                                                                                   Pageable pageable);

    Page<Board> findAllByStatusAndPmExpectGreaterThanEqualAndTitleContaining(BoardStatus status,
                                                                             int pmExpect,
                                                                             String title,
                                                                             Pageable pageable);

    Page<Board> findAllByStatusAndAndroidExpectGreaterThanEqualAndTitleContaining(BoardStatus status,
                                                                                  int androidExpect,
                                                                                  String title,
                                                                                  Pageable pageable);

    Page<Board> findAllByStatusAndIosExpectGreaterThanEqualAndTitleContaining(BoardStatus status,
                                                                              int iosExpect,
                                                                              String title,
                                                                              Pageable pageable);

    Page<Board> findAllByStatusAndAiExpectGreaterThanEqualAndTitleContaining(BoardStatus status,
                                                                             int aiExpect,
                                                                             String title,
                                                                             Pageable pageable);

    Page<Board> findAllByStatusAndBigdataExpectGreaterThanEqualAndTitleContaining(BoardStatus status,
                                                                                  int bigdataExpect,
                                                                                  String title,
                                                                                  Pageable pageable);

    Page<Board> findAllByStatusAndBlockchainExpectGreaterThanEqualAndTitleContaining(BoardStatus status,
                                                                                     int blockchainExpect,
                                                                                     String title,
                                                                                     Pageable pageable);

}
