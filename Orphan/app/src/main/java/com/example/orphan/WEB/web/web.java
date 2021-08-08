package com.example.orphan.WEB.web;

import android.content.Intent;
import android.util.Log;

import com.example.orphan.WEB.DTO.member.CreateMemberDto;
import com.example.orphan.WEB.DTO.member.FindEmailDto;
import com.example.orphan.WEB.DTO.member.FindPasswordDto;
import com.example.orphan.WEB.DTO.member.LoginDto;
import com.example.orphan.WEB.DTO.member.MemberLoginDto;
import com.example.orphan.WEB.DTO.member.OneItemDto;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class web {

    public static final String BASE_URL = "http://10.0.2.2:8080";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }




    public String Post_EmailCheck(String Email){
        //Web 생성
        ApiInterface apiService = web.getClient().create(ApiInterface.class);

        //보낼 오브젝트 생성

        // 요청 시작
        Call<OneItemDto> call = apiService.emailCheck(Email);
        call.enqueue(new Callback<OneItemDto>() {
            @Override
            public void onResponse(Call<OneItemDto> call, Response<OneItemDto> response) {
                try {
                    Log.d("TEST", response.body().toString());
                    OneItemDto OneItemDto = response.body();
                    if(response.code() == 200){
                        //성공했을 때 200

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
            public void onFailure(Call<OneItemDto> call, Throwable t) {
                //idfound.setText(t.toString());
            }
        });
        return null;
    }
    public String Post_Nickname(String Nickname){
        //Web 생성
        ApiInterface apiService = web.getClient().create(ApiInterface.class);

        //보낼 오브젝트 생성
        OneItemDto Object= new OneItemDto(Nickname);
        // 요청 시작
        Call<OneItemDto> call = apiService.nickNameCheck(Object);
        call.enqueue(new Callback<OneItemDto>() {
            @Override
            public void onResponse(Call<OneItemDto> call, Response<OneItemDto> response) {
                try {
                    Log.d("TEST", response.body().toString());
                    OneItemDto OneItemDto = response.body();
                    if(response.code() == 200){
                        //성공했을 때 200

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
            public void onFailure(Call<OneItemDto> call, Throwable t) {
                //idfound.setText(t.toString());
            }
        });
        return null;
    }
    public String Post_SendEmail(String Email){
        //Web 생성
        ApiInterface apiService = web.getClient().create(ApiInterface.class);

        //보낼 오브젝트 생성
        OneItemDto object= new OneItemDto(Email);
        // 요청 시작
        Call<OneItemDto> call = apiService.emailCheck(Email);
        call.enqueue(new Callback<OneItemDto>() {
            @Override
            public void onResponse(Call<OneItemDto> call, Response<OneItemDto> response) {
                try {
                    Log.d("TEST", response.body().toString());
                    OneItemDto OneItemDto = response.body();
                    if(response.code() == 200){
                        //성공했을 때 200

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
            public void onFailure(Call<OneItemDto> call, Throwable t) {
                //idfound.setText(t.toString());
            }
        });
        return null;
    }
    public String Post_Login(String Email, String password){
        //Web 생성
        ApiInterface apiService = web.getClient().create(ApiInterface.class);
        //보낼 오브젝트 생성
        LoginDto object = new LoginDto(Email,password);
        // 요청 시작

        Call<MemberLoginDto> call = apiService.login(object);
        call.enqueue(new Callback<MemberLoginDto>() {
            @Override
            public void onResponse(Call<MemberLoginDto> call, Response<MemberLoginDto> response) {
                try {
                    Log.d("TEST", response.body().toString());
                    MemberLoginDto data = response.body();
                    if(response.code() == 200){




                    }


                    else{

                        // 실패할 경우 40

                    }
                    //idfound.setText(OneItemDto.toString());
                } catch (Exception e) {

                    e.printStackTrace();


                }
            }



            @Override
            public void onFailure(Call<MemberLoginDto> call, Throwable t) {
                //idfound.setText(t.toString());
            }
        });
        return "ok";
    }

    public String Post_FindPassword(String name,String birth,String phone, String email){
        //Web 생성
        ApiInterface apiService = web.getClient().create(ApiInterface.class);

        //보낼 오브젝트 생성
        FindPasswordDto object = new FindPasswordDto(name,birth,phone,email);
        // 요청 시작
        Call<OneItemDto> call = apiService.findPW(object);
        call.enqueue(new Callback<OneItemDto>() {
            @Override
            public void onResponse(Call<OneItemDto> call, Response<OneItemDto> response) {
                try {
                    Log.d("TEST", response.body().toString());
                    OneItemDto OneItemDto = response.body();
                    //성공시

                    //idfound.setText(OneItemDto.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                    //ㅈ망했을 시

                }
            }

            @Override
            public void onFailure(Call<OneItemDto> call, Throwable t) {
                //idfound.setText(t.toString());
            }
        });
        return null;
    }
    public String Post_FindEmail(String name,String birth,String phone){
        //Web 생성
        ApiInterface apiService = web.getClient().create(ApiInterface.class);

        //보낼 오브젝트 생성
        FindEmailDto object = new FindEmailDto(name,birth,phone);
        // 요청 시작
        Call<OneItemDto> call = apiService.findID(object);
        call.enqueue(new Callback<OneItemDto>() {
            @Override
            public void onResponse(Call<OneItemDto> call, Response<OneItemDto> response) {
                try {
                    Log.d("TEST", response.body().toString());
                    OneItemDto OneItemDto = response.body();
                    //성공시

                    //idfound.setText(OneItemDto.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                    //ㅈ망했을 시

                }
            }

            @Override
            public void onFailure(Call<OneItemDto> call, Throwable t) {
                //idfound.setText(t.toString());
            }
        });
        return null;
    }
    public String Post_SignUp(String email, String passwd, String birth, String name, String phone, String nickname, String gender){
        //Web 생성
        ApiInterface apiService = web.getClient().create(ApiInterface.class);

        //보낼 오브젝트 생성
        CreateMemberDto object = new CreateMemberDto(email, passwd, birth, name, phone, nickname, gender);
        // 요청 시작
        Call<OneItemDto> call = apiService.createMember(object);
        call.enqueue(new Callback<OneItemDto>() {
            @Override
            public void onResponse(Call<OneItemDto> call, Response<OneItemDto> response) {
                try {
                    Log.d("TEST", response.body().toString());
                    OneItemDto OneItemDto = response.body();
                    //성공시

                    //idfound.setText(OneItemDto.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                    //ㅈ망했을 시

                }
            }

            @Override
            public void onFailure(Call<OneItemDto> call, Throwable t) {
                //idfound.setText(t.toString());
            }
        });
        return null;
    }

    public int Post_Login_Sync(String Email, String password){
        //Web 생성
        ApiInterface apiService = web.getClient().create(ApiInterface.class);
        //보낼 오브젝트 생성
        LoginDto object = new LoginDto(Email,password);
        // 요청 시작
        Call<MemberLoginDto> call = apiService.login(object);
        Response<MemberLoginDto> response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            System.out.println("sync ----연결실패");
        }
        System.out.println("sync ----web완료");
        if(response != null){
            System.out.println(response.headers().toString());
            return response.code();
        }
        else{
            return -1;
        }



    }
    public int Post_FindPassword_Sync(String name,String birth,String phone, String email) {
        //Web 생성
        ApiInterface apiService = web.getClient().create(ApiInterface.class);

        //보낼 오브젝트 생성
        FindPasswordDto object = new FindPasswordDto(name, birth, phone, email);
        // 요청 시작
        Call<OneItemDto> call = apiService.findPW(object);
        Response<OneItemDto> response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            System.out.println("sync ----연결실패");
        }
        System.out.println("sync ----web완료");
        if (response != null) {
            return response.code();
        } else {
            return -1;
        }
    }
    public int Post_FindEmail_Sync(String name,String birth,String phone){
        //Web 생성
        ApiInterface apiService = web.getClient().create(ApiInterface.class);

        //보낼 오브젝트 생성
        FindEmailDto object = new FindEmailDto(name,birth,phone);
        // 요청 시작
        Call<OneItemDto> call = apiService.findID(object);
        Response<OneItemDto> response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            System.out.println("sync ----연결실패");
        }
        System.out.println("sync ----web완료");
        if (response != null) {
            return response.code();
        } else {
            return -1;
        }
    }
    public int Post_SignUp_Sync(String email, String passwd, String birth, String name, String phone, String nickname, String gender){
        //Web 생성
        ApiInterface apiService = web.getClient().create(ApiInterface.class);

        //보낼 오브젝트 생성
        CreateMemberDto object = new CreateMemberDto(email, passwd, birth, name, phone, nickname, gender);
        // 요청 시작
        Call<OneItemDto> call = apiService.createMember(object);
        Response<OneItemDto> response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            System.out.println("sync ----연결실패");
        }
        System.out.println("sync ----web완료");
        if (response != null) {
            return response.code();
        } else {
            return -1;
        }
    }

    public String Post_EmailCheck_Sync(String Email){
        //Web 생성
        ApiInterface apiService = web.getClient().create(ApiInterface.class);

        //보낼 오브젝트 생성
        OneItemDto email = new OneItemDto(Email);
        // 요청 시작
        Call<OneItemDto> call = apiService.emailCheck(Email);
        Response<OneItemDto> response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            System.out.println("sync ----연결실패");
        }
        System.out.println("sync ----web완료");
        if (response != null) {
            return  response.body().toString();
        } else {
            return "error";
        }
    }
    public int Post_Nickname_Sync(String Nickname){
        //Web 생성
        ApiInterface apiService = web.getClient().create(ApiInterface.class);

        //보낼 오브젝트 생성
        OneItemDto Object= new OneItemDto(Nickname);
        // 요청 시작
        Call<OneItemDto> call = apiService.nickNameCheck(Object);
        Response<OneItemDto> response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            System.out.println("sync ----연결실패");
        }
        System.out.println("sync ----web완료");
        if (response != null) {
            return response.code();
        } else {
            return -1;
        }
    }
    public String Get_SendEmail_Sync(String Email){
        //Web 생성
        ApiInterface apiService = web.getClient().create(ApiInterface.class);

        //보낼 오브젝트 생성
        OneItemDto object= new OneItemDto(Email);
        // 요청 시작
        Call<OneItemDto> call = apiService.emailCheck(Email);
        Response<OneItemDto> response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            System.out.println("sync ----연결실패");
        }
        System.out.println("sync ----web완료");
        if (response != null) {
            return response.body().getItem();
        } else {
            return null;
        }
    }




}