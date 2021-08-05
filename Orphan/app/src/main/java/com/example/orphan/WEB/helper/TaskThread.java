package com.example.orphan.WEB.helper;

import android.os.Looper;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.orphan.WEB.web.web;

import java.io.IOException;

public class TaskThread extends Thread {
    static int count = 0;
    private web Clinet = new web();
    private String id = null;
    private String pass = null;


    public TaskThread(String id, String pass) {
        this.id = id;
        this.pass = pass;

    }



    @Override
    public void run() {

        try {
            Clinet.Post_Login_Sync(id,pass);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
