package com.example.orphan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MatchListAdapter extends BaseAdapter {

    private TextView writer;
    private TextView matchtitle;
    private TextView writedate;
    private TextView matchtag;

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
        TextView wrterTextView = (TextView) convertView.findViewById(R.id.writer);
        TextView writedateTextView = (TextView) convertView.findViewById(R.id.writedate);

        MatchListItem matchListItem = matchListItemsList.get(position);

        matchtitleTextView.setText(matchListItem.getMatchtitleStr());
        matchtagTextView.setText(matchListItem.getMatchtagStr());
        wrterTextView.setText(matchListItem.getWriterStr());
        writedateTextView.setText(matchListItem.getWritedateStr());

        return convertView;

    }

    public void addItem(String matchtitleStr, String matchtagStr, String writerStr, String writedateStr){
        MatchListItem item = new MatchListItem();

        item.setMatchtitleStr(matchtitleStr);
        item.setMatchtagStr(matchtagStr);
        item.setWriterStr(writerStr);
        item.setWritedateStr(writedateStr);

        matchListItemsList.add(item);

    }
}
