package com.example.orphan.WEB.Thread;
import com.example.orphan.WEB.DTO.mainPage.MyGroupBoardDto;
import com.example.orphan.WEB.web.web;

import java.util.List;


public class GroupBoard_TaskThread extends Thread {
    web Client = new web();
    Long memberid;
    private List<MyGroupBoardDto> DTO;


    public GroupBoard_TaskThread(Long memberid) {
        this.memberid = memberid;
    }

    public Long getMemberid() {
        return memberid;
    }


    public List<MyGroupBoardDto> getDTO() {
        return DTO;
    }

    public void setDTO(List<MyGroupBoardDto> DTO) {
        this.DTO = DTO;
    }

    @Override
    public void run(){
        DTO = Client.GET_GroupBoard_sync(memberid).body();
        System.out.println(DTO);
    }


}
