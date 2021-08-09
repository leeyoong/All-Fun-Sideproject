package com.example.orphan.WEB.DTO.mainPage;


import com.example.orphan.WEB.base.BoardKinds;

import java.time.LocalDateTime;

public class MyNoHitBoardDto {
    private Long groupId;
    private Long groupBoardId;

    private String title;
    private String content;
    private String createdDate;

    private Long memberId;
    private String memberNickname;

    private String groupName;

    private String kinds;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getMemberNickname() {
        return memberNickname;
    }

    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getKinds() {
        return kinds;
    }

    public void setKinds(String kinds) {
        this.kinds = kinds;
    }

    public MyNoHitBoardDto(Long groupId, Long groupBoardId, String title, String content, String createdDate, Long memberId, String memberNickname, String groupName, String kinds) {
        this.groupId = groupId;
        this.groupBoardId = groupBoardId;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.memberId = memberId;
        this.memberNickname = memberNickname;
        this.groupName = groupName;
        this.kinds = kinds;
    }
}
