package com.hp.major.FindUrWay;

public class Upload {
    private String mName;
    private String mImageUrl;
    private String mValue1;

    public Upload() {
        //empty constructor needed
    }

    public Upload(String name, String imageUrl,String value1) {
        if (name.trim().equals("")) {
            name = "No Name";
        }

        mName = name;
        mImageUrl = imageUrl;
        mValue1= value1;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
    public String getValue1() {
        return mValue1;
    }

    public void setValue1(String value1) {
        mValue1 = value1;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }
}