package com.example.test;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class matchAdapter extends BaseAdapter {

    private Context context;
    private List<matchdetail> matchdetailList;

    public matchAdapter(Context context, List<matchdetail> matchdetailList) {
        this.context = context;
        this.matchdetailList = matchdetailList;
    }

    @Override
    public int getCount() {
        return matchdetailList.size();
    }

    @Override
    public Object getItem(int position) {
        return matchdetailList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.activity_matchdetail, null);
        TextView matchtitle = (TextView) v.findViewById(R.id.matchtitle);
        TextView matchname = (TextView) v.findViewById(R.id.matchname);
        TextView matchdate = (TextView) v.findViewById(R.id.matchdate);

        matchtitle.setText(matchdetailList.get(position).getMatchtitle());
        matchname.setText(matchdetailList.get(position).getMatchname());
        matchdate.setText(matchdetailList.get(position).getMatchdate());

        v.setTag(matchdetailList.get(position).getMatchtitle());
        return v;
    }




}
