package com.example.geektrust.service;

import com.example.geektrust.domain.*;

public interface CourseAllotmentService {

    public String registerCourse(Course course, Employee employee);

    public CourseRegistration cancelCourseRegistration(String registrationId);
    
    public boolean addCourseOffering(Course course);

    public boolean printCourseOffering(String courseTitle);

    public Course getCourseByTitle(String title);

    public CourseRegistration getCourseRegistration(String regName);

}
