package com.example.orphan.WEB.helper;

import com.example.orphan.WEB.web.web;

public class TaskThread extends Thread {
    static int count = 0;
    web Client = new web();
    String id = null;
    String pass = null;
    boolean status = false;

    public TaskThread(String id,String pass){
        this.id = id;
        this.pass = pass;


    }
    public boolean getStatus(){
        return status;
    }

    @Override
    public void run() {
        status=Client.Post_Login_Sync(id,pass);
    }


}
