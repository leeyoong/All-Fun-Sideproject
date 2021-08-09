package com.example.orphan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.orphan.WEB.DTO.matching.BoardRoleDto;
import com.example.orphan.WEB.DTO.matching.ReadDetailDto;
import com.example.orphan.WEB.Thread.MatchBoardDetail_TaskThread;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MatchListAdapter extends BaseAdapter {

    private TextView writer;
    private TextView matchtitle;
    private TextView writedate;
    private TextView matchtag;
    private TextView content;



    private ArrayList<MatchListItem> matchListItemsList = new ArrayList<MatchListItem>();

    public  MatchListAdapter(){

    }

    @Override
    public int getCount() {
        return matchListItemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return matchListItemsList.get(position);
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
            convertView = inflater.inflate(R.layout.matchlist, parent, false);
        }
        TextView matchtitleTextView = (TextView) convertView.findViewById(R.id.matchtitle);
        TextView matchtagTextView = (TextView) convertView.findViewById(R.id.matchtag);
        TextView wrterTextView = (TextView) convertView.findViewById(R.id.scheplus);
        TextView writedateTextView = (TextView) convertView.findViewById(R.id.writedate);
        TextView contentTextView = (TextView) convertView.findViewById(R.id.textView40);

        MatchListItem matchListItem = matchListItemsList.get(position);

        matchtitleTextView.setText(matchListItem.getMatchtitleStr());
        matchtagTextView.setText(matchListItem.getMatchtagStr());
        wrterTextView.setText(matchListItem.getWriterStr());
        writedateTextView.setText(matchListItem.getWritedateStr());
        contentTextView.setText(matchListItem.getWriterContent());

        LinearLayout matchtouch =  (LinearLayout) convertView.findViewById(R.id.matchtouch);

        matchtouch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PostDetail.class);
                intent.putExtra("boardid", matchListItem.getBoardId());
                v.getContext().startActivity(intent);
            }
        });

        return convertView;

    }

    public void addItem(String matchtitleStr, String matchtagStr, String writerStr, String writedateStr, String writeContent,
                        Long boardid){
        MatchListItem item = new MatchListItem();

        item.setMatchtitleStr(matchtitleStr);
        item.setMatchtagStr(matchtagStr);
        item.setWriterStr(writerStr);
        item.setWritedateStr(writedateStr);
        item.setWriterContent(writeContent);
        item.setBoardId(boardid);
        matchListItemsList.add(item);

    }
}
