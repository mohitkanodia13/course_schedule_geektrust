package com.example.geektrust.domain;

public class Employee {
    private final String name;
    private final String emailId;

    public Employee(String name, String emailId) {
        this.name = name;
        this.emailId = emailId;
    }

    public String toString() {
        return this.name + " " + this.emailId;
    }

    public String getName() {
        return this.name;
    }

    public String getEmailId() {
        return this.emailId;
    }
    
}
