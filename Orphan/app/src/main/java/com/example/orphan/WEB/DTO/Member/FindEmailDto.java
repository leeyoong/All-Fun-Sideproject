package com.example.orphan.WEB.DTO.Member;

public class FindEmailDto {
    public FindEmailDto(String name, String birth, String phone) {
        this.name = name;
        this.birth = birth;
        this.phone = phone;
    }

    private String name;
    private String birth;
    private String phone;

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

    @Override
    public String toString() {
        return "FindEmailDto{" +
                "name='" + name + '\'' +
                ", birth='" + birth + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
