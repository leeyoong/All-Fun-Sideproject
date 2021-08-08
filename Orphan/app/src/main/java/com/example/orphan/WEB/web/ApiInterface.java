package com.example.orphan.WEB.web;



import com.example.orphan.WEB.DTO.Member.CreateMemberDto;
import com.example.orphan.WEB.DTO.Member.FindEmailDto;
import com.example.orphan.WEB.DTO.Member.FindPasswordDto;
import com.example.orphan.WEB.DTO.Member.ImageDto;
import com.example.orphan.WEB.DTO.Member.LoginDto;
import com.example.orphan.WEB.DTO.Member.MemberDataDto;
import com.example.orphan.WEB.DTO.Member.OneItemDto;


import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Streaming;

public interface ApiInterface {



    @POST("/auth/check/email")
    Call<OneItemDto> emailCheck(@Body OneItemDto Object);

    @GET("/auth/send/email")
    Call<OneItemDto> getEmailCODE(@Body OneItemDto Object);

    @POST("/auth/check/nickname")
    Call<OneItemDto> nickNameCheck(@Body OneItemDto Object);


    @POST("/auth/login")
    Call<MemberDataDto> login(@Body LoginDto Object);


    //sign up
    @POST("/auth/create")
    Call<OneItemDto> createMember(@Body CreateMemberDto jsonObject);

    //sign up
    @POST("/auth/findid")
    Call<OneItemDto> findID(@Body FindEmailDto Object);



    //send email
    @POST("/auth/findpw")
    Call<OneItemDto> findPW(@Body FindPasswordDto Object);



    //upload image

    //get image
    @GET("images/{apiName}")
    @Streaming
    Call<ImageDto> downloadImage(@Path("apiName") String apiName);





}
