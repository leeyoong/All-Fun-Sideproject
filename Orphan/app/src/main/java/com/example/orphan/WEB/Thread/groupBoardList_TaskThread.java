package com.example.orphan.WEB.Thread;

import com.example.orphan.WEB.DTO.dashBoard.group.MyGroupListDto;
import com.example.orphan.WEB.DTO.dashBoard.groupBoard.GroupBoardListDto;
import com.example.orphan.WEB.web.web;

import java.util.List;

import retrofit2.Response;

public class groupBoardList_TaskThread extends Thread{
    web Client = new web();
    Long groupid;
    GroupBoardListDto notice;
    List<GroupBoardListDto> other;

    public GroupBoardListDto getNotice() {
        return notice;
    }

    public void setNotice(GroupBoardListDto notice) {
        this.notice = notice;
    }

    public List<GroupBoardListDto> getOther() {
        return other;
    }

    public void setOther(List<GroupBoardListDto> other) {
        this.other = other;
    }

    public groupBoardList_TaskThread(Long groupid) {
        this.groupid = groupid;


    }

    @Override
    public void run() {
        notice = Client.GET_groupNotice(groupid);
        other = Client.GET_groupBoardList_sync(groupid);
    }

}
