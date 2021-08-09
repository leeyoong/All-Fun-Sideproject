package com.example.orphan.WEB.Thread;

import com.example.orphan.WEB.DTO.dashBoard.group.MyGroupListDto;
import com.example.orphan.WEB.web.web;

import java.util.List;

import retrofit2.Response;


public class getDashboard_TaskThread extends Thread {
    web Client = new web();
    Long memberid;
    Response<List<MyGroupListDto>> status;


    public getDashboard_TaskThread(Long memberid) {
        this.memberid = memberid;


    }

    public List<MyGroupListDto> getStatus() {
        return status.body();
    }

    @Override
    public void run() {
        status = Client.GET_groupBoard(memberid);
    }

}