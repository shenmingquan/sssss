package com.example.day2_zuoyeyi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.day2_zuoyeyi.R;
import com.example.day2_zuoyeyi.bean.Student;


import java.util.ArrayList;

/**
 * Created by lenovo on 2019/11/19.
 */

public class MyAdapter extends RecyclerView.Adapter{
    private final Context context;
    public final ArrayList<Student.RecentBean> list;

    public MyAdapter(Context context, ArrayList<Student.RecentBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout, parent, false);
        return new Myviewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        Myviewholder myviewholder= (Myviewholder) holder;
        Student.RecentBean recentBean = list.get(position);
        myviewholder.id.setText(recentBean.getNews_id()+"");
        myviewholder.title.setText(recentBean.getTitle());
        Glide.with(context).load(recentBean.getThumbnail()).into(myviewholder.iv);
        myviewholder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                myonlongClick.onlongClick(position);
                return false;
            }
        });
        myviewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myonClick.onClick(position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    class Myviewholder extends RecyclerView.ViewHolder{

        private final ImageView iv;
        private final TextView id;
        private final TextView title;

        public Myviewholder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.Sird_iv);
            id = itemView.findViewById(R.id.new_id);
            title = itemView.findViewById(R.id.titles);
        }
    }
    public interface MyonClick{
        void onClick(int position);
        void onlongClick(int position);
    }
    private MyonClick myonClick;
    private MyonClick myonlongClick;

    public void setMyonClick(MyonClick myonClick) {
        this.myonClick = myonClick;
    }

    public void setMyonlongClick(MyonClick myonlongClick) {
        this.myonlongClick = myonlongClick;
    }
}
