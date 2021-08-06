package com.example.orphan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.orphan.WEB.helper.TaskThread;
import java.io.IOException;


public class Loginpage extends AppCompatActivity {
    private Thread mTestThread;
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

                // 핸들러 동작 설치



                TaskThread thread = new TaskThread("hi","asdfasd");
                thread.start();
                try {
                    thread.join();
                    System.out.println(thread.Result());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent loginIntent = new Intent(Loginpage.this, MainActivity.class);
                Loginpage.this.startActivity(loginIntent);



            }


        });
    }
}