package com.example.orphan.WEB.Thread;

import com.example.orphan.WEB.DTO.matching.ReadDetailDto;
import com.example.orphan.WEB.DTO.matching.SearchResponseDto;
import com.example.orphan.WEB.web.web;

import java.util.List;

public class MatchBoardDetail_TaskThread extends Thread{
    web Client = new web();
    Long boardId;

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public ReadDetailDto getResult() {
        return result;
    }

    public void setResult(ReadDetailDto result) {
        this.result = result;
    }

    ReadDetailDto result;


    public MatchBoardDetail_TaskThread(Long boardId){
        this.boardId = boardId;
    }



    @Override
    public void run(){
        result=Client.GET_Match_detail(boardId);
    }
}
