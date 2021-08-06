package com.example.orphan.WEB.helper;

import android.os.Looper;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.orphan.WEB.web.web;

import java.io.IOException;

public class TaskThread extends Thread {
    static int count = 0;

    private String id = null;
    private String pass = null;
    boolean result = false;


    public TaskThread(String id, String pass) {
        this.id = id;
        this.pass = pass;

    }



    @Override
    public void run() {
        web Clinet = new web();
        try {
            this.result=Clinet.Post_Login_Sync(id,pass);
            System.out.println("여기");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean Result() {
        return result;
    }
}
