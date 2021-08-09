package com.example.orphan.WEB.DTO.member;


public class MyInfoDto {
    private String email; // Log-In Id (이메일 변동 불가)
    private String birth; // yyyy-mm-dd
    private String name; // user korean name
    private String phone; //phone number
    private String nickname; // nickname (변동 가능)
    private String gender; // gender(MALE / FEMALE)
    private String introduce; //자기소개

    private int myGroups;

    public MyInfoDto(String email, String birth, String name, String phone, String nickname, String gender, String introduce, int myGroups, int myEntryPool) {
        this.email = email;
        this.birth = birth;
        this.name = name;
        this.phone = phone;
        this.nickname = nickname;
        this.gender = gender;
        this.introduce = introduce;
        this.myGroups = myGroups;
        this.myEntryPool = myEntryPool;
    }

    private int myEntryPool;

    public int getMyGroups() {
        return myGroups;
    }

    public void setMyGroups(int myGroups) {
        this.myGroups = myGroups;
    }

    public int getMyEntryPool() {
        return myEntryPool;
    }

    public void setMyEntryPool(int myEntryPool) {
        this.myEntryPool = myEntryPool;
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

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

}
