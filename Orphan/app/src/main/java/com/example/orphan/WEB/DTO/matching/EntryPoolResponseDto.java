package com.example.orphan.WEB.DTO.matching;


import com.example.orphan.WEB.base.MatchingStatus;

public class EntryPoolResponseDto {

    //사용자 Id
    private Long memberId;
    private String memberNickname;
    private String img;// 임시로 string 처리
    //매칭 결과 (~중 / 탈락 / 합격)
    private MatchingStatus status;

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public MatchingStatus getStatus() {
        return status;
    }

    public void setStatus(MatchingStatus status) {
        this.status = status;
    }

    public EntryPoolResponseDto(Long memberId, String memberNickname, String img, MatchingStatus status) {
        this.memberId = memberId;
        this.memberNickname = memberNickname;
        this.img = img;
        this.status = status;
    }
}
