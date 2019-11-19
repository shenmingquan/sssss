package com.example.day2_zuoyeyi.model;



import com.example.day2_zuoyeyi.bean.ApiServer;
import com.example.day2_zuoyeyi.bean.Student;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 2019/11/19.
 */

public class Model {
    public void model(final JieKou jieKou){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://news-at.zhihu.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        apiServer.getstudent().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Student>() {
                    @Override
                    public void accept(Student student) throws Exception {
                        if (jieKou!=null){
                            jieKou.onSuccess(student);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (jieKou!=null){
                            jieKou.onFailre(throwable);
                        }
                    }
                });
    }
}
