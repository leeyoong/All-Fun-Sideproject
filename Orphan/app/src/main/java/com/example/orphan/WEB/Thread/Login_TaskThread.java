package com.example.orphan.WEB.Thread;

import com.example.orphan.WEB.DTO.member.MemberLoginDto;
import com.example.orphan.WEB.web.web;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import retrofit2.Response;

public class Login_TaskThread extends Thread {
    static int count = 0;
    web Client = new web();
    String id = null;
    String pass = null;
    Response<MemberLoginDto> status;


    public Login_TaskThread(String id,String pass){
        this.id = id;
        this.pass = pass;

    }




    public int getSTATUSCODE()
    {
        return status.code();
    }

    public MemberLoginDto getDTO(){
        return status.body();
    }

    @Override
    public void run(){
        status=Client.Post_Login_Sync(id,pass);
    }


}
