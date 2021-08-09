package com.example.orphan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.orphan.WEB.DTO.matching.BoardRoleDto;
import com.example.orphan.WEB.DTO.matching.ReadDetailDto;
import com.example.orphan.WEB.Thread.MatchBoardDetail_TaskThread;

import org.w3c.dom.Text;

public class PostDetail extends AppCompatActivity {


    private PostListAdapter adapter;
    private ListView listView;
    private ApplyListAdapter adapter2;
    private ListView listView2;

    private ReadDetailDto dto;
    private Long boardId;


    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            //listItem.measure(0, 0);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();

        params.height = totalHeight;
        listView.setLayoutParams(params);

        listView.requestLayout();
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        boardId = getIntent().getLongExtra("boardid",0L);

        TextView backtomatch = (TextView) findViewById(R.id.backtoboard);
        LinearLayout aplicant = (LinearLayout) findViewById(R.id.aplicant);

        TextView nickname = (TextView) findViewById(R.id.textView2 );
        TextView createDate = (TextView) findViewById(R.id.textView3);
        TextView title = (TextView) findViewById(R.id.textView8);
        TextView content = (TextView) findViewById(R.id.textView9);




        aplicant.setVisibility(View.GONE);

        MatchBoardDetail_TaskThread task = new MatchBoardDetail_TaskThread(boardId);
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

        TextView a = (TextView) findViewById(R.id.textView15);
        TextView b = (TextView) findViewById(R.id.textView16);
        a.setVisibility(View.GONE);
        b.setVisibility(View.GONE);
        adapter = new PostListAdapter();



        listView = (ListView) findViewById(R.id.postview);
        listView.setAdapter(adapter);

        for (BoardRoleDto out : dto.getExpect()) {
            adapter.addItem(out.getRole(), Integer.toString(out.getEntry()), Integer.toString(out.getExpect()));
        }

        setListViewHeightBasedOnChildren(listView);
        adapter.notifyDataSetChanged();


        adapter2 = new ApplyListAdapter();



        listView2 = (ListView) findViewById(R.id.applyview);
        listView2.setAdapter(adapter2);
/*
        adapter2.addItem("김민수","프론트");
        adapter2.addItem("이융","백");
        adapter2.addItem("고성주","병신");
 */

        setListViewHeightBasedOnChildren(listView2);
        adapter2.notifyDataSetChanged();








        backtomatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



    }
}