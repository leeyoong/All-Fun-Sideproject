package com.example.orphan.WEB.web;



import com.example.orphan.WEB.DTO.mainPage.MyGroupBoardDto;
import com.example.orphan.WEB.DTO.mainPage.MyMatchingBoardDto;
import com.example.orphan.WEB.DTO.mainPage.MyMatchingStatusDto;
import com.example.orphan.WEB.DTO.mainPage.MyNoHitBoardDto;
import com.example.orphan.WEB.DTO.mainPage.MyScrapDto;
import com.example.orphan.WEB.DTO.mainPage.MyToDoDto;
import com.example.orphan.WEB.DTO.member.CreateMemberDto;
import com.example.orphan.WEB.DTO.member.FindEmailDto;
import com.example.orphan.WEB.DTO.member.FindPasswordDto;
import com.example.orphan.WEB.DTO.member.LoginDto;
import com.example.orphan.WEB.DTO.member.MemberLoginDto;
import com.example.orphan.WEB.DTO.member.OneItemDto;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {



    @GET("/auth/check/email/{email}")
    Call<OneItemDto> emailCheck(@Path("email") String email);

    @GET("/auth/send/email")
    Call<OneItemDto> getEmailCODE(@Body OneItemDto Object);

    @GET("/auth/check/nickname")
    Call<OneItemDto> nickNameCheck(@Body OneItemDto Object);


    @POST("/auth/login")
    Call<MemberLoginDto> login(@Body LoginDto Object);


    //sign up
    @POST("/auth/create")
    Call<OneItemDto> createMember(@Body CreateMemberDto jsonObject);

    //이메일 찾기
    @GET("/auth/find/email/name/{name}/birth/{birth}/phone/{phone}")
    Call<OneItemDto> findID(@Path("name") String name, @Path("birth")String birth, @Path("phone")String phone);



    //send email
    @PATCH("/auth/find/password")
    Call<OneItemDto> findPW(@Body FindPasswordDto Object);


    String home= "/home";

    @GET ("home/{memberId}/todo/{year}/{month}")
    Call<List<MyToDoDto>> GetMytodo(@Path("memberId") Long memberid, @Path("year") String year, @Path("month") String month);
    // String인데 숫자


    @GET ("home/{memberId}/matching/board")
    Call<List<MyMatchingBoardDto>> matchigBoard(@Path("memberId") Long memberid);

    @GET ("home/{memberId}/matching/status")
    Call<List<MyMatchingStatusDto>> matchigStatus(@Path("memberId") Long memberid);


    @GET ("home/{memberId}/matching/scrap")
    Call<List<MyScrapDto>> matchigScrap(@Path("memberId") Long memberid);


    @GET ("home/{memberId}/group/board")
    Call<List<MyGroupBoardDto>> groupBoard(@Path("memberId") Long memberid);


    @GET ("home/{memberId}/group/board/no/hit")
    Call<List<MyNoHitBoardDto>> groupBoardNoHit(@Path("memberId") Long memberid);
    //이거 변동사항 .size




}
