package com.example.myapplication.Model;

public class NicePlace {
    private String mTitle;
    private String mImageUrl;

    public NicePlace(String mTitle, String mImageUrl) {
        this.mTitle = mTitle;
        this.mImageUrl = mImageUrl;
    }
    public NicePlace() {
    }
    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }
}
