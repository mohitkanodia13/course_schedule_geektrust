package com.example.geektrust.domain;

public class CourseRegistration implements Comparable<CourseRegistration> {
    private final Course course;
    private final Employee employee;
    private RegistrationStatus status;
    private final String registrationId;

    public CourseRegistration(String registrationId, Course course, Employee employee) {
        this.course = course;
        this.employee = employee;
        this.registrationId = registrationId;
        this.status = RegistrationStatus.ACCEPTED;
    }

    public Course getCourse() {
        return this.course;
    }

    public void setRegistrationStatus(RegistrationStatus registrationStatus) {
        this.status = registrationStatus;
    }

    public RegistrationStatus getRegistrationStatus() {
        return this.status;
    }

    public String getRegistrationId() {
        return this.registrationId;
    }


    @Override
    public int compareTo(CourseRegistration t) {
        return this.registrationId.compareTo(t.registrationId);
    }

    public String toString() {
        String res = "";

        if(status == RegistrationStatus.ACCEPTED) {
            res = 
            this.registrationId + " " + 
            this.employee.getEmailId()+ " " +
            this.course;
        } else {
            res = 
            this.registrationId + " " + 
            this.status;
        }
        

        return res;
    }
    
}
