package com.example.orphan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.orphan.WEB.helper.TaskThread;

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

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TaskThread task = new TaskThread("id","pass");
                task.start();
                try {
                    task.join();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(task.getStatus()){
                    Intent loginIntent = new Intent(Loginpage.this, MainActivity.class);
                    Loginpage.this.startActivity(loginIntent);

                }
                else{
                    System.out.println("연결안됨");
                }



            }
        });
    }
}