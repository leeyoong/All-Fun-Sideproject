package com.example.orphan.WEB.DTO.dashBoard.groupBoard;


import com.example.orphan.WEB.base.BoardKinds;

import java.time.LocalDateTime;

public class GroupBoardListDto {
    private Long groupBoardId;

    private Long memberId;

    private String memberNickname;

    private String title;

    private String createdDate;

    private String kinds;

    public Long getGroupBoardId() {
        return groupBoardId;
    }

    public void setGroupBoardId(Long groupBoardId) {
        this.groupBoardId = groupBoardId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getKinds() {
        return kinds;
    }

    public void setKinds(String kinds) {
        this.kinds = kinds;
    }

    public GroupBoardListDto(Long groupBoardId, Long memberId, String memberNickname, String title, String createdDate, String kinds) {
        this.groupBoardId = groupBoardId;
        this.memberId = memberId;
        this.memberNickname = memberNickname;
        this.title = title;
        this.createdDate = createdDate;
        this.kinds = kinds;
    }
}
