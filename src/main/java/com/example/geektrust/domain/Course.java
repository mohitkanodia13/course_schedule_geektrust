package com.example.geektrust.domain;

public class Course {
    private final String title;
    private String name;
    private String instructor;
    private String date;
    private int minEmployee;
    private int maxEmployee;
    private CourseStatus courseStatus;
    
    public Course(String title) {
        this.title = title;
        this.courseStatus = CourseStatus.NOT_STARTED;
    }

    public String getCourseTitle() {
        return this.title;
    }

    public String getCourseName() {
        return this.name;
    }

    public int getMaxEmployee() {
        return this.maxEmployee;
    }

    public int getMinEmployee() {
        return this.minEmployee;
    }

    public CourseStatus getCourseStatus() {
        return this.courseStatus;
    }
 
    public void setCourseName(String name) {
        this.name = name;
    }

    public void setCouseInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMinEmployee(int minEmployee) {
        this.minEmployee = minEmployee;
    }

    public void setMaxEmployee(int maxEmployee) {
        this.maxEmployee = maxEmployee;
    }

    public void setCourseStatus(CourseStatus status) {
        this.courseStatus = status;
    }

    public String toString() {
        return this.title+" "+
        this.name+" "+
        this.instructor+" "+
        this.date+" "+
        this.courseStatus;
    }
}
