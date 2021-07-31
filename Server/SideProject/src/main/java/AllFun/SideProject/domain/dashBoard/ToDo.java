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
    private Long id;

    @ManyToOne
    @JoinColumn(name="group_id")
    private Group group;

    @Column(name="end_date")
    private LocalDateTime endDate;

    private String title;

    private String content;
}
