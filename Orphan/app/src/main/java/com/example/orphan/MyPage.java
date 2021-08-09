package com.example.orphan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.orphan.WEB.DTO.member.MyInfoDto;
import com.example.orphan.WEB.Thread.MyPageDetail_TaskThread;

import org.w3c.dom.Text;

public class MyPage extends AppCompatActivity {
    private Long memberId;
    private MyInfoDto dto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);
        memberId = getIntent().getLongExtra("memberId",0L);

        TextView backtohome = (TextView) findViewById(R.id.backtoboard);

        TextView nickname = (TextView) findViewById(R.id.textView2);
        TextView realName = (TextView) findViewById(R.id.textView28);
        TextView sex = (TextView) findViewById(R.id.textView26);
        TextView phone = (TextView) findViewById(R.id.textView27);
        TextView message = (TextView) findViewById(R.id.textView31);
        TextView groups = (TextView) findViewById(R.id.textView36);
        TextView boards = (TextView) findViewById(R.id.textView35);

        MyPageDetail_TaskThread task = new MyPageDetail_TaskThread(memberId);
        task.start();
        try {
            task.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        dto = task.getResult();

        nickname.setText(dto.getNickname());
        realName.setText(dto.getName());
        sex.setText(dto.getGender());
        phone.setText(dto.getPhone());
        message.setText(dto.getIntroduce());
        groups.setText(Integer.toString(dto.getMyGroups()));
        boards.setText(Integer.toString(dto.getMyEntryPool()));

        backtohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }
}