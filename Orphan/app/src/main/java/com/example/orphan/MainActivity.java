package com.example.orphan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    Fragment homeFragment;
    Fragment matchFragment;
    Fragment dashFragment;
    Fragment settingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new HomeFragment();
        matchFragment = new MatchFragment();
        dashFragment = new DashFragment();
        settingFragment = new SettingsFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();

        BottomNavigationView bnv = findViewById(R.id.bottom);
        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

        @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                        return true;

                    case R.id.menu_match:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, matchFragment).commit();
                        return true;

                    case R.id.menu_dash:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, dashFragment).commit();
                        return true;

                    case R.id.menu_setting:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, settingFragment).commit();
                        return true;


                }
                return false;
            }
        });




    }
}