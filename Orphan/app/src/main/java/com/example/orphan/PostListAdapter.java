package com.example.orphan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class PostListAdapter extends BaseAdapter {

    private TextView posttext;
    private TextView postnow;
    private TextView postmax;



    private ArrayList<PostListItem> postListItemsList = new ArrayList<PostListItem>();

    public  PostListAdapter(){

    }

    @Override
    public int getCount() {
        return postListItemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return postListItemsList.get(position);
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
            convertView = inflater.inflate(R.layout.postlist, parent, false);
        }
        TextView posttitle = (TextView) convertView.findViewById(R.id.posttitle);
        TextView postnow = (TextView) convertView.findViewById(R.id.postnow);
        TextView postmax = (TextView) convertView.findViewById(R.id.postmax);


        PostListItem postListItem = postListItemsList.get(position);

        posttitle.setText(postListItem.getPosttitleStr());
        postnow.setText(postListItem.getPostnowStr());
        postmax.setText(postListItem.getPostmaxStr());



        LinearLayout posttouch =  (LinearLayout) convertView.findViewById(R.id.posttouch);



        return convertView;

    }

    public void addItem(String posttitleStr, String postnowStr, String postmaxStr){

        PostListItem item = new PostListItem();

        item.setPosttitleStr(posttitleStr);
        item.setPostnowStr(postnowStr);
        item.setPostmaxStr(postmaxStr);

        postListItemsList.add(item);

    }
}
