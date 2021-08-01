package AllFun.SideProject.domain.member;

import AllFun.SideProject.domain.dashBoard.GroupMember;
import AllFun.SideProject.domain.matching.Board;
import AllFun.SideProject.domain.base.BaseEntity;
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
public class Member extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name="member_id")
    private Long id; // member id (pk)

    private String email; // Log-In Id (이메일 변동 불가)
    private String passwd; // password
    private String birth; // yyyy-mm-dd
    private String name; // user korean name
    private String phone; //phone number
    private String nickname; // nickname (변동 가능)
    private String gender; // gender(MALE / FEMALE)

    private String introduce; //자기소개
    private String profileImg; // 프로필사진 저장경로

    @OneToMany(mappedBy = "member")
    private List<Board> boards = new ArrayList<>(); //내가 쓴 매칭 게시판

    @OneToMany(mappedBy="member")
    private List<EntryPool> entryPools = new ArrayList<>(); // 내가 지원한 매칭 게시판

    @OneToMany(mappedBy = "member")
    private List<GroupMember> groupMembers = new ArrayList<>(); //내가 속한 그룹

    @OneToMany(mappedBy = "member")
    private List<MemberRoom> memberRooms = new ArrayList<>(); // 쪽지방

    public static Member createMember(String email, String passwd, String birth, String name, String phone,
                                      String nickname, String gender){
        Member member = new Member();
        member.setEmail(email);
        member.setPasswd(passwd);
        member.setBirth(birth);
        member.setName(name);
        member.setPhone(phone);
        member.setNickname(nickname);
        member.setGender(gender);
        return member;
    }

    public void addBoard(Board board){
        boards.add(board);
        board.setMember(this);
    }

    public void addEntryPool(EntryPool entryPool){
        entryPools.add(entryPool);
        entryPool.setMember(this);
    }

    public void addGroupMember(GroupMember groupMember){
        groupMembers.add(groupMember);
        groupMember.setMember(this);
    }

    public void addMemberRoom(MemberRoom memberRoom){
        memberRooms.add(memberRoom);
        memberRoom.setMember(this);
    }
}
