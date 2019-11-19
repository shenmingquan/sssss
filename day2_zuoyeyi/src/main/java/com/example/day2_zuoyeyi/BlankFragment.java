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
import com.example.day2_zuoyeyi.bean.Student;
import com.example.day2_zuoyeyi.presenter.Presen;
import com.example.day2_zuoyeyi.view.Kou;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements Kou {


    private RecyclerView recy;
    private LinearLayoutManager manager;
    private ArrayList<Student.RecentBean> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentActivity activity = getActivity();
        recy = activity.findViewById(R.id.recy);
        manager = new LinearLayoutManager(getContext());
        recy.setLayoutManager(manager);
        list = new ArrayList<>();
        data();
    }

    private void data() {
        Presen presen = new Presen(this);
        presen.presen();
    }



    @Override
    public void onSuccess(Student student) {
        List<Student.RecentBean> recent = student.getRecent();
        list.addAll(recent);
        Adapter();

    }

    private void Adapter() {
        MyAdapter myAdapter = new MyAdapter(getContext(), list);
        recy.setAdapter(myAdapter);
        recy.addItemDecoration(new DividerItemDecoration(getContext(),manager.getOrientation()));
        myAdapter.setMyonClick(new MyAdapter.MyonClick() {
            @Override
            public void onClick(int position) {

            }

            @Override
            public void onlongClick(int position) {

            }
        });
        myAdapter.setMyonlongClick(new MyAdapter.MyonClick() {
            @Override
            public void onClick(int position) {

            }

            @Override
            public void onlongClick(int position) {
                final Student.RecentBean recentBean = list.get(position);
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.lay, null);
                LinearLayout ll = inflate.findViewById(R.id.ll);
                final PopupWindow popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, 300);
                popupWindow.showAsDropDown(ll);
                Button y = inflate.findViewById(R.id.yes);
                y.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Person person = new Person(recentBean.getThumbnail(),recentBean.getTitle(),(long)recentBean.getNews_id());
                        long insert = DbUitls.getInstance().insert(person);
                        if (insert>0) {
                            Toast.makeText(getContext(), "插入成功", Toast.LENGTH_SHORT).show();
                        }
                        popupWindow.dismiss();

                    }
                });
                Button n = inflate.findViewById(R.id.no);
                n.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });

            }
        });
    }

    @Override
    public void onFailre(Throwable throwable) {
        Log.i("TAG", "onFailre:"+throwable);
    };
}

