package com.example.orphan;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.orphan.WEB.DTO.mainPage.MyToDoDto;
import com.example.orphan.WEB.DTO.matching.SearchResponseDto;
import com.example.orphan.WEB.Thread.MatchBoardList_Recently_TaskThread;

import java.util.List;


public class MatchFragment extends Fragment {

    private List<SearchResponseDto> matchBoardList;

    private Spinner spinner;

    private MatchListAdapter adapter;

    private ListView listView;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MatchFragment() {
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
    public static MatchFragment newInstance(String param1, String param2) {
        MatchFragment fragment = new MatchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*Spinner spinner = (Spinner) getView().findViewById(R.id.spinner4);*/

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_match, container, false);

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

        /*
        진입 시 필터 없이 검색
         */
        MatchBoardList_Recently_TaskThread task = new MatchBoardList_Recently_TaskThread(null);
        task.start();
        try {
            task.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        matchBoardList = task.getResult();

        //
        Spinner spinner = (Spinner) view.findViewById(R.id.spinner4);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ImageView matchpencil = (ImageView) view.findViewById(R.id.matchpencil);

        Add_item_to_Adapter(view, matchBoardList);

        matchpencil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(view.getContext(), MatchMake.class);
                view.getContext().startActivity(Intent);
            }
        });




        return view;
    }

    public void Add_item_to_Adapter(View view, List<SearchResponseDto> list){
        adapter = new MatchListAdapter();
        listView = (ListView) view.findViewById(R.id.boardview);
        listView.setAdapter(adapter);

        for (SearchResponseDto dto : list) {
            String matchTag = "";
            for (String str : dto.getRole()) {
                matchTag += str;
            }
            adapter.addItem(dto.getTitle(), matchTag, dto.getWriter(), dto.getCreatedDate().substring(0,10),
                    dto.getContent(),dto.getBoardId());
        }


        adapter.notifyDataSetChanged();


    }
}