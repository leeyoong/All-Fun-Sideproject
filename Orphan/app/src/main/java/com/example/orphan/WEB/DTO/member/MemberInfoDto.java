package com.example.orphan.WEB.DTO.member;


public class MemberInfoDto {
    private String email; // Log-In Id (이메일 변동 불가)
    private String birth; // yyyy-mm-dd
    private String nickname; // nickname (변동 가능)
    private String gender; // gender(MALE / FEMALE)
    private String introduce; //자기소개

    public MemberInfoDto(String email, String birth, String nickname, String gender, String introduce) {
        this.email = email;
        this.birth = birth;
        this.nickname = nickname;
        this.gender = gender;
        this.introduce = introduce;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
