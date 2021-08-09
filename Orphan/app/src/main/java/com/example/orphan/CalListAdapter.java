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

public class CalListAdapter extends BaseAdapter {

    private TextView caltext;
    private TextView caltitle;


    private ArrayList<CalListItem> calListItemsList = new ArrayList<CalListItem>();

    public  CalListAdapter(){

    }

    @Override
    public int getCount() {
        return calListItemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return calListItemsList.get(position);
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
            convertView = inflater.inflate(R.layout.calist, parent, false);
        }
        TextView caltitleTextView = (TextView) convertView.findViewById(R.id.caltitle);
        TextView caltextTextView = (TextView) convertView.findViewById(R.id.caltext);




        CalListItem calListItem = calListItemsList.get(position);

        caltextTextView.setText(calListItem.getCaltextStr());
        caltitleTextView.setText(calListItem.getCaltitleStr());



        LinearLayout caltouch =  (LinearLayout) convertView.findViewById(R.id.caltouch);



        return convertView;

    }

    public void addItem(String caltitleStr, String caltextStr){
        CalListItem item = new CalListItem();

        item.setCaltitleStr(caltitleStr);
        item.setCaltextStr(caltextStr);


        calListItemsList.add(item);

    }
}
