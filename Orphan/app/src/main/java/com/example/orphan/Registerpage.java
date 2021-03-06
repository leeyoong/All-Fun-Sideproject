package com.example.orphan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orphan.WEB.DTO.member.OneItemDto;
import com.example.orphan.WEB.Thread.EmailCheck_TaskThread;
import com.example.orphan.WEB.Thread.FindID_TaskThread;
import com.example.orphan.WEB.Thread.Register_TaskThread;
import com.example.orphan.WEB.web.ApiInterface;
import com.example.orphan.WEB.web.web;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registerpage extends AppCompatActivity {
    String[] yearList = new String[70];
    String[] monthList = new String[12];
    String[] dayList = new String[31];


    boolean checked_emailcode = false;
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


        TextView emailpasswordCheckBox = (TextView) findViewById(R.id.button6);
        TextView emailCheckBox = (TextView) findViewById(R.id.button3);
        TextView emailcodeBox = (TextView) findViewById(R.id.button4);
        TextView email = (TextView) findViewById(R.id.editTextTextEmailAddress);
        TextView email_code = (TextView) findViewById(R.id.certmail);
        TextView password = (TextView) findViewById(R.id.passmade);
        TextView password_check = (TextView) findViewById(R.id.passmade2);
        TextView name = (TextView) findViewById(R.id.regname);
        TextView phone= (TextView) findViewById(R.id.regphone);
        TextView nick= (TextView) findViewById(R.id.regnick);
        RadioButton male = (RadioButton) findViewById(R.id.malebox);
        RadioButton female = (RadioButton) findViewById(R.id.femalebox);

        Button emailcheckbutton = (Button) findViewById(R.id.button3);
        Button codecheckbutton = (Button) findViewById(R.id.button4);
        //?????????
        //Button nickcheckbutton = (Button) findViewById(R.id.nickCheck);
        Button passcheckbutton = (Button) findViewById(R.id.button6);
        Button Registerbutton = (Button) findViewById(R.id.Register);

        //?????????


        setDay();setMonth();setYear();

        //????????? ??????
        Spinner YearSpinner = (Spinner) findViewById(R.id.spinner);
        Spinner MonthSpinner = (Spinner) findViewById(R.id.spinner2);
        Spinner DaySpinner = (Spinner) findViewById(R.id.spinner3);

        // ????????? ?????????(activity , layout , ?????? ?????? ??????) ??????
        ArrayAdapter<String> YearAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, yearList);
        ArrayAdapter<String> MonthAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, monthList);
        ArrayAdapter<String> DayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dayList);
        // ????????? ???????????? ???????????? ?????????
        YearSpinner.setAdapter(YearAdapter);
        MonthSpinner.setAdapter(MonthAdapter);
        DaySpinner.setAdapter(DayAdapter);






        // email check??? ????????? ??????
        emailcheckbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String webEmail = email.getText().toString();
                web Clinet = new web();
                ApiInterface apiService = web.getClient().create(ApiInterface.class);

                // ?????? ??????
                Call<com.example.orphan.WEB.DTO.member.OneItemDto> call = apiService.emailCheck(webEmail);
                emailCheckBox.setText("CHECKING");
                call.enqueue(new Callback<com.example.orphan.WEB.DTO.member.OneItemDto>() {
                    @Override
                    public void onResponse(Call<com.example.orphan.WEB.DTO.member.OneItemDto> call, Response<com.example.orphan.WEB.DTO.member.OneItemDto> response) {
                        try {
                            OneItemDto OneItemDto = response.body();
                            if(response.code() == 200){
                                //???????????? ??? 200
                                emailCheckBox.setText("DONE");
                                CODE = response.body().getItem();
                            }

                            else{
                                // ????????? ?????? 404
                                emailCheckBox.setText("Fail");

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
        });


        //codecheck ????????? ????????? ??????

        codecheckbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CODE ==null){
                    System.out.println("????????? ????????? ??????????????????");


                }
                else{
                    if(CODE.equals(email_code.getText().toString())){

                        checked_emailcode = true;
                        emailcodeBox.setText("DONE");
                        System.out.println("??????");
                    }
                    else{
                        emailcodeBox.setText("Fail");
                        System.out.println("?????? ??????");

                    }

                }





            }
        });

        // password check??? ????????? ??????


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
                        emailpasswordCheckBox.setText("DONE");
                        System.out.println("??? ??????????????? ???????????????. ?????? ??????????????? ???????????? ?????? Check??? ???????????????" );

                    }

                    else{
                        System.out.println("???????????? ????????? ????????????");
                        emailpasswordCheckBox.setText("Fail");

                    }

                }
                else{
                    System.out.println("??????????????? ??????????????????");
                }






            }
        });
        // nick check??? ????????? ??????


        //?????? ??????






        //????????? ???????????? ????????? ????????? ??????
        Registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //send_email - ok
                //send_pass - ok
                //send_nick - (?????? ????????????)
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
                        +"-"+mouth+"-"+day);
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
                    String output = "???????????? ???????????????";
                    System.out.println(output);
                }
                else if(!checked_emailcode) {
                    String output = "????????? ?????? ???????????????";
                    System.out.println(output);
                }
                //else if(!checked_nick) {
                //    String output = "???????????? ???????????????";

                //}

                else{
                    Register_TaskThread task = new Register_TaskThread(email.getText().toString(),send_pass,send_birth,send_name,send_phone,send_nick,send_gender);
                    task.start();
                    try {
                        task.join();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //???????????? ????????????
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