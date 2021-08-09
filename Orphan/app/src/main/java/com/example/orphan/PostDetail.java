package com.example.orphan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class PostDetail extends AppCompatActivity {


    private PostListAdapter adapter;
    private ListView listView;
    private ApplyListAdapter adapter2;
    private ListView listView2;



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

        TextView backtomatch = (TextView) findViewById(R.id.backtomatch);
        LinearLayout aplicant = (LinearLayout) findViewById(R.id.aplicant);

        aplicant.setVisibility(View.VISIBLE);

        adapter = new PostListAdapter();



        listView = (ListView) findViewById(R.id.postview);
        listView.setAdapter(adapter);


        adapter.addItem("프론트","1","2");
        adapter.addItem("백","1","1");
        adapter.addItem("AI","0","1");



        setListViewHeightBasedOnChildren(listView);
        adapter.notifyDataSetChanged();


        adapter2 = new ApplyListAdapter();



        listView2 = (ListView) findViewById(R.id.applyview);
        listView2.setAdapter(adapter2);


        adapter2.addItem("김민수","프론트");
        adapter2.addItem("이융","백");
        adapter2.addItem("고성주","병신");



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