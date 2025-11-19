package com.example.course_work;

public class News {
    private String title;
    private String description;
    private int imageResource;

    public News(String title, String description, int imageResource) {
        this.title = title;
        this.description = description;
        this.imageResource = imageResource;
    }

    // Getters for the news attributes
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResource() {
        return imageResource;
    }
}
