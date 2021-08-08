package com.example.orphan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BoardListAdapter extends BaseAdapter {

    private TextView boardtext;
    private TextView boardtitle;
    private TextView boardwriter;
    private TextView boarddate;


    private ArrayList<BoardListItem> boardListItemsList = new ArrayList<BoardListItem>();

    public  BoardListAdapter(){

    }

    @Override
    public int getCount() {
        return boardListItemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return boardListItemsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.boardlist, parent, false);
        }
        TextView boardtitleTextView = (TextView) convertView.findViewById(R.id.boardtitle);
        TextView boardtextTextView = (TextView) convertView.findViewById(R.id.boardtext);
        TextView boardwriterTextView = (TextView) convertView.findViewById(R.id.boardwriter);
        TextView boarddateTextView = (TextView) convertView.findViewById(R.id.boarddate);



        BoardListItem boardListItem = boardListItemsList.get(position);

        boardtextTextView.setText(boardListItem.getBoardtextStr());
        boardtitleTextView.setText(boardListItem.getBoardtitleStr());
        boarddateTextView.setText(boardListItem.getBoarddateStr());
        boarddateTextView.setText(boardListItem.getBoardwriterStr());



        LinearLayout boardtouch =  (LinearLayout) convertView.findViewById(R.id.boardtouch);

        boardtouch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DashMain.class);
                v.getContext().startActivity(intent);
            }
        });

        return convertView;

    }

    public void addItem(String boardtitleStr, String boardtextStr, String boarddateStr, String boardwriterStr/*, int dashfixDrawable, int dashalarmDrawable, int dashassDrawable*/){
        BoardListItem item = new BoardListItem();

        item.setBoardtitleStr(boardtitleStr);
        item.setBoardtextStr(boardtextStr);
        item.setBoarddateStr(boarddateStr);
        item.setBoardwriterStr(boardwriterStr);
        /*item.setDashalarmDrawable(dashalarmDrawable);
        item.setDashfixDrawable(dashfixDrawable);
        item.setDashassDrawable(dashassDrawable);*/

        boardListItemsList.add(item);

    }
}
