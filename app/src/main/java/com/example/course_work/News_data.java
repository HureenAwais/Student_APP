package com.example.course_work;

import java.util.ArrayList;
import java.util.List;

public class News_data {

    public static List<News> getNewsData() {
        List<News> newsList = new ArrayList<>();

        //  news items
        newsList.add(new News("Ulster University look at doubling student numbers at Magee Campus", "A taskforce has been announced to develop a plan to almost double the student population at the Ulster University’s Magee campus.\n" +
                "\n" +
                "There are currently just over 5,000 students at the campus in Londonderry.\n" +
                "\n" +
                "Economy Minister Conor Murphy has launched a taskforce to develop and oversee an action plan to expand numbers to 10,000.", R.drawable.img));

       /*newsList.add(new News("Oxford Brookes University installs 10 vape recycling bins on campus", "Oxford Brookes University has helped to extend the reach of the Recycle Your Vapes campaign by installing 10 vape recycling bins across its campuses.\n" +
                "\n" +
                "The initiative, which started in November, provides simple ways for the responsible disposal of disposable vapes.", R.drawable.img_1)); */



        return newsList;
    }
}
