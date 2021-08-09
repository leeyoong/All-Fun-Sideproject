package com.example.orphan;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.EditText;

import com.example.orphan.WEB.DTO.dashBoard.todo.GroupToDoDto;
import com.example.orphan.WEB.DTO.mainPage.MyToDoDto;
import com.example.orphan.WEB.Thread.GroupBoard_TaskThread;
import com.example.orphan.WEB.Thread.groupToDoList_TaskThread;
import com.example.orphan.WEB.helper.EventDecorator;
import com.example.orphan.WEB.helper.Time;
import com.example.orphan.calendarColor.sundayDecorator;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScheduleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScheduleFragment extends Fragment {

    private ListView listView;
    private RecentListAdapter adapter;

    private List<GroupToDoDto> todoList;
    private List<GroupToDoDto> someDayTodoList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ScheduleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ScheduleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ScheduleFragment newInstance(String param1, String param2) {
        ScheduleFragment fragment = new ScheduleFragment();
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
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        // 추가하는 내용
        Bundle bundle = getArguments();
        Long memberid;
        Long groupid;


        if (bundle != null) {
            groupid = bundle.getLong("groupid");
            memberid = bundle.getLong("memberid");
        }
        else{
            groupid = 0L;
            memberid = 0L;
        }

        groupToDoList_TaskThread task = new groupToDoList_TaskThread(groupid, Integer.toString(CalendarDay.today().getYear()),
                Integer.toString(CalendarDay.today().getMonth() + 1));
        task.start();
        try {
            task.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        todoList = task.getDTO();

        LinearLayout scheset = (LinearLayout) view.findViewById(R.id.scheset);
        TextView scheplus = (TextView) view.findViewById(R.id.scheplus);
        Button schesign = (Button) view.findViewById(R.id.schesign);
        Button schenono = (Button) view.findViewById(R.id.schenono);


        /*
        adapter = new RecentListAdapter();
        listView = (ListView) view.findViewById(R.id.scheduleview);
        listView.setAdapter(adapter);
        setListViewHeightBasedOnChildren(listView);

        adapter.notifyDataSetChanged();
        */
        MaterialCalendarView materialCalendarView = view.findViewById(R.id.calendarView2);
        materialCalendarView.setSelectedDate(CalendarDay.today());

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
                    new EventDecorator(Color.CYAN, Collections.singleton(CalendarDay.from(helper.getYear(),helper.getMonth()-1,helper.getDay())))
            );
        }

        materialCalendarView.setOnMonthChangedListener(
                (widget, date) -> {
                    groupToDoList_TaskThread newTask = new groupToDoList_TaskThread(groupid, Integer.toString(date.getYear()),
                            Integer.toString(date.getMonth() + 1));
                    newTask.start();
                    try {
                        newTask.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    todoList = newTask.getDTO();

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
                    }



                }
        );

        materialCalendarView.setOnDateChangedListener(
                (widget, date, selected) -> {
                    GetSomedayToDoList( date.getYear(), date.getMonth()+1, date.getDay());
                    //Add_item_to_Adapter(view,someDayTodoList);

                    for (GroupToDoDto groupToDoDto : someDayTodoList) {
                        System.out.println(groupToDoDto.getTitle());
                    }

                    String Tmonth = String.format("%02d", (date.getMonth()+1));
                    String Tday = String.format("%02d", ((date.getDay())));
                    //SeletedDay.setText(Tmonth+"/"+Tday);

                }
        );




        scheset.setVisibility(View.GONE);

        scheplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scheset.setVisibility(View.VISIBLE);
            }
        });

        schesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scheset.setVisibility(View.GONE);
            }
        });

        schenono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scheset.setVisibility(View.GONE);
            }
        });



        return view;
    }

    public void Add_item_to_Adapter(View view, List<GroupToDoDto> list){ //
        adapter = new CalListAdapter();


        listView = (ListView) view.findViewById(R.id.calviewList);
        listView.setAdapter(adapter);

        for(int i = 0; i <list.size() ; i++ ){
            //adapter.addItem(list.get(i).getTitle());

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