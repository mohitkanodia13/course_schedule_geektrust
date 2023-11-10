package com.example.geektrust.service.impl;

import com.example.geektrust.service.CommandProcessor;

public class AllotCourseProcessor implements CommandProcessor  {
    
    CourseAllotmentServiceImpl courseAllotmentService;
    public static final int SIZE_LIMIT = 2;

    public AllotCourseProcessor(CourseAllotmentServiceImpl courseAllotmentService) {
        this.courseAllotmentService = courseAllotmentService;
    }

    @Override
    public void process(String command) {
        
        String[] split = command.split(" ");
        String courseTitle = split[1];

        courseAllotmentService.printCourseOffering(courseTitle);
    }

    @Override
    public boolean isValidCommand(String command, int sz) {
        return SIZE_LIMIT == sz;
    }
}
