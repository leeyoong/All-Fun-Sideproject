package com.example.orphan.WEB.Thread;
import com.example.orphan.WEB.DTO.mainPage.MyGroupBoardDto;
import com.example.orphan.WEB.DTO.mainPage.MyNoHitBoardDto;
import com.example.orphan.WEB.DTO.mainPage.MyToDoDto;
import com.example.orphan.WEB.web.web;

import java.util.List;


public class Mytodo_TaskThread extends Thread {
    web Client = new web();
    Long memberid;
    String year;
    String month;
    private List<MyToDoDto> DTO;


    public Mytodo_TaskThread(Long memberid, String year, String month) {
        this.memberid = memberid;
        this.year = year;
        this.month = month;
    }

    public Long getMemberid() {
        return memberid;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public List<MyToDoDto> getDTO() {
        return DTO;
    }

    public void setDTO(List<MyToDoDto> DTO) {
        this.DTO = DTO;
    }

    @Override
    public void run(){
        DTO = Client.Post_Mytodo_sync(this.memberid,this.year,this.month).body();

    }


}
