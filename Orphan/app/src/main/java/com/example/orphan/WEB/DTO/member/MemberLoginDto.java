package com.example.orphan.WEB.DTO.member;


import java.time.LocalDateTime;

public class MemberLoginDto {
    private Long id; // member id (pk)
    private String email; // Log-In Id
    private String passwd; // password
    private String birth; // yyyy-mm-dd
    private String name; // user korean name
    private String phone; //phone number
    private String nickname; // nickname
    private String createDate; // create member time (yyyy-mm-dd hh:mm:ss)
    private String gender; // gender(M / F)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public MemberLoginDto(Long id, String email, String passwd, String birth, String name, String phone, String nickname, String createDate, String gender) {
        this.id = id;
        this.email = email;
        this.passwd = passwd;
        this.birth = birth;
        this.name = name;
        this.phone = phone;
        this.nickname = nickname;
        this.createDate = createDate;
        this.gender = gender;
    }
}
