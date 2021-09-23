package com.hp.major.FindUrWay;

/**
 * Created by HP on 06-04-2018.
 */

public class Metro {
    private String name;
    private int thumbnail;

    public Metro() {
    }

    public Metro(String name , int thumbnail ) {
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public  int getThumbnail()
    {
        return thumbnail;
    }
    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }



}
