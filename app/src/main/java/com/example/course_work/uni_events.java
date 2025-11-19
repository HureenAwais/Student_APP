package com.example.course_work;

public class uni_events {
    private String name;
    private String location;
    private int imageResource;
    private String date;

    public uni_events(String name, String location,  String date,int imageResource) {
        this.name = name;
        this.location = location;
        this.date = date;
        this.imageResource = imageResource;
    }

    // Getters for the news attributes
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }


    public String getDate() {
        return date;
    }
    public int getImageResource() {
        return imageResource;
    }

}
