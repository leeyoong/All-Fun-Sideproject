package AllFun.SideProject.domain.dashBoard;

import AllFun.SideProject.domain.base.BaseEntity;
import AllFun.SideProject.domain.matching.Board;
import AllFun.SideProject.domain.matching.EntryPool;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class DashGroup extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name="group_id")
    private Long id;

    @Column(name="group_name")
    private String groupName;

    @OneToOne(mappedBy="group",cascade = CascadeType.REMOVE)
    private Board board; // 매칭 게시판 id
    
    @OneToMany(mappedBy = "group",cascade = CascadeType.REMOVE)
    private List<GroupBoard> groupBoards; // 그룹 게시판

    @OneToMany(mappedBy= "group",cascade = CascadeType.REMOVE)
    private List<ToDo> toDos; // to-do list

    @OneToMany(mappedBy="group",cascade = CascadeType.REMOVE)
    private List<GroupMember> groupMembers = new ArrayList<>();

    public static DashGroup createDashGroup(String groupName){
        DashGroup dashGroup = new DashGroup();

        dashGroup.setGroupName(groupName);

        return dashGroup;
    }

    public void addGroupBoard(GroupBoard groupBoard){
        groupBoards.add(groupBoard);
        groupBoard.setGroup(this);
    }

    public void addToDo(ToDo todo){
        toDos.add(todo);
        todo.setGroup(this);
    }

    public void addGroupMember(GroupMember groupMember){
        groupMembers.add(groupMember);
        groupMember.setGroup(this);
    }
}
