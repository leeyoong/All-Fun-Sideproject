package com.example.orphan.WEB.Thread;

import com.example.orphan.WEB.web.web;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Login_TaskThread extends Thread {
    static int count = 0;
    web Client = new web();
    String id = null;
    String pass = null;
    int status = 0;


    public Login_TaskThread(String id,String pass){
        this.id = id;
        this.pass = pass;


    }
    public int getStatus(){
        return status;
    }

    @Override
    public void run(){
        status=Client.Post_Login_Sync(id,pass);
    }


}
