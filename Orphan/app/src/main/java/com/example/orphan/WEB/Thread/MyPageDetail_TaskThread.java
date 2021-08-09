package com.example.orphan.WEB.Thread;

import com.example.orphan.WEB.DTO.member.MyInfoDto;
import com.example.orphan.WEB.web.web;

public class MyPageDetail_TaskThread extends Thread {
    web Client = new web();
    private Long memberId;
    private MyInfoDto result;

    public MyPageDetail_TaskThread(Long memberId) {
        this.memberId = memberId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public MyInfoDto getResult() {
        return result;
    }

    public void setResult(MyInfoDto result) {
        this.result = result;
    }
    @Override
    public void run(){
        result = Client.GetMyInfo(memberId);
    }
}

