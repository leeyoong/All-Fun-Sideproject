package AllFun.SideProject.service.member;

import AllFun.SideProject.domain.member.Member;
import AllFun.SideProject.domain.member.MemberRoom;
import AllFun.SideProject.domain.member.Note;
import AllFun.SideProject.domain.member.Room;
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
}
