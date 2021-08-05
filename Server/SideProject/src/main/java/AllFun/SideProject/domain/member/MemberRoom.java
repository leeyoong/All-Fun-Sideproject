package AllFun.SideProject.domain.member;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberRoom {

    @Id
    @GeneratedValue
    @Column(name = "member_room_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="room_id")
    private Room room;

    public static MemberRoom createMemberRoom(Room room){
        MemberRoom memberRoom = new MemberRoom();
        memberRoom.setRoom(room);
        return memberRoom;
    }
}
