package AllFun.SideProject.domain.dashBoard;

import AllFun.SideProject.domain.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ToDo extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name="todo_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="group_id")
    private DashGroup group;

    @Column(name="end_date")
    private LocalDateTime endDate;

    private String title;

    public static ToDo createToDo(String title, LocalDateTime endDate){
        ToDo toDo = new ToDo();
        toDo.setTitle(title);
        toDo.setEndDate(endDate);
        return toDo;
    }
}
