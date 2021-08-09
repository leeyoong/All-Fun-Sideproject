package com.example.orphan.WEB.DTO.mainPage;

import com.example.orphan.WEB.DTO.matching.BoardRoleDto;
import com.example.orphan.WEB.base.BoardStatus;

import java.time.LocalDateTime;
import java.util.List;

public class MyMatchingBoardDto {
    private Long boardId;
    private String title;
    private String writer;
    private LocalDateTime createdDate;
    private LocalDateTime endDate;

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public List<BoardRoleDto> getExpect() {
        return expect;
    }

    public void setExpect(List<BoardRoleDto> expect) {
        this.expect = expect;
    }

    public BoardStatus getStatus() {
        return status;
    }

    public void setStatus(BoardStatus status) {
        this.status = status;
    }

    public MyMatchingBoardDto(Long boardId, String title, String writer, LocalDateTime createdDate, LocalDateTime endDate, List<BoardRoleDto> expect, BoardStatus status) {
        this.boardId = boardId;
        this.title = title;
        this.writer = writer;
        this.createdDate = createdDate;
        this.endDate = endDate;
        this.expect = expect;
        this.status = status;
    }

    private List<BoardRoleDto> expect;

    private BoardStatus status;

}
