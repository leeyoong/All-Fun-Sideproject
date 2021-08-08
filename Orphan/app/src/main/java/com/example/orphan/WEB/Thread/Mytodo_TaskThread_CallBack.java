package com.example.orphan.WEB.Thread;

import android.util.Log;

import com.example.orphan.WEB.DTO.mainPage.MyToDoDto;
import com.example.orphan.WEB.DTO.member.OneItemDto;
import com.example.orphan.WEB.web.ApiInterface;
import com.example.orphan.WEB.web.web;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Mytodo_TaskThread_CallBack extends Thread {
    private Long memberid;
    private String year;
    private String month;
    private web Client = new web();

    public List<MyToDoDto> getDTO() {
        return DTO;
    }

    public void setDTO(List<MyToDoDto> DTO) {
        this.DTO = DTO;
    }

    private List<MyToDoDto> DTO;


    public Long getMemberid() {
        return memberid;
    }

    public void setMemberid(Long memberid) {
        this.memberid = memberid;
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

    public Mytodo_TaskThread_CallBack(Long memberid, String year, String month) {
        this.memberid = memberid;
        this.year = year;
        this.month = month;
    }

    @Override
    public void run(){

            //Web 생성
            ApiInterface apiService = web.getClient().create(ApiInterface.class);

            //보낼 오브젝트 생성

            // 요청 시작
            Call<List<MyToDoDto>> call = apiService.GetMytodo(memberid,year,month);
            call.enqueue(new Callback<List<MyToDoDto>>() {
                @Override
                public void onResponse(Call<List<MyToDoDto>> call, Response<List<MyToDoDto>> response) {
                    try {
                        Log.d("TEST", response.body().toString());
                        if(response.code() == 200){
                            System.out.println("안되면 그때 생각하자고~");
                            setDTO(response.body());

                        }

                        else{
                            // 실패할 경우 404

                        }
                        //idfound.setText(OneItemDto.toString());
                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                }




                @Override
                public void onFailure(Call<List<MyToDoDto>> call, Throwable t) {
                    //idfound.setText(t.toString());
                }
            });




    }



}
