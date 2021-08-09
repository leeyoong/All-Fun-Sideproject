package com.example.orphan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DcListAdapter extends BaseAdapter {

    private TextView dctitle;




    private ArrayList<DcListItem> DcListItemsList = new ArrayList<DcListItem>();

    public  DcListAdapter(){

    }

    @Override
    public int getCount() {
        return DcListItemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return DcListItemsList.get(position);
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
            convertView = inflater.inflate(R.layout.dclist, parent, false);
        }
        TextView dctitleTextView = (TextView) convertView.findViewById(R.id.dctitle);




        DcListItem DcListItem = DcListItemsList.get(position);


        dctitleTextView.setText(DcListItem.getDctitleStr());









        return convertView;

    }

    public void addItem(String dctitleStr){
        DcListItem item = new DcListItem();

        item.setDctitleStr(dctitleStr);




        DcListItemsList.add(item);

    }
}
