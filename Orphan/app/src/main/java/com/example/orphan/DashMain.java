package com.example.orphan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

public class DashMain extends AppCompatActivity {
    Long Memberid;
    Long Groupid;
    Fragment boardFragment;
    Fragment scheduleFragment;
    Fragment chatFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_main);
        Intent inten = getIntent();

        Memberid = getIntent().getLongExtra("memberid",0L);
        Groupid = getIntent().getLongExtra("groupid",0L);

        boardFragment = new BoardFragment();
        scheduleFragment = new ScheduleFragment();

        Bundle bundle = new Bundle(2); // 파라미터의 숫자는 전달하려는 값의 갯수
        bundle.putLong("memberid",Memberid);
        bundle.putLong("groupid",Groupid);

        boardFragment.setArguments(bundle);
        scheduleFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, scheduleFragment).commit();


        TabLayout tly = (TabLayout) findViewById(R.id.dashtab);
        tly.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();
                Fragment selected = null;
                if(pos == 0)
                    selected = scheduleFragment;
                else
                    selected = boardFragment;
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }
}