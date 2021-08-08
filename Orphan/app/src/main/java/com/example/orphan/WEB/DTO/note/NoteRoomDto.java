package com.example.orphan.WEB.DTO.note;

import java.time.LocalDateTime;

public class NoteRoomDto {
    private Long roomId;

    private Long opponentId; // 상대방 id
    private String opponentNickname; // 상대방 닉네임
    private LocalDateTime recentNoteDate;
    private String recentMessage;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getOpponentId() {
        return opponentId;
    }

    public void setOpponentId(Long opponentId) {
        this.opponentId = opponentId;
    }

    public String getOpponentNickname() {
        return opponentNickname;
    }

    public void setOpponentNickname(String opponentNickname) {
        this.opponentNickname = opponentNickname;
    }

    public LocalDateTime getRecentNoteDate() {
        return recentNoteDate;
    }

    public void setRecentNoteDate(LocalDateTime recentNoteDate) {
        this.recentNoteDate = recentNoteDate;
    }

    public String getRecentMessage() {
        return recentMessage;
    }

    public void setRecentMessage(String recentMessage) {
        this.recentMessage = recentMessage;
    }

    public NoteRoomDto(Long roomId, Long opponentId, String opponentNickname, LocalDateTime recentNoteDate, String recentMessage) {
        this.roomId = roomId;
        this.opponentId = opponentId;
        this.opponentNickname = opponentNickname;
        this.recentNoteDate = recentNoteDate;
        this.recentMessage = recentMessage;
    }
}
