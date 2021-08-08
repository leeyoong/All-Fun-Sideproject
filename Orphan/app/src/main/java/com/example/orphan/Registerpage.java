package com.example.orphan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orphan.WEB.Thread.EmailCheck_TaskThread;
import com.example.orphan.WEB.Thread.FindID_TaskThread;
import com.example.orphan.WEB.Thread.Register_TaskThread;

public class Registerpage extends AppCompatActivity {
    String[] yearList = new String[70];
    String[] monthList = new String[12];
    String[] dayList = new String[31];


    boolean checked_emailcode = true;
    boolean checked_password = false;
    boolean checked_nick = false;
    String CODE = null;
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
                String chkMail = email.getText().toString();
                EmailCheck_TaskThread task = new EmailCheck_TaskThread(chkMail);
                task.start();
                try {
                    task.join();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                if(task.getCode() != null){
                    send_email =   chkMail;
                    CODE = task.getCode();
                    System.out.println("사용 가능");
                }
                else{
                    System.out.println("이미 회원가입한 아이디 입니다");
                }
            }
        });


        //codecheck 버튼을 눌렀을 경우

        codecheckbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CODE ==null){
                    System.out.println("이메일 인증을 먼저해주세요");


                }
                else{
                    if(CODE.equals(email_code.getText().toString())){

                        checked_emailcode = true;
                        System.out.println("완료");
                    }
                    else{
                        System.out.println("인증 오류");

                    }

                }





            }
        });

        // password check를 눌렀을 경우


        passcheckbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //TextView password password_check
                String passwd =password.getText().toString();
                String passwd2 = password_check.getText().toString();

                if(!passwd.isEmpty()) {
                    if (passwd.equals(passwd2)) {
                        checked_password = true;
                        send_pass = passwd;
                        System.out.println("이 비밀번호로 저장됩니다. 다른 비밀번호를 원하시면 다시 Check를 눌러주세요" );

                    }

                    else{
                        System.out.println("비밀번호 확인과 다릅니다");

                    }

                }
                else{
                    System.out.println("비밀번호를 입력해주세요");
                }






            }
        });
        // nick check를 눌렀을 경우


        //구현 안됨






        //아래의 컴플리트 버튼을 눌렀을 경우
        Registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //send_email - ok
                //send_pass - ok
                //send_nick - (버튼 구현안됨)
                //send_gender
                //send_nick
                String send_name = name.getText().toString();
                String send_phone = phone.getText().toString();
                String year = YearSpinner.getSelectedItem().toString();
                String mouth = MonthSpinner.getSelectedItem().toString();
                String day = DaySpinner.getSelectedItem().toString();
                String send_nick = nick.getText().toString();
                String send_gender = "male";
                String send_birth = new String(year
                        +"-"+mouth+"+"+day);
                if(send_name.isEmpty()){
                    String output = "Name is empth";
                    System.out.println(output);

                }
                else if(send_phone.isEmpty()){
                    String output = "phone is empth";
                    System.out.println(output);
                }
                else if(send_birth.isEmpty()){
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
                else if(!checked_password) {
                    String output = "비밀번호 체크하세요";
                    System.out.println(output);
                }
                else if(!checked_emailcode) {
                    String output = "이메일 코드 인증하세요";
                    System.out.println(output);
                }
                //else if(!checked_nick) {
                //    String output = "비밀번호 체크하세요";

                //}

                else{
                    Register_TaskThread task = new Register_TaskThread(email.getText().toString(),send_pass,send_birth,send_name,send_phone,send_nick,send_gender);
                    task.start();
                    try {
                        task.join();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //융이에게 물어볼꺼
                    if(task.getStatus()==204){

                        Intent nextIntent = new Intent(Registerpage.this, Loginpage.class);
                        nextIntent.putExtra("email", send_email);
                        nextIntent.putExtra("name",send_name);
                        nextIntent.putExtra("birth",send_birth);
                        Registerpage.this.startActivity(nextIntent);




                    }
                    else{
                        String output =new String("ERROR CODE = " + task.getStatus());
                        System.out.println(output);

                        Toast myToast = Toast.makeText(getApplicationContext(),output, Toast.LENGTH_LONG);
                        myToast.show();
                    }




                }



























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