package com.example.orphan.WEB.Thread;

import com.example.orphan.WEB.web.web;

public class FindID_TaskThread extends Thread {
    web Client = new web();
    String name = null;
    String birth = null;
    String phone = null;
    String status;


    public FindID_TaskThread(String name, String birth, String PhoneNum){
        this.name = name;
        this.birth = birth;
        this.phone = PhoneNum;


    }
    public String getStatus(){
        return status;
    }

    @Override
    public void run(){
        status=Client.Post_FindEmail_Sync(this.name,this.birth,this.phone);
    }


}
