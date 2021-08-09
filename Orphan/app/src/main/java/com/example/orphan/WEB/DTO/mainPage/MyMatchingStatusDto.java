package com.example.orphan.WEB.DTO.mainPage;

import com.example.orphan.WEB.base.MatchingStatus;

public class MyMatchingStatusDto {
    private Long boardId;
    private String boardTitle;
    private String role;

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public MatchingStatus getStatus() {
        return status;
    }

    public void setStatus(MatchingStatus status) {
        this.status = status;
    }

    public MyMatchingStatusDto(Long boardId, String boardTitle, String role, MatchingStatus status) {
        this.boardId = boardId;
        this.boardTitle = boardTitle;
        this.role = role;
        this.status = status;
    }

    private MatchingStatus status;
}
