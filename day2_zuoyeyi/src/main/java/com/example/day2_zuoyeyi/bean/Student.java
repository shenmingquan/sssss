package com.example.day2_zuoyeyi.bean;

import java.util.List;

/**
 * Created by lenovo on 2019/11/19.
 */

public class Student {

    private List<RecentBean> recent;

    public List<RecentBean> getRecent() {
        return recent;
    }

    public void setRecent(List<RecentBean> recent) {
        this.recent = recent;
    }

    public static class RecentBean {
        @Override
        public String toString() {
            return "RecentBean{" +
                    "news_id=" + news_id +
                    ", url='" + url + '\'' +
                    ", thumbnail='" + thumbnail + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }

        /**
         * news_id : 9717396
         * url : http://news-at.zhihu.com/api/2/news/9717396
         * thumbnail : https://pic1.zhimg.com/v2-ec1ab0e758baeb18884795c8a4825ca4.jpg
         * title : 瞎扯 · 如何正确地吐槽
         */

        private int news_id;
        private String url;
        private String thumbnail;
        private String title;

        public int getNews_id() {
            return news_id;
        }

        public void setNews_id(int news_id) {
            this.news_id = news_id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
