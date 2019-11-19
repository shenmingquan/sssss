package com.example.day2_zuoyeyi.model;


import com.example.day2_zuoyeyi.bean.Student;

/**
 * Created by lenovo on 2019/11/19.
 */

public interface JieKou {
    void onSuccess(Student student);
    void onFailre(Throwable throwable);
}
