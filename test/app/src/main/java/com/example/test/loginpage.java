package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.DTO.Member.MemberDataDto;
import com.example.test.WEB.web;
import com.example.test.helper.Image;

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
                web base = new web();
                Intent passfoundIntent = new Intent(loginpage.this, passforgot.class);
                MemberDataDto output=
                base.Post_Login_Sync(idname.getText().toString(),passname.getText().toString());

                if(output!=null){
                    loginpage.this.startActivity(passfoundIntent);

                }
                else{
                    System.out.println("안되네..");
                }




            }
        });
    }
    private final int PICK_IMAGE = 111;
    public void pickFromGallery(){

        Intent intent=new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        String[] mimeTypes = {"image/jpeg", "image/png"};
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(Intent.EXTRA_MIME_TYPES,mimeTypes);

        startActivityForResult(intent,PICK_IMAGE);

    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            if (data == null) {
                return;
            }
            Uri selectedImage = data.getData();
            System.out.println(selectedImage);
        }
    }
}