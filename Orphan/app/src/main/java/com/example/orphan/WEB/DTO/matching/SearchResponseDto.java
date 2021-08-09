package com.example.orphan.WEB.DTO.matching;



import java.time.LocalDateTime;
import java.util.List;

public class SearchResponseDto {
    private Long boardId;
    private String title;
    private String writer;
    private String createdDate;
    private String endDate;

    public SearchResponseDto(Long boardId, String title, String writer, String createdDate, String endDate, String content, List<String> role) {
        this.boardId = boardId;
        this.title = title;
        this.writer = writer;
        this.createdDate = createdDate;
        this.endDate = endDate;
        this.content = content;
        this.role = role;
    }

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    private List<String> role;

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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }



}
