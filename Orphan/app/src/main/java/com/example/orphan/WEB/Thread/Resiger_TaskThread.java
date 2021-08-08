package com.example.orphan.WEB.Thread;

import com.example.orphan.WEB.web.web;

public class Resiger_TaskThread  extends Thread {
    web Client = new web();
    String email = null;
    String passwd = null;
    String birth = null;
    String name = null;
    String phone = null;
    String nickname = null;
    String gender = null;
    int status = 0;


    public Resiger_TaskThread(String email, String passwd, String birth, String name, String phone, String nickname, String gender) {
        this.email = email;
        this.passwd = passwd;
        this.birth = birth;
        this.name = name;
        this.phone = phone;
        this.nickname = nickname;
        this.gender = gender;
    }

    public int getStatus(){
        return status;
    }

    @Override
    public void run(){
        status=Client.Post_SignUp_Sync(this.email, this.passwd, this.birth, this.name, this.phone, this.nickname, this.gender);
    }


}