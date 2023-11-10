package com.example.geektrust.service.impl;

import com.example.geektrust.domain.*;
import java.util.*;
import com.example.geektrust.service.*;

public class CourseAllotmentServiceImpl implements CourseAllotmentService {

    static CourseAllotmentServiceImpl courseAllotmentService;
    public static final String REG_COURSE_PREFIX = "REG-COURSE-";

    HashMap<String, List<CourseRegistration>> map;
    HashMap<String, Course> courseMap;
    HashMap<String, CourseRegistration> regMap;

    private CourseAllotmentServiceImpl() {
        this.map = new HashMap<String, List<CourseRegistration>>();
        this.courseMap = new HashMap<>();
        this.regMap = new HashMap<>();
    }

    public String registerCourse(Course course, Employee employee) {
        if(!canAddCourseRegistration(course.getCourseTitle())) {
            return "";
        }

        String regName = getRegistrationName(course, employee);

        CourseRegistration courseRegistration = 
            new CourseRegistration(regName, course, employee);

        addCourseRegistration(courseRegistration);
        return regName;
    }

    public CourseRegistration cancelCourseRegistration(String registrationId) {

        if(!regMap.containsKey(registrationId)) {
            return null;
        }

        CourseRegistration courseRegistration = regMap.get(registrationId);
        Course course = courseRegistration.getCourse();
        
        if(course.getCourseStatus() != CourseStatus.NOT_STARTED) {
            courseRegistration.setRegistrationStatus(RegistrationStatus.CANCEL_REJECTED);
        } else {
            courseRegistration.setRegistrationStatus(RegistrationStatus.CANCEL_ACCEPTED);
        }

        return courseRegistration;
    }
    
    public boolean addCourseOffering(Course course) {

        if(map.containsKey(course.getCourseTitle())) {
            return false;
        }

        map.put(course.getCourseTitle(), new ArrayList<>());
        courseMap.put(course.getCourseTitle(), course);
        return true;
    }

    public boolean printCourseOffering(String courseTitle) {
        if(!map.containsKey(courseTitle)) {
            return false;
        }

        updateCourseStatus(courseTitle);

        List<CourseRegistration> result = map.get(courseTitle);
        Collections.sort(result);

        for(CourseRegistration courseRegistration : result) {
            if(courseRegistration.getRegistrationStatus() != RegistrationStatus.ACCEPTED) {
                continue;
            }
            System.out.println(courseRegistration);
        }

        return false;
    }

    public Course getCourseByTitle(String title) {
        return this.courseMap.get(title);
    }

    public CourseRegistration getCourseRegistration(String regName) {
        return this.regMap.get(regName);
    }


    public static CourseAllotmentServiceImpl getInstance() {
        if(courseAllotmentService == null) {
            courseAllotmentService = new CourseAllotmentServiceImpl();
        }
        return courseAllotmentService;
    }

    private void updateCourseStatus(String courseTitle) {

        Course course = courseMap.get(courseTitle);
        
        if(shouldCancelCourse(course)) {
            course.setCourseStatus(CourseStatus.COURSE_CANCELED);
        } else {
            course.setCourseStatus(CourseStatus.CONFIRMED);
        }

    }

    private boolean canAddCourseRegistration(String courseTitle) {
        if(!map.containsKey(courseTitle)) {
            return false;
        }

        if(courseLimitReached(courseTitle)) {
            return false;
        }
        return true;
    }

    private void addCourseRegistration(CourseRegistration courseRegistration) {

        List<CourseRegistration> list = map.get(courseRegistration.getCourse().getCourseTitle());
        list.add(courseRegistration);
        map.put(courseRegistration.getCourse().getCourseTitle(), list);
        regMap.put(courseRegistration.getRegistrationId(), courseRegistration);

    }

    private boolean courseLimitReached(String courseTitle) {
        Course course = courseMap.get(courseTitle);
        int currSize = map.get(course.getCourseTitle()).size();
        return currSize == course.getMaxEmployee();
    }

    private boolean shouldCancelCourse(Course course) {
        int currSize = map.get(course.getCourseTitle()).size();
        return currSize < course.getMinEmployee();
    }

    private String getRegistrationName(Course course, Employee employee) {
        String regName = REG_COURSE_PREFIX+employee.getName()+"-"+course.getCourseName();
        return regName;
    }
}
