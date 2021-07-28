package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class idfound extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idfound);

        Button idtopassbutton = (Button) findViewById(R.id.idtopassbutton);
        Button idtologinbutton = (Button) findViewById(R.id.idtologinbutton);

        idtopassbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent idtopassbuttonIntent = new Intent(idfound.this, passforgot.class);
                idfound.this.startActivity(idtopassbuttonIntent);
            }
        });

        idtologinbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent idtologinbuttonIntent = new Intent(idfound.this, loginpage.class);
                idfound.this.startActivity(idtologinbuttonIntent);
            }
        });
    }
}