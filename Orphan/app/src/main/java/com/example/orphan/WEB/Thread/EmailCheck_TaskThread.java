package com.example.orphan.WEB.Thread;
import com.example.orphan.WEB.web.web;



public class EmailCheck_TaskThread extends Thread {
    web Client = new web();
    String email = null;
    int status = 0;
    private String code;

    public EmailCheck_TaskThread(String email){
        this.email = email;
    }
    public int getStatus(){
        return status;
    }
    public String getCode(){return code;}

    public void setCode(String code){
        this.code = code;
    }

    @Override
    public void run(){
        setCode(Client.Post_EmailCheck_Sync(this.email));
        System.out.println("섹스다 시발"+code);
    }


}
