package com.university.system;

/**
 * Represents a course in the Course Enrollment and Grade Management System.
 * This class stores course details and tracks enrollments.
 */
class Course {
    private String courseCode; // Unique code for the course
    private String name; // Name of the course
    private int maxCapacity; // Maximum number of students allowed in the course
    private int currentEnrollment; // Current number of students enrolled
    private static int totalEnrolled = 0; // Static variable to track total enrollments across all courses

    /**
     * Constructor to initialize a Course object.
     *
     * @param courseCode  The unique code for the course.
     * @param name        The name of the course.
     * @param maxCapacity The maximum capacity of the course.
     */
    public Course(String courseCode, String name, int maxCapacity) {
        this.courseCode = courseCode;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.currentEnrollment = 0; // Initialize current enrollment to 0
    }

    // Getters
    public String getCourseCode() { return courseCode; }
    public String getName() { return name; }
    public int getMaxCapacity() { return maxCapacity; }
    public int getCurrentEnrollment() { return currentEnrollment; }
    public static int getTotalEnrolled() { return totalEnrolled; } // Static method to get total enrollments

    /**
     * Increments the enrollment count for the course.
     * If the course is not full, it increments both current enrollment and total enrollments.
     */
    public void incrementEnrollment() {
        if (currentEnrollment < maxCapacity) {
            currentEnrollment++; // Increment current enrollment
            totalEnrolled++; // Increment total enrollments across all courses
        }
    }
}