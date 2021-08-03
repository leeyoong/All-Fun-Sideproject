package com.example.orphan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
                Intent loginIntent = new Intent(Loginpage.this, MainActivity.class);
                Loginpage.this.startActivity(loginIntent);
            }
        });
    }
}