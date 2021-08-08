package com.example.orphan.WEB.Thread;
import com.example.orphan.WEB.web.web;



public class EmailCheck_TaskThread extends Thread {
    web Client = new web();
    String email = null;
    int status = 0;
    String CODE = null;

    public EmailCheck_TaskThread(String email){
        this.email = email;
    }
    public int getStatus(){
        return status;
    }
    public String getCode(){return CODE;}


    @Override
    public void run(){
        CODE=Client.Post_EmailCheck_Sync(this.email);
    }


}
