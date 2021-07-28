package AllFun.SideProject.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MatchingBoard extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id; // board id (pk)
    private String nickname; // member - nickname
    private String title; // 제목
    private String content; // 글의 내용
    private int projectMembers; // 프로젝트 구성 인원
    private int entryMembers; // 참여 인원
    private int hit; // 조회수

    public static MatchingBoard createBoard(String nickname, String title, String content, int hope){
        MatchingBoard board = new MatchingBoard();
        board.setNickname(nickname);
        board.setTitle(title);
        board.setContent(content);
        board.setProjectMembers(hope);
        board.setEntryMembers(0);
        board.setHit(0);
        return board;
    }

}
