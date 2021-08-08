package com.example.orphan;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BoardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BoardFragment extends Fragment {


    private BoardListAdapter adapter;
    private ListView listView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BoardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BoardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BoardFragment newInstance(String param1, String param2) {
        BoardFragment fragment = new BoardFragment();
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
        View view = inflater.inflate(R.layout.fragment_board, container, false);

        adapter = new BoardListAdapter();

        ImageView boardpencil = (ImageView) view.findViewById(R.id.boardpencil);

        listView = (ListView) view.findViewById(R.id.boardview);
        listView.setAdapter(adapter);

        adapter.addItem("우리 열심히 하죠", "마감까지 500일 남았어요 이 씨발년들아 이제 좀 열심히 합시다 개 새끼들아", "07.23", "김민수");
        adapter.addItem("우리 열심히 하죠", "마감까지 500일 남았어요 이 씨발년들아 이제 좀 열심히 합시다 개 새끼들아", "07.23", "김민수");
        adapter.addItem("우리 열심히 하죠", "마감까지 500일 남았어요 이 씨발년들아 이제 좀 열심히 합시다 개 새끼들아", "07.23", "김민수");


        adapter.notifyDataSetChanged();

        boardpencil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(view.getContext(), BoardMake.class);
                view.getContext().startActivity(Intent);
            }
        });


        return view;
    }
}