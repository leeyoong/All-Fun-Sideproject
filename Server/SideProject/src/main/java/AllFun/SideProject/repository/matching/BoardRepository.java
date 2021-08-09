package AllFun.SideProject.repository.matching;

import AllFun.SideProject.domain.base.BoardStatus;
import AllFun.SideProject.domain.matching.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    /**
     * list pageable (recently)
     * @return
     */
    Optional<List<Board>> findAllByStatusOrderByCreatedDateDesc(BoardStatus status);

    Optional<List<Board>> findAllByStatusAndBackendExpectGreaterThanEqualOrderByCreatedDateDesc(BoardStatus status, int backendExpect);

    Optional<List<Board>> findAllByStatusAndFrontendExpectGreaterThanEqualOrderByCreatedDateDesc(BoardStatus status, int frontendExpect);

    Optional<List<Board>> findAllByStatusAndPmExpectGreaterThanEqualOrderByCreatedDateDesc(BoardStatus status, int pmExpect);

    Optional<List<Board>> findAllByStatusAndAndroidExpectGreaterThanEqualOrderByCreatedDateDesc(BoardStatus status, int androidExpect);

    Optional<List<Board>> findAllByStatusAndIosExpectGreaterThanEqualOrderByCreatedDateDesc(BoardStatus status, int iosExpect);

    Optional<List<Board>> findAllByStatusAndAiExpectGreaterThanEqualOrderByCreatedDateDesc(BoardStatus status, int aiExpect);

    Optional<List<Board>> findAllByStatusAndBigdataExpectGreaterThanEqualOrderByCreatedDateDesc(BoardStatus status, int bigdataExpect);

    Optional<List<Board>> findAllByStatusAndBlockchainExpectGreaterThanEqualOrderByCreatedDateDesc(BoardStatus status, int blockchainExpect);
    /**
     * list pageable (deadline)
     * @return
     */
    Optional<List<Board>> findAllByStatusOrderByEndDateAsc(BoardStatus status);

    Optional<List<Board>> findAllByStatusAndBackendExpectGreaterThanEqualOrderByEndDateAsc(BoardStatus status, int backendExpect);

    Optional<List<Board>> findAllByStatusAndFrontendExpectGreaterThanEqualOrderByEndDateAsc(BoardStatus status, int frontendExpect);

    Optional<List<Board>> findAllByStatusAndPmExpectGreaterThanEqualOrderByEndDateAsc(BoardStatus status, int pmExpect);

    Optional<List<Board>> findAllByStatusAndAndroidExpectGreaterThanEqualOrderByEndDateAsc(BoardStatus status, int androidExpect);

    Optional<List<Board>> findAllByStatusAndIosExpectGreaterThanEqualOrderByEndDateAsc(BoardStatus status, int iosExpect);

    Optional<List<Board>> findAllByStatusAndAiExpectGreaterThanEqualOrderByEndDateAsc(BoardStatus status, int aiExpect);

    Optional<List<Board>> findAllByStatusAndBigdataExpectGreaterThanEqualOrderByEndDateAsc(BoardStatus status, int bigdataExpect);

    Optional<List<Board>> findAllByStatusAndBlockchainExpectGreaterThanEqualOrderByEndDateAsc(BoardStatus status, int blockchainExpect);

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
