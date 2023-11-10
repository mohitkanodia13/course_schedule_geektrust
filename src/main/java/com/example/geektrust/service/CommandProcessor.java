package com.example.geektrust.service;

public interface CommandProcessor {

    public void process(String command);

    public boolean isValidCommand(String command, int sz);

}