package com.example.orphan.WEB.Thread;

import com.example.orphan.WEB.DTO.matching.SearchResponseDto;
import com.example.orphan.WEB.web.web;

import java.util.List;

import retrofit2.Response;

public class MatchBoardList_Recently_TaskThread extends Thread{

    web Client = new web();
    String filter = "none";
    List<SearchResponseDto> result;

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public List<SearchResponseDto> getResult() {
        return result;
    }

    public void setResult(List<SearchResponseDto> result) {
        this.result = result;
    }

    public MatchBoardList_Recently_TaskThread(String filter){
        this.filter = filter;
    }



    @Override
    public void run(){
        result=Client.GET_MatchingBoardList_Recently(filter);
    }


}
