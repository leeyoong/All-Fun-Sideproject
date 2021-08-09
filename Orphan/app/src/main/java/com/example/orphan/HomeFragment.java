package com.example.orphan;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.orphan.WEB.DTO.mainPage.MyGroupBoardDto;
import com.example.orphan.WEB.DTO.mainPage.MyToDoDto;
import com.example.orphan.WEB.Thread.GroupBoard_TaskThread;
import com.example.orphan.WEB.Thread.Mytodo_TaskThread;
import com.example.orphan.WEB.Thread.groupBoardNoHit_TaskThread;
import com.example.orphan.WEB.helper.EventDecorator;
import com.example.orphan.WEB.helper.Time;
import com.example.orphan.calendarColor.sundayDecorator;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;


public class HomeFragment extends Fragment {

    private CalListAdapter adapter;
    private ListView listView;
    private RecentListAdapter adapter2;
    private ListView listView2;
    private List<MyToDoDto> todoList;
    private List<MyToDoDto> someDayTodoList;
    private List<MyGroupBoardDto> GroupBoardList;
    private int nohit;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    public void REQUEST_GroupBoard(Long memberid){
        GroupBoard_TaskThread task = new GroupBoard_TaskThread(memberid);
        task.start();
        try {
            task.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        GroupBoardList = task.getDTO();

    }
    public void REQUEST_Mytodo(Long memberid, String year , String month){
        Mytodo_TaskThread task = new Mytodo_TaskThread(memberid, year, month);
        task.start();
        try {
            task.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        todoList =  task.getDTO();


    }
    public void REQUEST_NoHit(Long memberid){
        groupBoardNoHit_TaskThread task = new groupBoardNoHit_TaskThread(memberid);
        task.start();
        try {
            task.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nohit=  task.getNoHit();

    }



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            //listItem.measure(0, 0);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();

        params.height = totalHeight;
        listView.setLayoutParams(params);

        listView.requestLayout();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // 여기가 이벤트 시작좀
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // 추가하는 내용
        Bundle bundle = getArguments();
        String email;
        String password;
        String nick;
        Long memberid;


        if (bundle != null) {
            email = bundle.getString("email");
            password = bundle.getString("password");
            nick = bundle.getString("nick");
            memberid = bundle.getLong("memberid");
        }
        else{
            email = null;
            password = null;
            nick = null;
            memberid = 0L;
        }
        System.out.println(memberid);

        TextView Nickname = (TextView) view.findViewById(R.id.textView4);
        Button mypagebt = (Button) view.findViewById(R.id.mypagebt);
        TextView StatusHit = (TextView) view.findViewById(R.id.textView7);
        TextView SeletedDay = (TextView) view.findViewById(R.id.calendarViewDay);//?월 ?일 양식
        Nickname.setText(nick);
        //StatusHit.setText();


        mypagebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent Intent = new Intent(view.getContext(), MyPage.class);
                view.getContext().startActivity(Intent);



            }
        });




        /*
        REQUEST_GroupBoard(memberid);
        REQUEST_Mytodo(memberid,Integer.toString(CalendarDay.today().getYear()),Integer.toString(CalendarDay.today().getMonth()+1));
        REQUEST_NoHit(memberid);

         */

        //StatusHit.setText(Integer.toString(nohit));
        //System.out.println("NONONONONONO : " + nohit);
        //System.out.println(todoList.get(0).getStartDateTime());
        //System.out.println(CalendarDay.today());

        MaterialCalendarView materialCalendarView = view.findViewById(R.id.calendarView);
        materialCalendarView.setSelectedDate(CalendarDay.today());

        materialCalendarView.addDecorators(
                //new monDecorator(),
                //new tueDecorator(),
                //new wedDecorator(),
                //new thuDecorator(),
                //new friDecorator(),
                //new saturdayDecorator(),
                new sundayDecorator()

        );/*
        for (int i = 0; i < todoList.size(); i++) {
            Time helper = new Time();
            helper.setTime(todoList.get(i).getEndDateTime());
            materialCalendarView.addDecorator(
                    new EventDecorator(Color.CYAN,Collections.singleton(CalendarDay.from(helper.getYear(),helper.getMonth()-1,helper.getDay())))
            );
        }*/

        materialCalendarView.setOnMonthChangedListener(
                (widget, date) -> {
                    /*REQUEST_Mytodo(memberid,Integer.toString(date.getYear()),Integer.toString(date.getMonth()+1));
                    materialCalendarView.removeDecorators();
                    materialCalendarView.addDecorators(
                            //new monDecorator(),
                            //new tueDecorator(),
                            //new wedDecorator(),
                            //new thuDecorator(),
                            //new friDecorator(),
                            //new saturdayDecorator(),
                            new sundayDecorator()

                    );
                    for (int i = 0; i < todoList.size(); i++) {
                        Time helper = new Time();
                        helper.setTime(todoList.get(i).getEndDateTime());
                        materialCalendarView.addDecorator(
                                new EventDecorator(Color.CYAN,Collections.singleton(CalendarDay.from(helper.getYear(),helper.getMonth()-1,helper.getDay())))
                        );
                    }*/



                }
        );

        materialCalendarView.setOnDateChangedListener(
                (widget, date, selected) -> {
                    GetSomedayToDoList( date.getYear(), date.getMonth()+1, date.getDay());
                    Add_item_to_Adapter(view,someDayTodoList);

                    String Tmonth = String.format("%02d", (date.getMonth()+1));
                    String Tday = String.format("%02d", ((date.getDay())));
                    SeletedDay.setText(Tmonth+"/"+Tday);

                }
        );





/*

        Mytodo_TaskThread_CallBack Mytodo_task = Mytodo_TaskThread_CallBack(memberid,"2021","5"){

        }

 */


        adapter2 = new RecentListAdapter();


        listView2 = (ListView) view.findViewById(R.id.recentlist);
        listView2.setAdapter(adapter2);

        adapter2.addItem("2021 제 1회 해커톤 All Fun 사이드프로젝트");
        adapter2.addItem("2021 제 1회 해커톤 All Fun 사이드프로젝트");
        adapter2.addItem("2021 제 1회 해커톤 All Fun 사이드프로젝트");

        setListViewHeightBasedOnChildren(listView2);
        adapter2.notifyDataSetChanged();

        return view;

    }

    public void Add_item_to_Adapter(View view, List<MyToDoDto> list){ //
        adapter = new CalListAdapter();


        listView = (ListView) view.findViewById(R.id.calviewList);
        listView.setAdapter(adapter);

        for(int i = 0; i <list.size() ; i++ ){
            adapter.addItem(list.get(i).getGroupName() ,list.get(i).getTitle());

        }

        setListViewHeightBasedOnChildren(listView);
        adapter.notifyDataSetChanged();



    }

    public void GetSomedayToDoList(int year,int month, int day){
        someDayTodoList = new ArrayList<>();
        Time helper = new Time();


        for(int i = 0 ; i < todoList.size(); i++){
            if(todoList.get(i) != null){
                String listtime = todoList.get(i).getEndDateTime();
                if(helper.isEqual(listtime,year,month,day)){
                    someDayTodoList.add(todoList.get(i));
                }
            }
        }






    }



}