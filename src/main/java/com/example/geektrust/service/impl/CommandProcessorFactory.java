package com.example.geektrust.service.impl;

import com.example.geektrust.constant.*;
import com.example.geektrust.service.CommandProcessor;
import com.example.geektrust.service.ProcessorFactory;

import java.util.*;

public class CommandProcessorFactory implements ProcessorFactory {

    CourseAllotmentServiceImpl courseAllotmentService;
    HashMap<String, CommandProcessor> processorMap;

    public CommandProcessorFactory(CourseAllotmentServiceImpl courseAllotmentService ) {
        this.processorMap = new HashMap<>();
        this.courseAllotmentService = courseAllotmentService;
        processorMap.put(CommadConstant.ADD_COURSE, new AddCourseOfferingProcessor(courseAllotmentService));
        processorMap.put(CommadConstant.REGITER, new RegisterEmployeeCourseProcessor(courseAllotmentService));
        processorMap.put(CommadConstant.ALLOT, new AllotCourseProcessor(courseAllotmentService));
        processorMap.put(CommadConstant.CANCEL, new CancelRegistationProcessor(courseAllotmentService));
    }

    public CommandProcessor getProcessor(String command) {
        String[] split = command.split(" ");
        
        switch(split[0]) {
            case CommadConstant.ADD_COURSE :
                return processorMap.get(CommadConstant.ADD_COURSE);
            case CommadConstant.REGITER :
                return processorMap.get(CommadConstant.REGITER);
            case CommadConstant.ALLOT :
                return processorMap.get(CommadConstant.ALLOT);
            case CommadConstant.CANCEL :
                return processorMap.get(CommadConstant.CANCEL);
            default:
                return new DefaultProcessor();
        }
    }
}
