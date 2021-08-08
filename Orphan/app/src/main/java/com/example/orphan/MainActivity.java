package com.example.orphan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    Long Memberid;
    String email;
    String password;
    String nick;
    Fragment homeFragment;
    Fragment matchFragment;
    Fragment dashFragment;
    Fragment settingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 이부분은 수정한 영역

        Intent inten = getIntent();

       Memberid = getIntent().getLongExtra("memberid",0L);
       email = getIntent().getStringExtra("email");
       nick = getIntent().getStringExtra("nick");
       password = getIntent().getStringExtra("password");


        // 이부분까지




        homeFragment = new HomeFragment();
        matchFragment = new MatchFragment();
        dashFragment = new DashFragment();
        settingFragment = new SettingsFragment();

        Bundle bundle = new Bundle(4); // 파라미터의 숫자는 전달하려는 값의 갯수
        bundle.putLong("memberid",0L);
        bundle.putString("email",email);
        bundle.putString("password",password);
        bundle.putString("nick",nick);

        homeFragment.setArguments(bundle);
        matchFragment.setArguments(bundle);
        dashFragment.setArguments(bundle);
        settingFragment.setArguments(bundle);

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