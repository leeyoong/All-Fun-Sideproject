package com.example.orphan.WEB.DTO.dashBoard.groupBoard;


import java.time.LocalDateTime;

public class CommentListDto {
    private Long commentId;
    private String memberNickname;
    private String memberComment;
    private LocalDateTime createdDate;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getMemberNickname() {
        return memberNickname;
    }

    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }

    public String getMemberComment() {
        return memberComment;
    }

    public void setMemberComment(String memberComment) {
        this.memberComment = memberComment;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public CommentListDto(Long commentId, String memberNickname, String memberComment, LocalDateTime createdDate) {
        this.commentId = commentId;
        this.memberNickname = memberNickname;
        this.memberComment = memberComment;
        this.createdDate = createdDate;
    }
}
