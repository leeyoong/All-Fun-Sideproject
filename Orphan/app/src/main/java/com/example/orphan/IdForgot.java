package com.example.orphan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orphan.WEB.Thread.FindID_TaskThread;

public class IdForgot extends AppCompatActivity {

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
        setContentView(R.layout.activity_id_forgot);

        //스피너 값 세팅
        setYear();setMonth();setDay();

        //각종 버튼 선언
        Button FindEmail = (Button) findViewById(R.id.Register);
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


        // 버튼 클릭시
        FindEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name = Name.getText().toString();
                String phonenumber = PhoneNumber.getText().toString();
                String year = YearSpinner.getSelectedItem().toString();
                String mouth = MonthSpinner.getSelectedItem().toString();
                String day = DaySpinner.getSelectedItem().toString();
                String birth = new String(year
                        +"-"+mouth+"-"+day);

                if(name.isEmpty()){
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
                    FindID_TaskThread task = new FindID_TaskThread(name,birth,phonenumber);
                    task.start();
                    try {
                        task.join();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //융이에게 물어볼꺼
                    if(task.getStatus()!=null){

                        Intent IdForgetIntent = new Intent(IdForgot.this, IdFound.class);
                        IdForgetIntent.putExtra("email", task.getStatus());
                        IdForgetIntent.putExtra("name",name);
                        IdForgetIntent.putExtra("birth",birth);
                        IdForgetIntent.putExtra("phone",phonenumber);
                        IdForgot.this.startActivity(IdForgetIntent);

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






}