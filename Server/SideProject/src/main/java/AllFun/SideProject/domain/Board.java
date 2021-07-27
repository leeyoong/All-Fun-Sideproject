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
public class Board {
    @Id
    @GeneratedValue
    private Long id; // board id (pk)
    private String nickname; // member - nickname
    private String title; // 제목
    private String content; // 글의 내용
    private String createDate; //작성날짜
    private String editDate = null; //수정 날짜
    private int projectMembers; // 프로젝트 구성 인원
    private int entryMembers; // 참여 인원
    private int hit; // 조회수

    public static Board createBoard(String nickname, String title, String content, String createDate, int hope){
        Board board = new Board();
        board.setNickname(nickname);
        board.setTitle(title);
        board.setContent(content);
        board.setCreateDate(createDate);
        board.setProjectMembers(hope);
        board.setEntryMembers(0);
        board.setHit(0);
        return board;
    }
}
