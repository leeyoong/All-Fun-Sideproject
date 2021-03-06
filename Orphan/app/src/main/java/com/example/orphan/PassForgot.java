package com.example.orphan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orphan.WEB.DTO.member.FindPasswordDto;
import com.example.orphan.WEB.DTO.member.OneItemDto;
import com.example.orphan.WEB.Thread.FindID_TaskThread;
import com.example.orphan.WEB.Thread.FindPass_TaskThread;
import com.example.orphan.WEB.web.ApiInterface;
import com.example.orphan.WEB.web.web;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PassForgot extends AppCompatActivity {
    String[] yearList = new String[70];
    String[] monthList = new String[12];
    String[] dayList = new String[31];

    public void setYear(){
        for(int i = 0; i < yearList.length; i++){

            yearList[i] = String.valueOf(2020 - i);
        }
    }

    public void setMonth(){
        for(int i = 0; i < monthList.length; i++){
            if(i+1 < 10){
                monthList[i] = new String("0" + Integer.toString(i+1));
            }
            else{
                monthList[i] = String.valueOf(i+1);
            }

        }
    }

    public void setDay() {
        for (int i = 0; i < dayList.length; i++) {
            if (i + 1 < 10) {
                dayList[i] = new String("0" + Integer.toString(i + 1));
            } else {
                dayList[i] = String.valueOf(i + 1);

            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_forgot);

        //스피너 값 세팅
        setYear();setMonth();setDay();

        //각종 버튼 선언
        Button FindPass = (Button) findViewById(R.id.Register);
        TextView Email = (TextView) findViewById(R.id.passfgtmail);
        TextView Name = (TextView) findViewById(R.id.idfgtname);
        TextView PhoneNumber = (TextView) findViewById(R.id.regphone);



        //스피너 선언
        Spinner YearSpinner = (Spinner) findViewById(R.id.spinner);
        Spinner MonthSpinner = (Spinner) findViewById(R.id.spinner2);
        Spinner DaySpinner = (Spinner) findViewById(R.id.spinner3);

        // 스피너 어댑터(activity , layout , 내가 넣을 배열) 선언
        ArrayAdapter<String> YearAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, yearList);
        ArrayAdapter<String> MonthAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, monthList);
        ArrayAdapter<String> DayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dayList);
        // 스피너 어댑터를 스피너에 붙이기
        YearSpinner.setAdapter(YearAdapter);
        MonthSpinner.setAdapter(MonthAdapter);
        DaySpinner.setAdapter(DayAdapter);



        // 전페이지의 값 가져오기
        Intent inten = getIntent();



        String email = getIntent().getStringExtra("email");
        String date = getIntent().getStringExtra("date");
        String name = getIntent().getStringExtra("name");
        String birth = getIntent().getStringExtra("birth");
        String phone = getIntent().getStringExtra("phone");

        if(email!=null){
            Email.setText(email);
        }
        if(name!=null){
        Name.setText(name);}
        if(phone!=null){
        PhoneNumber.setText(phone);}

        FindPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                String email = Email.getText().toString();
                String name = Name.getText().toString();
                String phonenumber = PhoneNumber.getText().toString();
                String year = YearSpinner.getSelectedItem().toString();
                String mouth = MonthSpinner.getSelectedItem().toString();
                String day = DaySpinner.getSelectedItem().toString();
                String birth = new String(year
                        +"-"+mouth+"-"+day);


                if(email.isEmpty()){
                    String output = "Email is empth";
                    System.out.println(output);


                }
                else if(name.isEmpty()){
                    String output = "Name is empth";
                    System.out.println(output);

                }
                else if(phonenumber.isEmpty()){
                    String output = "phone is empth";
                    System.out.println(output);
                }
                else if(birth.isEmpty()){
                    String output = "Name is empth";
                    System.out.println(output);

                }
                else if(year.isEmpty()){
                    String output = "year is empth";
                    System.out.println(output);
                }
                else if(mouth.isEmpty()){
                    String output = "mouth is empth";
                    System.out.println(output);
                }
                else if(day.isEmpty()){
                    String output = "day is empth";
                    System.out.println(output);
                }
                else{
                    web Clinet = new web();
                    ApiInterface apiService = web.getClient().create(ApiInterface.class);
                    FindPasswordDto object = new FindPasswordDto(name,birth,phonenumber,email);
                    // 요청 시작
                    Call<OneItemDto> call = apiService.findPW(object);

                    call.enqueue(new Callback<OneItemDto>() {
                        @Override
                        public void onResponse(Call<com.example.orphan.WEB.DTO.member.OneItemDto> call, Response<OneItemDto> response) {
                            try {
                                com.example.orphan.WEB.DTO.member.OneItemDto OneItemDto = response.body();
                                if(response.code() == 204){
                                    //성공했을 때 200
                                    System.out.println("이메이;ㄹ로 비밀번호 보냄 ");
                                }

                                else{
                                    // 실패할 경우 404

                                    System.out.println("실패");
                                }
                                //idfound.setText(OneItemDto.toString());
                            } catch (Exception e) {
                                e.printStackTrace();

                            }
                        }

                        @Override
                        public void onFailure(Call<com.example.orphan.WEB.DTO.member.OneItemDto> call, Throwable t) {
                            //idfound.setText(t.toString());
                        }
                    });
                }

            }
        });



    }
}