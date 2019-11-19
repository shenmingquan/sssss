package com.example.day2_zuoyeyi.presenter;

import android.view.Display;

import com.example.day2_zuoyeyi.bean.Student;
import com.example.day2_zuoyeyi.model.JieKou;
import com.example.day2_zuoyeyi.model.Model;
import com.example.day2_zuoyeyi.view.Kou;


/**
 * Created by lenovo on 2019/11/19.
 */

public class Presen {
    private Kou kou;

    public Presen(Kou kou) {
        this.kou = kou;
    }

    public void presen(){
        Model model = new Model();
        model.model(new JieKou() {
            @Override
            public void onSuccess(Student student) {
                if (kou!=null){
                    kou.onSuccess(student);
                }
            }

            @Override
            public void onFailre(Throwable throwable) {
                if (kou!=null){
                    kou.onFailre(throwable);
                }
            }
        });
    }
}
