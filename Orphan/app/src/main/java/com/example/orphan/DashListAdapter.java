package com.example.orphan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

public class DashListAdapter extends BaseAdapter {

    private TextView dashtitle;
    private TextView dashtitle2;
    private Long memberid;
/* private ImageView dashfix;
    private ImageView dashalarm;
    private ImageView dashass; */


    private ArrayList<DashListItem> dashListItemsList = new ArrayList<DashListItem>();

    public  DashListAdapter() {

    }

    @Override
    public int getCount() {
        return dashListItemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return dashListItemsList.get(position);
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
            convertView = inflater.inflate(R.layout.dashlist, parent, false);
        }
        TextView dashtitleTextView = (TextView) convertView.findViewById(R.id.dashtitle);
        TextView dashtitle2TextView = (TextView) convertView.findViewById(R.id.dashtitle2);
   /*     ImageView dashfixImageView = (ImageView) convertView.findViewById(R.id.dashfix);
        ImageView dashalarmImageView = (ImageView) convertView.findViewById(R.id.dashalarm);
        ImageView dashassImageView = (ImageView) convertView.findViewById(R.id.dashass); */

        DashListItem dashListItem = dashListItemsList.get(position);

        dashtitleTextView.setText(dashListItem.getDashtitleStr());
        dashtitle2TextView.setText(dashListItem.getDashtitle2Str());
   /*     dashfixImageView.setImageResource(dashListItem.getDashalarmDrawable());
        dashassImageView.setImageResource(dashListItem.getDashassDrawable());
        dashalarmImageView.setImageResource(dashListItem.getDashalarmDrawable()); */


        LinearLayout dashtouch =  (LinearLayout) convertView.findViewById(R.id.dashtouch);

        dashtouch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DashMain.class);

                System.out.println(dashListItem.getMemberId());

                intent.putExtra("memberid" , dashListItem.getMemberId() );
                intent.putExtra( "groupid", dashListItem.getGroupId()  );

                v.getContext().startActivity(intent);
            }
        });

        return convertView;

    }

    public void addItem(String dashtitleStr, String dashtitle2Str, Long groupId, Long memberId/*, int dashfixDrawable, int dashalarmDrawable, int dashassDrawable*/){
        DashListItem item = new DashListItem();

        item.setDashtitleStr(dashtitleStr);
        item.setDashtitle2Str(dashtitle2Str);

        item.setGroupId(groupId);
        item.setMemberId(memberId);

        dashListItemsList.add(item);

    }
}
