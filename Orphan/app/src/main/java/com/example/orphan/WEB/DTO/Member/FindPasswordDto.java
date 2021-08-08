package com.example.orphan.WEB.DTO.member;


public class FindPasswordDto {
    private String name;
    private String birth;
    private String phone;
    private String email;

    public FindPasswordDto(String name, String birth, String phone, String email) {
        this.name = name;
        this.birth = birth;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
