package com.example.orphan.WEB.DTO.Member;

import java.time.LocalDateTime;

public class MemberDataDto {


    public  MemberDataDto(){
        this.id = null;
    }

    public MemberDataDto(MemberDataDto dto){
        this.id = dto.getId();
        this.email = dto.getEmail();
        this.passwd = dto.getPasswd();
        this.birth = dto.getBirth();
        this.name = dto.getName();
        this.phone = dto.getPhone();
        this.nickname = dto.getNickname();
        this.createDate = dto.getCreateDate();
        this.gender = dto.getGender();

    }

    public void setDTO(MemberDataDto dto){
        this.id = dto.getId();
        this.email = dto.getEmail();
        this.passwd = dto.getPasswd();
        this.birth = dto.getBirth();
        this.name = dto.getName();
        this.phone = dto.getPhone();
        this.nickname = dto.getNickname();
        this.createDate = dto.getCreateDate();
        this.gender = dto.getGender();

    }

    public MemberDataDto(Long id, String email, String passwd, String birth, String name, String phone, String nickname, LocalDateTime createDate, String gender) {
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

    private Long id; // member id (pk)
    private String email; // Log-In Id
    private String passwd; // password
    private String birth; // yyyy-mm-dd
    private String name; // user korean name
    private String phone; //phone number
    private String nickname; // nickname
    private LocalDateTime createDate; // create member time (yyyy-mm-dd hh:mm:ss)
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

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    @Override
    public String toString() {
        return "MemberDataDto{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", passwd='" + passwd + '\'' +
                ", birth='" + birth + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", nickname='" + nickname + '\'' +
                ", createDate=" + createDate +
                ", gender='" + gender + '\'' +
                '}';
    }
}
