package com.apps.kunalfarmah.edunomics.Models;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class BlogModel {
    Drawable img;
    String title, date, stitle, info;
    ArrayList<String> vidlinks;

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStitle() {
        return stitle;
    }

    public void setStitle(String stitle) {
        this.stitle = stitle;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ArrayList<String> getVidlinks() {
        return vidlinks;
    }

    public void setVidlinks(ArrayList<String> vidlinks) {
        this.vidlinks = vidlinks;
    }

    public BlogModel(Drawable img, String title, String date, String stitle, String info, ArrayList<String> vidlinks) {
        this.img = img;
        this.title = title;
        this.date = date;
        this.stitle = stitle;
        this.info = info;
        this.vidlinks = vidlinks;
    }
}
