package AllFun.SideProject.domain.matching;

import AllFun.SideProject.domain.dashBoard.DashGroup;
import AllFun.SideProject.domain.member.Member;
import AllFun.SideProject.domain.base.BaseEntity;
import AllFun.SideProject.domain.base.BoardStatus;
import lombok.*;
import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name="board_id")
    private Long id; // board id (pk)
    private String title; // 제목
    private String content; // 글의 내용

    private int backendExpect;
    @ColumnDefault("0")
    private int backendEntry;

    private int frontendExpect;
    @ColumnDefault("0")
    private int frontendEntry;

    private int pmExpect;
    @ColumnDefault("0")
    private int pmEntry;

    private int androidExpect;
    @ColumnDefault("0")
    private int androidEntry;

    private int iosExpect;
    @ColumnDefault("0")
    private int iosEntry;

    private int aiExpect;
    @ColumnDefault("0")
    private int aiEntry;

    private int bigdataExpect;
    @ColumnDefault("0")
    private int bigdataEntry;

    private int blockchainExpect;
    @ColumnDefault("0")
    private int blockchainEntry;

    private LocalDateTime endDate; // 모집 마감 일자

    @Enumerated(EnumType.STRING)
    private BoardStatus status; //구인중, 구인마감

    @ColumnDefault("0")
    private int hit; // 조회수

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member; //작성자 id

    @OneToMany(mappedBy="board")
    private List<EntryPool> entryPools = new ArrayList<>();

    @OneToOne
    @JoinColumn(name="group_id")
    private DashGroup group;

    @OneToMany(mappedBy = "board")
    private List<Scrap> scraps = new ArrayList<>();

    public static Board createBoard(String title, String content, LocalDateTime endDate,
                                    int backendEntry, int frontendEntry, int pmEntry, int androidEntry,
                                    int iosEntry, int aiEntry, int bigdataEntry, int blockchainEntry){
        Board board = new Board();
        board.setTitle(title);
        board.setContent(content);
        board.setHit(0);
        board.setStatus(BoardStatus.WAITING);
        board.setEndDate(endDate);

        board.setBackendEntry(backendEntry);
        board.setFrontendEntry(frontendEntry);
        board.setPmEntry(pmEntry);
        board.setAndroidEntry(androidEntry);
        board.setIosEntry(iosEntry);
        board.setAiEntry(aiEntry);
        board.setBigdataEntry(bigdataEntry);
        board.setBlockchainEntry(blockchainEntry);

        return board;
    }

    public void addScrap(Scrap scrap){
        scraps.add(scrap);
        scrap.setBoard(this);
    }
}
