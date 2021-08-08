package com.example.orphan.WEB.DTO.note;

import java.time.LocalDateTime;

public class NoteDataDto {
    private Long sendMemberId;
    private String sendMemberNickname;
    private String sendMemberImg; // 일단 str 처리
    private String sendMessage;
    private LocalDateTime sendTime;

    public Long getSendMemberId() {
        return sendMemberId;
    }

    public void setSendMemberId(Long sendMemberId) {
        this.sendMemberId = sendMemberId;
    }

    public String getSendMemberNickname() {
        return sendMemberNickname;
    }

    public void setSendMemberNickname(String sendMemberNickname) {
        this.sendMemberNickname = sendMemberNickname;
    }

    public String getSendMemberImg() {
        return sendMemberImg;
    }

    public void setSendMemberImg(String sendMemberImg) {
        this.sendMemberImg = sendMemberImg;
    }

    public String getSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(String sendMessage) {
        this.sendMessage = sendMessage;
    }

    public LocalDateTime getSendTime() {
        return sendTime;
    }

    public void setSendTime(LocalDateTime sendTime) {
        this.sendTime = sendTime;
    }

    public NoteDataDto(Long sendMemberId, String sendMemberNickname, String sendMemberImg, String sendMessage, LocalDateTime sendTime) {
        this.sendMemberId = sendMemberId;
        this.sendMemberNickname = sendMemberNickname;
        this.sendMemberImg = sendMemberImg;
        this.sendMessage = sendMessage;
        this.sendTime = sendTime;
    }
}
