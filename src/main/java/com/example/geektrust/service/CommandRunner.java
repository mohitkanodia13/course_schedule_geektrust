package com.example.geektrust.service;

import com.example.geektrust.service.impl.CommandProcessorFactory;
import com.example.geektrust.service.impl.CourseAllotmentServiceImpl;

public class CommandRunner {
    
    CourseAllotmentServiceImpl courseAllotmentService;
    CommandProcessorFactory processorFactory;
    CommandProcessor processor;
    private static CommandRunner commandRunner;

    public CommandRunner () {
        courseAllotmentService = CourseAllotmentServiceImpl.getInstance();
        processorFactory = new CommandProcessorFactory(courseAllotmentService);
    }

    private boolean isValid(String command) {
        int sz = command.split(" ").length;
        processor = processorFactory.getProcessor(command);
        boolean res = processor.isValidCommand(command, sz);
        return res;
    }

    public void runCommand(String command) {
        command = command.trim();
        if(!command.isBlank()) {
            if(!isValid(command)) {
                System.out.println("INPUT_DATA_ERROR");
                return;
            }
        }

        processor = processorFactory.getProcessor(command);
        processor.process(command);
    }

    public static CommandRunner getInstance() {
        if(commandRunner == null) {
            commandRunner = new CommandRunner();
        }
        return commandRunner;
    }

}
