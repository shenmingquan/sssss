package com.example.day2_zuoyeyi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.day2_zuoyeyi.Person;
import com.example.day2_zuoyeyi.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2019/11/19.
 */

public class MyrecyAdapter extends RecyclerView.Adapter{
    private final Context context;
    public final List<Person> list;

    public MyrecyAdapter(Context context, List<Person> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout2, parent, false);
        return new Myviewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        Myviewholder myviewholder= (Myviewholder) holder;
        Person person = list.get(position);
       myviewholder.id.setText(person.getId()+"");
       Glide.with(context).load(String.valueOf(person.getPic())).into(myviewholder.iv);
       myviewholder.title.setText(person.getTitle());

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
            iv = itemView.findViewById(R.id.Sird_iv2);
            id = itemView.findViewById(R.id.new_id2);
            title = itemView.findViewById(R.id.titles2);
        }
    }
}
