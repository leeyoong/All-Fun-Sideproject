package com.example.orphan.WEB.Thread;

import com.example.orphan.WEB.DTO.dashBoard.todo.GroupToDoDto;
import com.example.orphan.WEB.DTO.mainPage.MyGroupBoardDto;
import com.example.orphan.WEB.web.web;

import java.util.List;

public class groupToDoList_TaskThread extends Thread {
    web Client = new web();
    Long groupid;

    public Long getGroupid() {
        return groupid;
    }

    public void setGroupid(Long groupid) {
        this.groupid = groupid;
    }

    String year;

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

    String month;

    private List<GroupToDoDto> DTO;


    public groupToDoList_TaskThread(Long groupid, String year, String month) {
        this.groupid = groupid;
        this.year = year;
        this.month = month;
    }



    public List<GroupToDoDto> getDTO() {
        return DTO;
    }

    public void setDTO(List<GroupToDoDto> DTO) {
        this.DTO = DTO;
    }

    @Override
    public void run(){
        DTO = Client.GET_GroupToDoList_sync(groupid,year,month).body();
    }
}
