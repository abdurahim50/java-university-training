package com.university.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a student in the Course Enrollment and Grade Management System.
 * This class stores student details, enrolled courses, and grades for each course.
 */
class Student {
    private String name; // Student's name
    private String id; // Student's unique ID
    private List<Course> enrolledCourses; // List of courses the student is enrolled in
    private Map<Course, Double> grades; // Map to store grades for each course

    /**
     * Constructor to initialize a Student object.
     *
     * @param name The name of the student.
     * @param id   The unique ID of the student.
     */
    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.enrolledCourses = new ArrayList<>(); // Initialize empty list of enrolled courses
        this.grades = new HashMap<>(); // Initialize empty map for grades
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getId() { return id; }
    public List<Course> getEnrolledCourses() { return new ArrayList<>(enrolledCourses); } // Return a copy of enrolled courses
    public Map<Course, Double> getGrades() { return new HashMap<>(grades); } // Return a copy of grades

    /**
     * Enrolls the student in a course.
     *
     * @param course The course to enroll in.
     */
    public void enrollCourse(Course course) {
        enrolledCourses.add(course); // Add the course to the student's enrolled courses
    }

    /**
     * Assigns a grade to the student for a specific course.
     *
     * @param course The course for which the grade is assigned.
     * @param grade  The grade to assign.
     */
    public void assignGrade(Course course, double grade) {
        grades.put(course, grade); // Add the grade to the student's grade map
    }
}