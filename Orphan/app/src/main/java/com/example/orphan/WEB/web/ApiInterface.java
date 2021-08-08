package com.example.orphan.WEB.web;



import com.example.orphan.WEB.DTO.member.CreateMemberDto;
import com.example.orphan.WEB.DTO.member.FindEmailDto;
import com.example.orphan.WEB.DTO.member.FindPasswordDto;
import com.example.orphan.WEB.DTO.member.LoginDto;
import com.example.orphan.WEB.DTO.member.MemberLoginDto;
import com.example.orphan.WEB.DTO.member.OneItemDto;


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





}
