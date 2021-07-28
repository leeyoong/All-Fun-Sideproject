package com.example.test;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

public class setFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }
}