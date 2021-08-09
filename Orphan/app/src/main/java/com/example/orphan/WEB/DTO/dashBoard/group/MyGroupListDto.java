package com.example.orphan.WEB.DTO.dashBoard.group;


public class MyGroupListDto {
    private Long groupId;
    private String title;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MyGroupListDto(Long groupId, String title) {
        this.groupId = groupId;
        this.title = title;
    }
}
