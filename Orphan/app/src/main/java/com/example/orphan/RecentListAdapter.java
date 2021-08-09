package com.example.orphan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecentListAdapter extends BaseAdapter {

    private TextView recenttext;




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




        RecentListItem recentListItem = recentListItemsList.get(position);

        recenttextTextView.setText(recentListItem.getRecenttextStr());




        LinearLayout recenttouch =  (LinearLayout) convertView.findViewById(R.id.recenttouch);



        return convertView;

    }

    public void addItem(String recenttextStr){
        RecentListItem item = new RecentListItem();

        item.setRecenttextStr(recenttextStr);



        recentListItemsList.add(item);

    }
}
