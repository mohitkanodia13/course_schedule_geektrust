package com.example.geektrust.service.impl;

import com.example.geektrust.domain.*;
import com.example.geektrust.service.CommandProcessor;

public class RegisterEmployeeCourseProcessor implements CommandProcessor{

    public static final int SIZE_LIMIT = 3;
    CourseAllotmentServiceImpl courseAllotmentService;    
    public static final String COURSE_FULL_ERROR = "COURSE_FULL_ERROR";


    public RegisterEmployeeCourseProcessor(CourseAllotmentServiceImpl courseAllotmentService) {
        this.courseAllotmentService = courseAllotmentService;
    }

    @Override
    public void process(String command) {
        
        String[] split = command.split(" ");

        String name = getEmployeeName(split[1]);
        Employee employee = new Employee(name, split[1]);

        String courseTitle = split[2];
        Course course = courseAllotmentService.getCourseByTitle(courseTitle);
        
        String result = courseAllotmentService.registerCourse(course, employee);
        if(result.isBlank()) {
            System.out.println(COURSE_FULL_ERROR);
        } else {
            CourseRegistration courseRegistration = courseAllotmentService.getCourseRegistration(result);
            String res = result+" "+courseRegistration.getRegistrationStatus();
            System.out.println(res);
        }
    }

    private static String getEmployeeName(String emailId) {
        String[] split = emailId.split("@");
        return split[0];
    }

    @Override
    public boolean isValidCommand(String command, int sz) {
        return SIZE_LIMIT == sz;
    }
}
