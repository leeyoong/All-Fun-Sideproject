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
    private int projectMembers; // 프로젝트 구성 인원
    private int entryMembers; // 참여 인원

    private LocalDateTime endDate; // 모집 마감 일자

    @Enumerated(EnumType.STRING)
    private BoardStatus status; //구인중, 구인마감

    @ColumnDefault("0")
    private int hit; // 조회수

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member; //작성자 id

    @OneToMany(mappedBy="board")
    private List<BoardRole> boardRoles = new ArrayList<>();

    @OneToMany(mappedBy="board")
    private List<EntryPool> entryPools = new ArrayList<>();

    @OneToOne
    @JoinColumn(name="group_id")
    private DashGroup group;

    @OneToMany(mappedBy = "board")
    private List<Scrap> scraps = new ArrayList<>();

    public static Board createBoard(String title, String content, int projMem, LocalDateTime endDate){
        Board board = new Board();
        board.setTitle(title);
        board.setContent(content);
        board.setProjectMembers(projMem);
        board.setEntryMembers(0);
        board.setHit(0);
        board.setStatus(BoardStatus.WAITING);
        board.setEndDate(endDate);

        return board;
    }
    public void addBoardRole(BoardRole BoardRole){
        boardRoles.add(BoardRole);
        BoardRole.setBoard(this);
    }
    public void addScrap(Scrap scrap){
        scraps.add(scrap);
        scrap.setBoard(this);
    }
}
