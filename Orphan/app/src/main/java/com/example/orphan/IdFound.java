package com.example.orphan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IdFound extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_found);

        Intent inten = getIntent();

        String email = getIntent().getStringExtra("email");
        String date = getIntent().getStringExtra("date");
        String name = getIntent().getStringExtra("name");
        String birth = getIntent().getStringExtra("birth");
        String phone = getIntent().getStringExtra("phone");





        TextView Email = (TextView) findViewById(R.id.id_found_Email);
        TextView Date = (TextView) findViewById(R.id.id_found_DATE);
        Button Forgot = (Button) findViewById(R.id.Register);
        Button login = (Button) findViewById(R.id.button8);




// 초기값 설정

        Email.setText(email);
        Date.setText(date);



// 비밀번호 찾기 창으로
        Forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reginIntent = new Intent(IdFound.this, PassForgot.class);
                reginIntent.putExtra("email", email);
                reginIntent.putExtra("name",name);
                reginIntent.putExtra("birth",birth);
                reginIntent.putExtra("phone",phone);
                IdFound.this.startActivity(reginIntent);
            }
        });



// 로그인 찾기 창으로
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reginIntent = new Intent(IdFound.this, Loginpage.class);
                reginIntent.putExtra("email",email);
                IdFound.this.startActivity(reginIntent);

            }
        });








    }
}