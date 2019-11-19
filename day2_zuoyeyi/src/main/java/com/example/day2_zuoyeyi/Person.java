package com.example.day2_zuoyeyi;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by admin on 2019/11/19.
 */
@Entity
public class Person {
    private String pic;
    private String title;
    @Id
    private Long id;
    @Generated(hash = 1657898618)
    public Person(String pic, String title, Long id) {
        this.pic = pic;
        this.title = title;
        this.id = id;
    }
    @Generated(hash = 1024547259)
    public Person() {
    }
    public String getPic() {
        return this.pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
