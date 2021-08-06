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

<<<<<<< Updated upstream
import com.example.orphan.WEB.helper.TaskThread;
import com.example.orphan.WEB.web.web;

import java.io.IOException;
=======
import com.example.orphan.helper.TaskThread;

public class Loginpage extends AppCompatActivity {
>>>>>>> Stashed changes

public class Loginpage extends AppCompatActivity {
    private static Handler mainHandler; // 쓰레드 작업을 위한 핸들러
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
<<<<<<< Updated upstream
                // 핸들러 동작 설치

                mTestThread = new TaskThread("이융씹새야","전장의화신김민돌");

                try{
                    mTestThread.start();
                    mTestThread.join();
                 }catch (InterruptedException e) { }

                    System.out.println("로그인 실패");
                    Toast.makeText(getApplicationContext(),
                            "실패", Toast.LENGTH_LONG).show();
                    System.out.println("3분기");

=======

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
>>>>>>> Stashed changes


            }


        });
    }
}