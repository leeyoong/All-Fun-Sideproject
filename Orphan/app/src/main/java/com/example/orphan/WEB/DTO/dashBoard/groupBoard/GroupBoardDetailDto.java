package com.example.orphan.WEB.DTO.dashBoard.groupBoard;


import java.time.LocalDateTime;

public class GroupBoardDetailDto {

    private Long groupBoardId;

    private String title;

    private String content;

    private String writer;

    private String createdDate; //작성(수정) 날짜

    private Long memberId; // 사용자 id

    public Long getGroupBoardId() {
        return groupBoardId;
    }

    public void setGroupBoardId(Long groupBoardId) {
        this.groupBoardId = groupBoardId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public GroupBoardDetailDto(Long groupBoardId, String title, String content, String writer, String createdDate, Long memberId) {
        this.groupBoardId = groupBoardId;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createdDate = createdDate;
        this.memberId = memberId;
    }
}
