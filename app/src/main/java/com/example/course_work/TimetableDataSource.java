package com.example.course_work;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TimetableDataSource {

    // Define your timetable entries here or fetch them from another source
    private static List<timetableEntry> getTimetableEntries() {
        List<timetableEntry> timetableEntries = new ArrayList<>();

        // Monday
        timetableEntries.add(new timetableEntry("Monday", "9:00 AM - 10:00 AM", "CS101", "Introduction to Computer Science", "EDITH MORLEY"));
        timetableEntries.add(new timetableEntry("Monday", "10:00 AM - 12:00 PM", "CS201", "Data Structures and Algorithms", "JJ THOMPSON Slingo Lecture Theatre"));

        // Tuesday
        timetableEntries.add(new timetableEntry("Tuesday", "9:00 AM - 11:00 AM", "CS102", "Database Systems", "Main Building"));
        timetableEntries.add(new timetableEntry("Tuesday", "11:00 AM - 12:00 PM", "CS301", "Software Engineering", "Engineering Building"));

        // Wednesday
        timetableEntries.add(new timetableEntry("Wednesday", "9:00 AM - 10:00 AM", "CS202", "Operating Systems", "Main Building"));
        timetableEntries.add(new timetableEntry("Wednesday", "10:00 AM - 12:00 PM", "CS401", "Computer Networks", "Engineering Building"));

        // Thursday
        timetableEntries.add(new timetableEntry("Thursday", "9:00 AM - 11:00 AM", "CS103", "Web Development", "Main Building"));
        timetableEntries.add(new timetableEntry("Thursday", "11:00 AM - 12:00 PM", "CS501", "Artificial Intelligence", "Engineering Building"));

        // Friday
        timetableEntries.add(new timetableEntry("Friday", "9:00 AM - 10:00 AM", "CS204", "Cybersecurity", "Main Building"));
        timetableEntries.add(new timetableEntry("Friday", "10:00 AM - 12:00 PM", "CS301", "Machine Learning", "Engineering Building"));

        return timetableEntries;
    }

    public static List<timetableEntry> getTimetableEntries(int dayOfWeek) {
        List<timetableEntry> timetableEntries = new ArrayList<>();

        // Convert the day of the week integer to its corresponding string representation
        String dayOfWeekString;
        switch (dayOfWeek) {
            case Calendar.MONDAY:
                dayOfWeekString = "Monday";
                break;
            case Calendar.TUESDAY:
                dayOfWeekString = "Tuesday";
                break;
            case Calendar.WEDNESDAY:
                dayOfWeekString = "Wednesday";
                break;
            case Calendar.THURSDAY:
                dayOfWeekString = "Thursday";
                break;
            case Calendar.FRIDAY:
                dayOfWeekString = "Friday";
                break;
            default:
                // Handle other cases if needed
                dayOfWeekString = ""; // Default value
                break;
        }

        // Retrieve timetable entries for the specified day of the week
        for (timetableEntry entry : getTimetableEntries()) {
            if (entry.getDayOfWeek().equalsIgnoreCase(dayOfWeekString)) {
                timetableEntries.add(entry);
            }
        }

        return timetableEntries;
    }
}

