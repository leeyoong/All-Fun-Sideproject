package com.example.orphan.helper;


import com.example.orphan.web.web;


public class TaskThread extends Thread {
    static int count = 0;

    String id = null;
    String pass = null;
    boolean connect = false;
    public TaskThread(String id, String pass){
        this.id = id;
        this.pass = pass;

    }
    public boolean Result(){
        return this.connect;

    }

    @Override
    public void run() {
        try{
        web Client = new web();
        this.connect = Client.Post_Login_Sync(id,pass);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        }


}
