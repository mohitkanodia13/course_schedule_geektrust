package com.example.geektrust.service.impl;

import com.example.geektrust.service.CommandProcessor;

public class DefaultProcessor implements CommandProcessor {

    public static final int SIZE_LIMIT = 6;

    @Override
    public void process(String command) {
        // System.out.println("ERROR");
    }

    @Override
    public boolean isValidCommand(String command, int sz) {
        // System.out.println("ERROR");
        return false;
    }
    
}
