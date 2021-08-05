package AllFun.SideProject.service.member;

import AllFun.SideProject.domain.member.Member;
import AllFun.SideProject.domain.member.MemberRoom;
import AllFun.SideProject.domain.member.Note;
import AllFun.SideProject.domain.member.Room;
import AllFun.SideProject.dto.note.MessageDto;
import AllFun.SideProject.dto.note.NoteDataDto;
import AllFun.SideProject.dto.note.NoteRoomDto;
import AllFun.SideProject.repository.member.MemberRepository;
import AllFun.SideProject.repository.member.MemberRoomRepository;
import AllFun.SideProject.repository.member.NoteRepository;
import AllFun.SideProject.repository.member.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NoteService {
    private final MemberRepository memberRepository;
    private final MemberRoomRepository memberRoomRepository;
    private final NoteRepository noteRepository;
    private final RoomRepository roomRepository;

    /**
     * get chatting room like "Every Time.app"
     * @param memberId
     * @return
     */
    public List<NoteRoomDto> getNoteRoom(Long memberId){
        Member member = memberRepository.findById(memberId).orElse(null);
        List<MemberRoom> memberRooms = member.getMemberRooms();
        List<NoteRoomDto> response = new ArrayList<>();
        for (MemberRoom memberRoom : memberRooms) {
            NoteRoomDto noteRoomDto = new NoteRoomDto();
            noteRoomDto.setRoomId(memberRoom.getRoom().getId());
            MemberRoom opponentRoom = memberRoomRepository.findByRoomAndMemberNot(memberRoom.getRoom(),member)
                    .orElse(null);
            noteRoomDto.setOpponentId(opponentRoom.getMember().getId());
            noteRoomDto.setOpponentNickname(opponentRoom.getMember().getNickname());
            Note note = noteRepository.findFirstByRoomOrderByCreatedDateDesc(memberRoom.getRoom()).orElse(null);
            noteRoomDto.setRecentNoteDate(note.getCreatedDate());
            noteRoomDto.setRecentMessage(note.getMessage());
            response.add(noteRoomDto);
        }
        return response;
    }

    /**
     * get chatting data
     * @param roomId
     * @return
     */
    public List<NoteDataDto> getNoteData(Long roomId){
        Room room = roomRepository.findById(roomId).orElse(null);
        List<Note> notes = noteRepository.findAllByRoomOrderByCreatedDateDesc(room).orElse(null);
        List<NoteDataDto> response = new ArrayList<>();
        for (Note note : notes) {
            NoteDataDto noteDataDto = new NoteDataDto(
                    note.getMember().getId(),
                    note.getMember().getNickname(),
                    note.getMember().getProfileImg(),
                    note.getMessage(),
                    note.getCreatedDate()
            );
            response.add(noteDataDto);
        }
        return response;
    }

    /**
     * me - opponent : room check
     * @param myId
     * @param userId
     * @return
     */
    public Room hasRoom(Long myId, Long userId){
        Member me = memberRepository.findById(myId).orElse(null);

        List<MemberRoom> myMemberRooms = me.getMemberRooms();

        for (MemberRoom memberRoom : myMemberRooms) {
            MemberRoom opponentRoom = memberRoomRepository.findByRoomAndMemberNot(memberRoom.getRoom(),me)
                    .orElse(null);
            if(opponentRoom.getMember().getId() == userId){
                return opponentRoom.getRoom();
            }
        }
        return null;
    }

    /**
     * create chatting room
     * @param myId
     * @param userId
     * @return
     */
    @Transactional
    public Room createRoom(Long myId, Long userId){
        Room room = Room.createRoom();
        roomRepository.save(room);

        Member me = memberRepository.findById(myId).orElse(null);
        Member opponent = memberRepository.findById(userId).orElse(null);

        MemberRoom myMemberRoom = MemberRoom.createMemberRoom(room);
        me.addMemberRoom(myMemberRoom);
        memberRoomRepository.save(myMemberRoom);

        MemberRoom opponentMemberRoom = MemberRoom.createMemberRoom(room);
        opponent.addMemberRoom(opponentMemberRoom);
        memberRoomRepository.save(opponentMemberRoom);

        return room;
    }

    @Transactional
    public void createNote(Room room, Long senderId, MessageDto message){
        Member sender = memberRepository.findById(senderId).orElse(null);
        Note note = Note.createNote(message.getMessage(), sender);

        room.addNotes(note);

        noteRepository.save(note);

    }
}
