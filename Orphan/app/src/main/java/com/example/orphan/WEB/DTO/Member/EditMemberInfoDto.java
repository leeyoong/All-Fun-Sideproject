package com.example.orphan.WEB.DTO.member;


public class EditMemberInfoDto {
    private String phone; //phone number
    private String nickname; // nickname (변동 가능)
    private String introduce; //자기소개

    public EditMemberInfoDto(String phone, String nickname, String introduce) {
        this.phone = phone;
        this.nickname = nickname;
        this.introduce = introduce;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
