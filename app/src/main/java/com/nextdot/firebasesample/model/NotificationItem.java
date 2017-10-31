package com.nextdot.firebasesample.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by imtiazkalamabir on 10/30/17.
 */

public class NotificationItem {

    @SerializedName("title")
    private String title;
    @SerializedName("subtitle")
    private String subtitle;
    @SerializedName("id")
    private int id;
    @SerializedName("time")
    private String time;
    @SerializedName("img_url")
    private String img_url;
    @SerializedName("type")
    private String type;

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public NotificationItem(String title, String subtitle, int id, String time, String img_url, String type) {
        this.title = title;
        this.subtitle = subtitle;
        this.id = id;
        this.time = time;
        this.img_url = img_url;
        this.type = type;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String date) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "NotificationItem{" +
                "title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", id='" + id + '\'' +
                ", time='" + time + '\'' +
                ", img_url='" + img_url + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

}
