package AllFun.SideProject.domain.matching;

import AllFun.SideProject.domain.Member;
import AllFun.SideProject.domain.base.BaseEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id; // board id (pk)
    private String nickname; // member - nickname
    private String title; // 제목
    private String content; // 글의 내용
    private int projectMembers; // 프로젝트 구성 인원
    private int entryMembers; // 참여 인원

    @ColumnDefault("0")
    private int hit; // 조회수

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @OneToMany(mappedBy = "edu")

    public static Board createBoard(String nickname, String title, String content, int hope){
        Board board = new Board();
        board.setNickname(nickname);
        board.setTitle(title);
        board.setContent(content);
        board.setProjectMembers(hope);
        board.setEntryMembers(0);
        board.setHit(0);
        return board;
    }

}
