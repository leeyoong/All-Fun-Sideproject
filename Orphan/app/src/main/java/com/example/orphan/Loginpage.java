package com.example.orphan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.orphan.WEB.web.web;

import java.io.IOException;

public class Loginpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);


        Button regin = (Button) findViewById(R.id.regin);
        Button login = (Button) findViewById(R.id.login);

        regin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reginIntent = new Intent(Loginpage.this, Registerpage.class);
                Loginpage.this.startActivity(reginIntent);
            }
        });


        //login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                web base = new  web();
                String check = new String();
                check = base.Post_Login_Sync("hasdfai","hiasdfasfd");
                if(check.equals("ok")){
                    Toast.makeText(getApplicationContext(),
                            "굿", Toast.LENGTH_LONG).show();

                    System.out.println("3분기");
                    System.out.println("3분기");
                    System.out.println("3분기");
                    System.out.println("3분기");
                    System.out.println("3분기");
                    System.out.println("3분기");
                    Intent loginIntent = new Intent(Loginpage.this, MainActivity.class);
                    Loginpage.this.startActivity(loginIntent);

                }
                else{
                    System.out.println("로그인 실패");
                    Toast.makeText(getApplicationContext(),
                            "실패", Toast.LENGTH_LONG).show();
                    System.out.println("3분기");
                    System.out.println("3분기");
                    System.out.println("3분기");
                    System.out.println("3분기");
                    System.out.println("3분기");



                }


            }


        });
    }
}