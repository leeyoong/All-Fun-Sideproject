package com.example.orphan;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.orphan.WEB.Thread.Mytodo_TaskThread_CallBack;
import com.example.orphan.WEB.helper.EventDecorator;
import com.example.orphan.calendarColor.friDecorator;
import com.example.orphan.calendarColor.monDecorator;
import com.example.orphan.calendarColor.saturdayDecorator;
import com.example.orphan.calendarColor.sundayDecorator;
import com.example.orphan.calendarColor.thuDecorator;
import com.example.orphan.calendarColor.tueDecorator;
import com.example.orphan.calendarColor.wedDecorator;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;


public class HomeFragment extends Fragment {

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
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

        TextView Nickname = (TextView) view.findViewById(R.id.textView4);
        TextView StatusHit = (TextView) view.findViewById(R.id.textView7);
        Nickname.setText(nick);
        //StatusHit.setText();

        //System.out.println(CalendarDay.today());

        MaterialCalendarView  materialCalendarView = view.findViewById(R.id.calendarView);
        materialCalendarView.setSelectedDate(CalendarDay.today());
        materialCalendarView.addDecorators(
                new monDecorator(),
                new tueDecorator(),
                new wedDecorator(),
                new thuDecorator(),
                new friDecorator(),
                new saturdayDecorator(),
                new sundayDecorator(),
                new EventDecorator(Color.CYAN, Collections.singleton(CalendarDay.from(2021,0,15)))
        );

        materialCalendarView.setOnMonthChangedListener(
                (widget, date) -> {





                }
        );

        materialCalendarView.setOnDateChangedListener(
                (widget, date, selected) -> {
                    System.out.println("섹스합시다.");
                }
        );





/*
        Mytodo_TaskThread_CallBack Mytodo_task = Mytodo_TaskThread_CallBack(memberid,"2021","5"){

        }

 */

        Nickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




        //
        return view;

    }
}