package com.example.day2_zuoyeyi;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.day2_zuoyeyi.adapter.MyAdapter;
import com.example.day2_zuoyeyi.adapter.MyrecyAdapter;
import com.example.day2_zuoyeyi.bean.Student;
import com.example.day2_zuoyeyi.presenter.Presen;
import com.example.day2_zuoyeyi.view.Kou;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment{


    private RecyclerView recy;
    private LinearLayoutManager manager;
    private MyrecyAdapter myrecyAdapter;
    private List<Person> list1;

    public BlankFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentActivity activity = getActivity();
        recy = activity.findViewById(R.id.rert);
        manager = new LinearLayoutManager(getContext());
        recy.setLayoutManager(manager);
        list1 = new ArrayList<>();
        myrecyAdapter = new MyrecyAdapter(getContext(), list1);
        recy.setAdapter(myrecyAdapter);
    }

    public void we() {
        myrecyAdapter.list.clear();
        List<Person> people = DbUitls.getInstance().loadAll();
        list1.addAll(people);
        myrecyAdapter.notifyDataSetChanged();
    }
}

