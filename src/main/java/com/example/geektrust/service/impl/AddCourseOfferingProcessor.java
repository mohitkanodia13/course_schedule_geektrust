package com.example.geektrust.service.impl;

import com.example.geektrust.domain.*;
import com.example.geektrust.service.CommandProcessor;

public class AddCourseOfferingProcessor implements CommandProcessor {

    CourseAllotmentServiceImpl courseAllotmentService;
    public static final int SIZE_LIMIT = 6;
    public static final String COURSE_TITLE_PREFIX = "OFFERING-";

    public AddCourseOfferingProcessor(CourseAllotmentServiceImpl courseAllotmentService) {
        this.courseAllotmentService = courseAllotmentService;
    }

    @Override
    public void process(String command) {
        
        String[] split = command.split(" ");

        String title = COURSE_TITLE_PREFIX+split[1]+"-"+split[2];

        Course course = new Course(title);
        course.setCourseName(split[1]);
        course.setCouseInstructor(split[2]);
        course.setDate(split[3]);
        course.setMinEmployee(Integer.valueOf(split[4]));
        course.setMaxEmployee(Integer.valueOf(split[5]));


        courseAllotmentService.addCourseOffering(course);

        String res = course.getCourseTitle();
        System.out.println(res);
    }

    @Override
    public boolean isValidCommand(String command, int sz) {
        return SIZE_LIMIT == sz;
    }
    
}