package AllFun.SideProject.domain.matching;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardCategoryEdu {
    @Id
    @GeneratedValue
    private Long id;
    private String tag; // 대학교재학, 대학졸업, 직장인

}
