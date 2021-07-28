package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class idforgot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idforgot);


        EditText forgotname = (EditText) findViewById(R.id.forgotname);
        EditText forgotbirth = (EditText) findViewById(R.id.forgotbirth);
        EditText forgotphone = (EditText) findViewById(R.id.forgotphone);

        Button forgotbutton = (Button) findViewById(R.id.forgotbutton);

        forgotbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forgotbuttonIntent = new Intent(idforgot.this, idfound.class);
                idforgot.this.startActivity(forgotbuttonIntent);
            }
        });
    }
}