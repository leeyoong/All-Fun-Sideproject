package com.example.orphan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CateListAdapter extends BaseAdapter {

    private TextView catetext;
    private TextView catenow;
    private TextView catemax;



    private ArrayList<CateListItem> cateListItemsList = new ArrayList<CateListItem>();

    public  CateListAdapter(){

    }

    @Override
    public int getCount() {
        return cateListItemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return cateListItemsList.get(position);
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
            convertView = inflater.inflate(R.layout.catelist, parent, false);
        }
        TextView catetitleTextView = (TextView) convertView.findViewById(R.id.catetitle);
        TextView catenowTextView = (TextView) convertView.findViewById(R.id.catenow);
        TextView catemaxTextView = (TextView) convertView.findViewById(R.id.catemax);




        CateListItem cateListItem = cateListItemsList.get(position);

        catetitleTextView.setText(cateListItem.getCatetitleStr());
        catenowTextView.setText(cateListItem.getCatenowStr());
        catemaxTextView.setText(cateListItem.getCatemaxStr());



        LinearLayout catetouch =  (LinearLayout) convertView.findViewById(R.id.posttouch);



        return convertView;

    }

    public void addItem(String catetitleStr, String catenowStr, String catemaxStr){
        CateListItem item = new CateListItem();

        item.setCatetitleStr(catetitleStr);
        item.setCatenowStr(catenowStr);
        item.setCatemaxStr(catemaxStr);


        cateListItemsList.add(item);

    }
}
