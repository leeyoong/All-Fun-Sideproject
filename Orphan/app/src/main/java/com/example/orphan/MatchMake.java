package com.example.orphan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MatchMake extends AppCompatActivity {


    private CateListAdapter adapter;
    private ListView listView;

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
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_make);

        Button cateadd = (Button) findViewById(R.id.cateadd);
        TextView backtomatch = (TextView) findViewById(R.id.backtoboard);



        adapter = new CateListAdapter();


        listView = (ListView) findViewById(R.id.cateview);
        listView.setAdapter(adapter);


        adapter.addItem("프론트","1");
        adapter.addItem("백","1");
        adapter.addItem("AI","0");



        setListViewHeightBasedOnChildren(listView);
        adapter.notifyDataSetChanged();


        backtomatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });





        cateadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder aBuilder = new AlertDialog.Builder(MatchMake.this);
                View mView = getLayoutInflater().inflate(R.layout.report_dialog,null);

                aBuilder.setTitle("상세 구인 설정");
                aBuilder.setMessage("구인을 원하는 분야를 선택하세요.");

                final Spinner sp = (Spinner)mView.findViewById(R.id.spinner);

                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(MatchMake.this, R.array.category, android.R.layout.simple_spinner_item);
                sp.setAdapter(yearAdapter);

                final EditText et = (EditText)findViewById(R.id.editT);

                aBuilder.setPositiveButton("확인", null);
                aBuilder.setNegativeButton("취소", null);



                aBuilder.setView(mView);
                AlertDialog dialog = aBuilder.create();
                dialog.show();


            }
        });
    }
}