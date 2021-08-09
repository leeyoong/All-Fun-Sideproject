package com.example.orphan.WEB.Thread;

import com.example.orphan.WEB.DTO.dashBoard.groupBoard.GroupBoardDetailDto;
import com.example.orphan.WEB.DTO.matching.ReadDetailDto;
import com.example.orphan.WEB.web.web;

public class GroupBoardDetail_TaskThread extends Thread{
    web Client = new web();
    Long boardId;
    Long memberId;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public GroupBoardDetailDto getResult() {
        return result;
    }

    public void setResult(GroupBoardDetailDto result) {
        this.result = result;
    }

    GroupBoardDetailDto result;


    public GroupBoardDetail_TaskThread(Long boardId, Long memberId){
        this.boardId = boardId;
        this.memberId = memberId;
    }



    @Override
    public void run(){
        result = Client.Patch_groupboardDetail(boardId, memberId);
    }
}
