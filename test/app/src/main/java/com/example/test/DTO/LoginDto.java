package com.example.test.DTO;

public class LoginDto {
    public LoginDto(String email, String passwd) {
        this.email = email;
        this.passwd = passwd;
    }

    private String email;
    private String passwd;

    @Override
    public String toString() {
        return "LoginDto{" +
                "email='" + email + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
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


}
