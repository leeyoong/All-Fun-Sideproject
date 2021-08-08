package com.example.orphan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.orphan.WEB.Thread.EmailCheck_TaskThread;

public class Registerpage extends AppCompatActivity {
    String[] yearList = new String[70];
    String[] monthList = new String[12];
    String[] dayList = new String[31];


    boolean checked_emailcode = false;
    boolean checked_password = false;
    boolean checked_nick = false;

    String send_email = null;
    String send_nick = null;
    String send_pass = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage);




        TextView email = (TextView) findViewById(R.id.editTextTextEmailAddress);
        TextView email_code = (TextView) findViewById(R.id.certmail);
        TextView password = (TextView) findViewById(R.id.passmade);
        TextView password_check = (TextView) findViewById(R.id.passmade2);
        TextView name = (TextView) findViewById(R.id.regname);
        TextView phone= (TextView) findViewById(R.id.regphone);
        TextView nick= (TextView) findViewById(R.id.regnick);
        RadioButton male = (RadioButton) findViewById(R.id.malebox);
        RadioButton female = (RadioButton) findViewById(R.id.femalebox);

        Button emailcheckbutton = (Button) findViewById(R.id.emailCheck);
        Button codecheckbutton = (Button) findViewById(R.id.codeCheck);
        //미구현
        //Button nickcheckbutton = (Button) findViewById(R.id.nickCheck);
        Button passcheckbutton = (Button) findViewById(R.id.passwordCheck);
        Button Registerbutton = (Button) findViewById(R.id.Register);

        //스피너


        setDay();setMonth();setYear();

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






        // email check를 눌렀을 경우
        emailcheckbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmailCheck_TaskThread task = new EmailCheck_TaskThread(email.getText().toString());
                task.start();
                try {
                    task.join();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }





                if(task.getStatus() == 200){
                    send_email =   email.getText().toString();
                }
                else{
                    System.out.println("서버 확인 안됨");
                }
            }
        });


        //codecheck 버튼을 눌렀을 경우

        codecheckbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {






            }
        });

        // password check를 눌렀을 경우


        passcheckbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {








            }
        });
        // nick check를 눌렀을 경우


        //구현 안됨






        //아래의 컴플리트 버튼을 눌렀을 경우
        Registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



























            }
        });





















    }


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





}