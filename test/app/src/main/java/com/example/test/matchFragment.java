package com.example.test;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.animation.ObjectAnimator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link matchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
        /*Layout filter = (Layout) findViewById(R.id.filter);
          Button handle = (Button) findViewById(R.id.handle);*/

public class matchFragment extends Fragment {
    /*View targetView;
    Button handleButton;
    boolean handleToggle;*/

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public matchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment matchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static matchFragment newInstance(String param1, String param2) {
        matchFragment fragment = new matchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        /*
        targetView = getView().findViewById(R.id.filter);
        handleButton = getView().findViewById(R.id.handle);
        */
        /*

        class handleButtonClickListener implements View.OnClickListener{
            @Override
            public void onClick(View v){
                if(handleToggle == false){
                    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(targetView, "translationY", -1200);
                    objectAnimator.setDuration(500); //0.5초에 걸쳐 진행.
                    objectAnimator.start();
                }
                else{
                    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(targetView, "translationY", 0);
                    objectAnimator.setDuration(500); //0.5초에 걸쳐 진행.
                    objectAnimator.start();
                }
                handleToggle = !handleToggle;
            }
        }

        handleButton.setOnClickListener(new handleButtonClickListener()); */
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_match, container, false);
    }
}