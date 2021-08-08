package com.example.orphan.WEB.DTO.member;


public class CreateMemberDto {
    private String email; //중복체크 & 이메일 인증 완료된 이메일
    private String passwd;
    private String birth; //yyyy-mm-dd
    private String name;
    private String phone;
    private String nickname; //중복없는 닉네임
    private String gender; // Male Female


    public CreateMemberDto(String email, String passwd, String birth, String name, String phone, String nickname, String gender) {
        this.email = email;
        this.passwd = passwd;
        this.birth = birth;
        this.name = name;
        this.phone = phone;
        this.nickname = nickname;
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
