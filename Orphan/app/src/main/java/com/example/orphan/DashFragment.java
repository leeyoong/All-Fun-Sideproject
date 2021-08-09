package com.example.orphan;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.orphan.WEB.DTO.dashBoard.group.MyGroupListDto;
import com.example.orphan.WEB.Thread.GroupBoard_TaskThread;
import com.example.orphan.WEB.Thread.getDashboard_TaskThread;

import java.util.List;

import retrofit2.Response;

public class DashFragment extends Fragment {

    private DashListAdapter adapter;
    private ListView listView;
    private List<MyGroupListDto> GroupList;

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

        getDashboard_TaskThread task = new getDashboard_TaskThread(memberid);
        task.start();
        try {
            task.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        GroupList = task.getStatus();
        Add_Dash_board(view, GroupList, memberid);



       /* adapter = new DashListAdapter();

        listView = (ListView) view.findViewById(R.id.dashview);
        listView.setAdapter(adapter);

        adapter.addItem("해커톤 ALL-FUN 사이드프로젝트", "해커톤 ALL-FUN 사이드프로젝트");
        adapter.addItem("캡스톤 Youtube Add-on", "캡스톤 Youtube Add-on");
        adapter.addItem("자연어 처리를 통한 주문처리", "자연어 처리를 통한 주문처리");


        adapter.notifyDataSetChanged();
*/
        return view;
    }


    public void Add_Dash_board(View view, List<MyGroupListDto> list, Long memberid){
        adapter = new DashListAdapter();

        listView = (ListView) view.findViewById(R.id.dashview);
        listView.setAdapter(adapter);

        for (MyGroupListDto myGroupListDto : list) {
            adapter.addItem(myGroupListDto.getTitle(), myGroupListDto.getTitle(), myGroupListDto.getGroupId(), memberid);
        }

        adapter.notifyDataSetChanged();


    }
}