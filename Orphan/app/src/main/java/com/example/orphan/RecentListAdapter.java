package com.example.orphan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecentListAdapter extends BaseAdapter {

    private TextView recenttext;
    private TextView recenttodo;

    private ArrayList<RecentListItem> recentListItemsList = new ArrayList<RecentListItem>();

    public  RecentListAdapter(){

    }

    @Override
    public int getCount() {
        return recentListItemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return recentListItemsList.get(position);
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
            convertView = inflater.inflate(R.layout.recentlist, parent, false);
        }

        TextView recenttextTextView = (TextView) convertView.findViewById(R.id.recenttext);
        TextView recenttodoTextView = (TextView) convertView.findViewById(R.id.recenttodo);

        RecentListItem recentListItem = recentListItemsList.get(position);

        recenttextTextView.setText(recentListItem.getRecenttextStr());
        recenttodoTextView.setText(recentListItem.getRecenttodoStr());

        LinearLayout recenttouch =  (LinearLayout) convertView.findViewById(R.id.recenttouch);

        recenttouch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), recentListItemsList.get(pos).getRecenttextStr(), Toast.LENGTH_SHORT).show();

            }
        });


        return convertView;

    }

    public void addItem(String recenttextStr, String recenttodoStr){
        RecentListItem item = new RecentListItem();

        item.setRecenttextStr(recenttextStr);
        item.setRecenttodoStr(recenttodoStr);

        recentListItemsList.add(item);

    }
}
