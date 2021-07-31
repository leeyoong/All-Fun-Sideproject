package com.example.test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class Registerpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage);

        EditText regpw = (EditText) findViewById(R.id.regpw);
        EditText regname = (EditText) findViewById(R.id.regname);
        EditText regbirth = (EditText) findViewById(R.id.regbirth);
        EditText regphone = (EditText) findViewById(R.id.regphone);
        EditText regmail = (EditText) findViewById(R.id.regmail);
        EditText regnick = (EditText) findViewById(R.id.regnick);

        Button regnickbutton = (Button) findViewById(R.id.regnickbutton);
        Button regmailbutton = (Button) findViewById(R.id.regmailbutton);
        Button regmailbutton2 = (Button) findViewById(R.id.regmailbutton2);
        Button regfinish = (Button) findViewById(R.id.regfinish);

        RadioButton malebox = (RadioButton) findViewById(R.id.malebox);
        RadioButton femalebox = (RadioButton) findViewById(R.id.femalebox);


        //회원가입 완료
        regfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ad = new AlertDialog.Builder(Registerpage.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle("");
                ad.setMessage("회원가입이 완료되었습니다.");

                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent regfinishIntent = new Intent(Registerpage.this, loginpage.class);
                        Registerpage.this.startActivity(regfinishIntent);
                    }
                });

                ad.show();

            }
        });

        //이메일 충복체크 버튼
        regmailbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ad = new AlertDialog.Builder(Registerpage.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle("");
                ad.setMessage("사용 가능한 메일입니다.");

                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                ad.show();

            }
        });

        //메일 인증번호 승인 여부
       regmailbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ad = new AlertDialog.Builder(Registerpage.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle("");
                ad.setMessage("인증 완료되었습니다..");

                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                ad.show();

            }
        });

        //닉네임 중복체크
        regnickbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ad = new AlertDialog.Builder(Registerpage.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle("");
                ad.setMessage("사용 가능한 닉네임입니다.");

                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                ad.show();

            }
        });




    }
}