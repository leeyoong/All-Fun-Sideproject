package com.example.orphan.WEB.DTO.matching;

public class CreateBoardPossibleDto {
    private Long groupId;
    private String groupName;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public CreateBoardPossibleDto(Long groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }
}
