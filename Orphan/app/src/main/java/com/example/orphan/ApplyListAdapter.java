package com.example.orphan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ApplyListAdapter extends BaseAdapter {

    private TextView applytext;
    private TextView applynow;




    private ArrayList<ApplyListItem> applyListItemsList = new ArrayList<ApplyListItem>();

    public  ApplyListAdapter(){

    }

    @Override
    public int getCount() {
        return applyListItemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return applyListItemsList.get(position);
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
            convertView = inflater.inflate(R.layout.applylist, parent, false);
        }
        TextView applytitle = (TextView) convertView.findViewById(R.id.applytitle);
        TextView applynow = (TextView) convertView.findViewById(R.id.applycate);





        ApplyListItem applyListItem = applyListItemsList.get(position);

        applytitle.setText(applyListItem.getApplytitleStr());
        applynow.setText(applyListItem.getApplynowStr());




        LinearLayout applytouch =  (LinearLayout) convertView.findViewById(R.id.applytouch);



        return convertView;

    }

    public void addItem(String applytitleStr, String applynowStr){
        ApplyListItem item = new ApplyListItem();

        item.setApplytitleStr(applytitleStr);
        item.setApplynowStr(applynowStr);



        applyListItemsList.add(item);

    }
}
