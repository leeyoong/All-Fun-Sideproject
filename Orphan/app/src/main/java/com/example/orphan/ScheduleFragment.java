package com.example.orphan;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.EditText;

import com.example.orphan.WEB.DTO.dashBoard.todo.CreateToDoDto;
import com.example.orphan.WEB.DTO.dashBoard.todo.GroupToDoDto;
import com.example.orphan.WEB.DTO.mainPage.MyToDoDto;
import com.example.orphan.WEB.Thread.CreatToDo_TaskThread;
import com.example.orphan.WEB.Thread.GroupBoard_TaskThread;
import com.example.orphan.WEB.Thread.groupToDoList_TaskThread;
import com.example.orphan.WEB.helper.EventDecorator;
import com.example.orphan.WEB.helper.Time;
import com.example.orphan.calendarColor.friDecorator;
import com.example.orphan.calendarColor.monDecorator;
import com.example.orphan.calendarColor.saturdayDecorator;
import com.example.orphan.calendarColor.sundayDecorator;
import com.example.orphan.calendarColor.thuDecorator;
import com.example.orphan.calendarColor.tueDecorator;
import com.example.orphan.calendarColor.wedDecorator;
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
    private DcListAdapter adapter;
    private ListView listView;
    String[] yearList = new String[70];
    String[] monthList = new String[12];
    String[] dayList = new String[31];
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

        params.height = totalHeight/2;
        listView.setLayoutParams(params);

        listView.requestLayout();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        Spinner SYearSpinner = (Spinner) view.findViewById(R.id.spinner5);
        Spinner SMonthSpinner = (Spinner) view.findViewById(R.id.spinner6);
        Spinner SDaySpinner = (Spinner) view.findViewById(R.id.spinner7);
        Spinner EYearSpinner = (Spinner) view.findViewById(R.id.spinner8);
        Spinner EMonthSpinner = (Spinner) view.findViewById(R.id.spinner9);
        Spinner EDaySpinner = (Spinner) view.findViewById(R.id.spinner10);
        setDay();setMonth();setYear();
        // 스피너 어댑터(activity , layout , 내가 넣을 배열) 선언
        ArrayAdapter<String> YearAdapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, yearList);
        ArrayAdapter<String> MonthAdapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, monthList);
        ArrayAdapter<String> DayAdapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, dayList);
        // 스피너 어댑터를 스피너에 붙이기

        SYearSpinner.setAdapter(YearAdapter);
        SMonthSpinner.setAdapter(MonthAdapter);
        SDaySpinner.setAdapter(DayAdapter);
        EYearSpinner.setAdapter(YearAdapter);
        EMonthSpinner.setAdapter(MonthAdapter);
        EDaySpinner.setAdapter(DayAdapter);
        // 추가하는 내용
        SYearSpinner.setSelection(35);
        EYearSpinner.setSelection(35);


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

        TextView title = (TextView)view.findViewById(R.id.editTextTextPersonName3) ;

        MaterialCalendarView materialCalendarView = view.findViewById(R.id.calendarView2);
        materialCalendarView.setSelectedDate(CalendarDay.today());

        materialCalendarView.addDecorators(
                new monDecorator(),
                new tueDecorator(),
                new wedDecorator(),
                new thuDecorator(),
                new friDecorator(),
                new saturdayDecorator(),
                new sundayDecorator()

        );
       for (int i = 0; i < todoList.size(); i++) {
            Time helper = new Time();
            helper.setTime(todoList.get(i).getEndDateTime());
            materialCalendarView.addDecorator(
                    new EventDecorator(Color.parseColor("#D72323"), Collections.singleton(CalendarDay.from(helper.getYear(),helper.getMonth()-1,helper.getDay())))
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
                            new monDecorator(),
                            new tueDecorator(),
                            new wedDecorator(),
                            new thuDecorator(),
                            new friDecorator(),
                            new saturdayDecorator(),
                            new sundayDecorator()

                    );
                    for (int i = 0; i < todoList.size(); i++) {
                        Time helper = new Time();
                        helper.setTime(todoList.get(i).getEndDateTime());
                        materialCalendarView.addDecorator(
                                new EventDecorator(Color.parseColor("#D72323"),Collections.singleton(CalendarDay.from(helper.getYear(),helper.getMonth()-1,helper.getDay())))
                        );
                    }



                }
        );

        materialCalendarView.setOnDateChangedListener(
                (widget, date, selected) -> {
                    GetSomedayToDoList( date.getYear(), date.getMonth()+1, date.getDay());
                    Add_item_to_Adapter(view,someDayTodoList);

                    for (GroupToDoDto groupToDoDto : someDayTodoList) {
                        System.out.println(groupToDoDto.getTitle());
                    }

                    //String Tmonth = String.format("%02d", (date.getMonth()+1));
                    //String Tday = String.format("%02d", ((date.getDay())));
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

                String syear = SYearSpinner.getSelectedItem().toString();
                String smonth = SMonthSpinner.getSelectedItem().toString();
                if(smonth.length()==1)
                    smonth="0"+smonth;
                String sday = SDaySpinner.getSelectedItem().toString();
                if(sday.length()==1)
                    sday="0"+sday;

                String start = syear+"-"+smonth+"-"+sday+" 00:00:00";

                String eyear = EYearSpinner.getSelectedItem().toString();
                String emonth = EMonthSpinner.getSelectedItem().toString();
                if(emonth.length()==1)
                    emonth="0"+emonth;
                String eday = EDaySpinner.getSelectedItem().toString();
                if(eday.length()==1)
                    eday="0"+eday;

                String end = eyear+"-"+emonth+"-"+eday+" 00:00:00";

                CreateToDoDto req = new CreateToDoDto(start, end, title.getText().toString());
                CreatToDo_TaskThread task = new CreatToDo_TaskThread(groupid, req);
                task.start();
                try {
                    task.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                scheset.setVisibility(View.GONE);

                groupToDoList_TaskThread newTask = new groupToDoList_TaskThread(groupid, Integer.toString(CalendarDay.today().getYear()),
                        Integer.toString(CalendarDay.today().getMonth() + 1));
                newTask.start();
                try {
                    newTask.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                todoList = newTask.getDTO();

                materialCalendarView.removeDecorators();
                materialCalendarView.addDecorators(
                        new monDecorator(),
                        new tueDecorator(),
                        new wedDecorator(),
                        new thuDecorator(),
                        new friDecorator(),
                        new saturdayDecorator(),
                        new sundayDecorator()

                );
                for (int i = 0; i < todoList.size(); i++) {
                    Time helper = new Time();
                    helper.setTime(todoList.get(i).getEndDateTime());
                    materialCalendarView.addDecorator(
                            new EventDecorator(Color.parseColor("#D72323"),Collections.singleton(CalendarDay.from(helper.getYear(),helper.getMonth()-1,helper.getDay())))
                    );
                }

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
        adapter = new DcListAdapter();


        listView = (ListView) view.findViewById(R.id.scheduleview);
        listView.setAdapter(adapter);

        for (GroupToDoDto dto : list) {
            adapter.addItem(dto.getTitle());
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
    public void setYear(){
        for(int i = 0; i < yearList.length; i++){

            yearList[i] = String.valueOf(CalendarDay.today().getYear()+35 - i);
        }
    }

    public void setMonth(){
        for(int i = 0; i < monthList.length; i++){
            if(i+1 < 10){
                monthList[i] = new String("0" + Integer.toString(i+1));
            }
            else{
                monthList[i] = String.valueOf(i+1);
            }

        }
    }

    public void setDay() {
        for (int i = 0; i < dayList.length; i++) {
            if (i + 1 < 10) {
                dayList[i] = new String("0" + Integer.toString(i + 1));
            } else {
                dayList[i] = String.valueOf(i + 1);

            }
        }
    }
}