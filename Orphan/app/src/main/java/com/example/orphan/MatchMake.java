package com.example.orphan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MatchMake extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_make);

        Button cateadd = (Button) findViewById(R.id.cateadd);

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