package com.example.orphan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.orphan.WEB.DTO.member.MemberLoginDto;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    Fragment homeFragment;
    Fragment matchFragment;
    Fragment dashFragment;
    Fragment settingFragment;
    public static String nick;
    private static Long  memberid;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            // 로그인에서 받아온 값  /////////////////////

        Intent inten = getIntent();

        String email = getIntent().getStringExtra("email");
        String birth = getIntent().getStringExtra("password");
        memberid  = getIntent().getLongExtra("memberid" , 0);
        String nick = getIntent().getStringExtra("nick");;



        /// 로그인에서 받아온값 ///////////////////////









        homeFragment = new HomeFragment();
        matchFragment = new MatchFragment();
        dashFragment = new DashFragment();
        settingFragment = new SettingsFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();

        BottomNavigationView bnv = findViewById(R.id.bottom);
        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

        @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();
                        return true;

                    case R.id.menu_match:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, matchFragment).commit();
                        return true;

                    case R.id.menu_dash:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, dashFragment).commit();
                        return true;

                    case R.id.menu_setting:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, settingFragment).commit();
                        return true;


                }
                return false;
            }
        });




    }
}