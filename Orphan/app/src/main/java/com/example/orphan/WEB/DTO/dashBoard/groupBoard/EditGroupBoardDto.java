package com.example.orphan.WEB.DTO.dashBoard.groupBoard;


public class EditGroupBoardDto {

    private Long groupBoardId;

    private String title;

    private String content;

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

    public EditGroupBoardDto(Long groupBoardId, String title, String content) {
        this.groupBoardId = groupBoardId;
        this.title = title;
        this.content = content;
    }
}
