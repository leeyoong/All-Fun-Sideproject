package com.example.orphan.WEB.Thread;

import com.example.orphan.WEB.web.web;

public class FindPass_TaskThread extends Thread{
    web Client = new web();
    String email = null;
    String name = null;
    String birth = null;
    String phone = null;
    int status = 0;


    public FindPass_TaskThread(String Email,String name, String birth, String PhoneNum){
        this.email = Email;
        this.name = name;
        this.birth = birth;
        this.phone = PhoneNum;


    }
    public int getStatus(){
        return status;
    }

    @Override
    public void run(){
        status=Client.Post_FindPassword_Sync(this.email,this.name,this.birth,this.phone);
    }



}
