package com.example.orphan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orphan.WEB.Thread.Login_TaskThread;

public class Loginpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        TextView idname = (TextView) findViewById(R.id.idname);
        TextView passname = (TextView) findViewById(R.id.passname);

        TextView idfound = (TextView) findViewById(R.id.idfound);
        TextView passfound = (TextView) findViewById(R.id.passfound);
        Button regin = (Button) findViewById(R.id.regin);
        Button login = (Button) findViewById(R.id.login);


        //id 찾기 창

        idfound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reginIntent = new Intent(Loginpage.this, IdForgot.class);
                Loginpage.this.startActivity(reginIntent);

            }
        });
        // pass 찾기 창
        passfound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reginIntent = new Intent(Loginpage.this, PassForgot.class);
                Loginpage.this.startActivity(reginIntent);

            }
        });




        //회원가입 창
        regin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reginIntent = new Intent(Loginpage.this, Registerpage.class);
                Loginpage.this.startActivity(reginIntent);
            }
        });



        //로그인 버튼 눌렀을시
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





                    Intent loginIntent = new Intent(Loginpage.this, MainActivity.class);


                    Loginpage.this.startActivity(loginIntent);






            }
        });
    }
}