package com.example.orphan.WEB.Thread;
import com.example.orphan.WEB.DTO.mainPage.MyGroupBoardDto;
import com.example.orphan.WEB.DTO.mainPage.MyNoHitBoardDto;
import com.example.orphan.WEB.web.web;

import java.util.List;


public class groupBoardNoHit_TaskThread extends Thread {
    web Client = new web();
    Long memberid;
    int Nohit;
    private List<MyNoHitBoardDto> DTO;


    public groupBoardNoHit_TaskThread(Long memberid) {
        this.memberid = memberid;
    }

    public Long getMemberid() {
        return memberid;
    }



    public void setNohit(int size){
        this.Nohit =  size;
    }
    public int getNoHit(){
        return this.Nohit;

    }
/*
    public List<MyGroupBoardDto> getDTO() {
        return DTO;
    }

    public void setDTO(List<MyGroupBoardDto> DTO) {
        this.DTO = DTO;
    }

 */

    @Override
    public void run(){
        this.Nohit = Client.GET_No_Hit_sync(memberid).body().size();

    }


}
