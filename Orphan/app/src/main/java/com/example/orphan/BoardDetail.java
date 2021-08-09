package com.example.orphan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.orphan.WEB.DTO.dashBoard.groupBoard.GroupBoardDetailDto;
import com.example.orphan.WEB.Thread.GroupBoardDetail_TaskThread;

public class BoardDetail extends AppCompatActivity {
    private Long boardId;
    private Long memberId;
    private GroupBoardDetailDto dto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_detail);

        boardId = getIntent().getLongExtra("groupBoardId",0L);
        memberId = getIntent().getLongExtra("memberId",0L);

        TextView backtoboard = (TextView) findViewById(R.id.backtoboard);

        TextView nickname = (TextView) findViewById(R.id.textView2 );
        TextView createDate = (TextView) findViewById(R.id.textView3);
        TextView title = (TextView) findViewById(R.id.textView8);
        TextView content = (TextView) findViewById(R.id.textView9);

        GroupBoardDetail_TaskThread task = new GroupBoardDetail_TaskThread(boardId, memberId);
        task.start();
        try {
            task.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dto = task.getResult();

        nickname.setText(dto.getWriter());
        createDate.setText(dto.getCreatedDate().substring(0,10));
        title.setText(dto.getTitle());
        content.setText(dto.getContent());
        /*
        backtoboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

    }


}