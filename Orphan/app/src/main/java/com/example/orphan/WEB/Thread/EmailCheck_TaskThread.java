package com.example.orphan.WEB.Thread;
import com.example.orphan.WEB.web.web;



public class EmailCheck_TaskThread extends Thread {
    web Client = new web();
    String email = null;
    int status = 0;


    public EmailCheck_TaskThread(String email){
        this.email = email;
    }
    public int getStatus(){
        return status;
    }

    @Override
    public void run(){
        status=Client.Post_EmailCheck_Sync(this.email);
    }


}
