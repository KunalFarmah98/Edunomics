package com.apps.kunalfarmah.edunomics;

import android.graphics.drawable.Drawable;

public class DataModel {

    private Drawable img;

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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public DataModel(Drawable img, String title, String info) {
        this.img = img;
        this.title = title;
        this.info = info;
    }

    private String title,info;


}
