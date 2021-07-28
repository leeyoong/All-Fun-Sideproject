package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class passforgot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passforgot);


        TextView mailforgot = (TextView) findViewById(R.id.mailforgot);

        mailforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mailforgotIntent = new Intent(passforgot.this, idforgot.class);
                passforgot.this.startActivity(mailforgotIntent);
            }
        });
    }
}