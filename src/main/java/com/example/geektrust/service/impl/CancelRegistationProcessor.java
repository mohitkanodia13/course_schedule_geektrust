package com.example.geektrust.service.impl;

import com.example.geektrust.domain.*;
import com.example.geektrust.service.CommandProcessor;

public class CancelRegistationProcessor implements CommandProcessor{
    

    public static final int SIZE_LIMIT = 2;
    CourseAllotmentServiceImpl courseAllotmentService;

    public CancelRegistationProcessor(CourseAllotmentServiceImpl courseAllotmentService) {
        this.courseAllotmentService = courseAllotmentService;
    }

    @Override
    public void process(String command) {
        
        String[] split = command.split(" ");
        String regName = split[1];

        CourseRegistration courseRegistration = courseAllotmentService.cancelCourseRegistration(regName);
        if(courseRegistration == null) {
            return;
        }
        String res = courseRegistration.getRegistrationId() +" "+courseRegistration.getRegistrationStatus();
        System.out.println(res);
    }

    @Override
    public boolean isValidCommand(String command, int sz) {
        return SIZE_LIMIT == sz;
    }
    
}
