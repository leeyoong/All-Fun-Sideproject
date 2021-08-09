package com.example.orphan;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class DashFragment extends Fragment {

    private DashListAdapter adapter;
    private ListView listView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DashFragment() {
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
    public static DashFragment newInstance(String param1, String param2) {
        DashFragment fragment = new DashFragment();
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
        View view = inflater.inflate(R.layout.fragment_dash, container, false);


        TextView newproject = (TextView) view.findViewById(R.id.newproject);

        adapter = new DashListAdapter();

        listView = (ListView) view.findViewById(R.id.dashview);
        listView.setAdapter(adapter);

        adapter.addItem("해커톤 ALL-FUN 사이드프로젝트", "해커톤 ALL-FUN 사이드프로젝트");
        adapter.addItem("캡스톤 Youtube Add-on", "캡스톤 Youtube Add-on");
        adapter.addItem("자연어 처리를 통한 주문처리", "자연어 처리를 통한 주문처리");


        adapter.notifyDataSetChanged();


        newproject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder aBuilder = new AlertDialog.Builder(view.getContext());


                aBuilder.setTitle("새 프로젝트 생성");
                aBuilder.setMessage("새 프로젝트의 이름을 설정해주세요.");

                final EditText et = new EditText(view.getContext());
                aBuilder.setView(et);



                aBuilder.setPositiveButton("확인", null);
                aBuilder.setNegativeButton("취소", null);



                AlertDialog dialog = aBuilder.create();
                dialog.show();


            }
        });

        return view;
    }
}