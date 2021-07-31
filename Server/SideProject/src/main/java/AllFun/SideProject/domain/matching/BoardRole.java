package AllFun.SideProject.domain.matching;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardRole {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="board_id")
    private Board board;

    private String role; // 역할

    private int hope; //채용 인원

    @ColumnDefault("0")
    private int entry; //현재 참여 인원

    public static BoardRole createBoardRole(String role, int hope){
        BoardRole boardRole = new BoardRole();
        boardRole.setRole(role);
        boardRole.setHope(hope);
        return boardRole;
    }
}
