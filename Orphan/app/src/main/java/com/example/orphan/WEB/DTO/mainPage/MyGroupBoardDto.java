package com.example.orphan.WEB.DTO.mainPage;


import java.time.LocalDateTime;

public class MyGroupBoardDto {
    private String groupName;
    private Long groupBoardId;
    private String title;
    private String writer;
    private String createdDate;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

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

    public MyGroupBoardDto(String groupName, Long groupBoardId, String title, String writer, String createdDate) {
        this.groupName = groupName;
        this.groupBoardId = groupBoardId;
        this.title = title;
        this.writer = writer;
        this.createdDate = createdDate;
    }
}
