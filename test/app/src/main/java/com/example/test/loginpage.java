package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class loginpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        EditText idname = (EditText) findViewById(R.id.idname);
        EditText passname = (EditText) findViewById(R.id.passname);

        Button login = (Button) findViewById(R.id.login);
        Button regin = (Button) findViewById(R.id.regin);

        CheckBox autolog = (CheckBox) findViewById(R.id.autolog);

        TextView idfound = (TextView) findViewById(R.id.idfound);
        TextView passfound = (TextView) findViewById(R.id.passfound);



        //회원가입 페이지 클릭 이동
        regin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reginIntent = new Intent(loginpage.this, Registerpage.class);
                loginpage.this.startActivity(reginIntent);
            }
        });

        //아이디 찾기 페이지 클릭 이동
        idfound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent idfoundIntent = new Intent(loginpage.this, idforgot.class);
                loginpage.this.startActivity(idfoundIntent);
            }
        });

        //비밀번호 재설정 페이지 클릭 이동
        passfound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent passfoundIntent = new Intent(loginpage.this, passforgot.class);
                loginpage.this.startActivity(passfoundIntent);
            }
        });


        //로그인 성공시 이동
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(loginpage.this, tab.class);
                loginpage.this.startActivity(loginIntent);
            }
        });
    }
}