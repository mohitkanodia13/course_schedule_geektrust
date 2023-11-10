package com.example.geektrust.service;

public interface ProcessorFactory {

    CommandProcessor getProcessor(String command);
}
