package AllFun.SideProject.domain.dashBoard;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Messenger {
    @Id
    @GeneratedValue
    @Column(name="messenger_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="group_id")
    private Group group; //그룹 id, 채팅 작성자 id 및 닉네임

    private String content; // 글 내용


}
