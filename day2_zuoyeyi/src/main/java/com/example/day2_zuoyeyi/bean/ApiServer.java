package com.example.day2_zuoyeyi.bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by lenovo on 2019/11/19.
 */

public interface ApiServer {
    @GET("api/4/news/hot")
    Observable<Student> getstudent();
}
