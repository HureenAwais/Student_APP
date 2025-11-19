package com.example.course_work;

public class timetableEntry {

    private String dayOfWeek; // New field for day of the week
    private String time;
    private String moduleCode;
    private String moduleName;
    private String location;

    public timetableEntry(String dayOfWeek, String time, String moduleCode, String moduleName, String location) {
        this.dayOfWeek = dayOfWeek;
        this.time = time;
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.location = location;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
