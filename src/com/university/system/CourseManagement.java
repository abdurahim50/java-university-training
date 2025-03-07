package com.university.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages courses, students, and grades in the Course Enrollment and Grade Management System.
 * This class provides static methods to add courses, enroll students, assign grades, and calculate overall grades.
 */
class CourseManagement {
    private static List<Course> courses = new ArrayList<>(); // List of all courses
    private static List<Student> students = new ArrayList<>(); // List of all students
    private static Map<Student, Double> overallGrades = new HashMap<>(); // Map to store overall grades for each student

    /**
     * Adds a new course to the system.
     *
     * @param code     The course code.
     * @param name     The course name.
     * @param maxCap   The maximum capacity of the course.
     */
    public static void addCourse(String code, String name, int maxCap) {
        courses.add(new Course(code, name, maxCap)); // Create and add a new course to the list
    }

    /**
     * Finds a course by its code.
     *
     * @param code The course code to search for.
     * @return The Course object if found, otherwise null.
     */
    public static Course findCourseByCode(String code) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(code)) {
                return course; // Return the course if the code matches
            }
        }
        return null; // Return null if the course is not found
    }

    /**
     * Retrieves a student by ID or creates a new student if not found.
     *
     * @param id   The student ID.
     * @param name The student name.
     * @return The Student object.
     */
    public static Student getOrCreateStudent(String id, String name) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student; // Return the student if the ID matches
            }
        }
        Student newStudent = new Student(name, id); // Create a new student
        students.add(newStudent); // Add the new student to the list
        return newStudent;
    }

    /**
     * Enrolls a student in a course.
     *
     * @param student The student to enroll.
     * @param course  The course to enroll in.
     */
    public static void enrollStudent(Student student, Course course) {
        if (course.getCurrentEnrollment() < course.getMaxCapacity()) {
            student.enrollCourse(course); // Enroll the student in the course
            course.incrementEnrollment(); // Increment the enrollment count
            System.out.println("Enrollment successful.");
        } else {
            System.out.println("Course is full. Enrollment failed.");
        }
    }

    /**
     * Assigns a grade to a student for a specific course.
     *
     * @param student The student to assign the grade to.
     * @param course  The course for which the grade is assigned.
     * @param grade   The grade to assign.
     */
    public static void assignGrade(Student student, Course course, double grade) {
        if (student.getEnrolledCourses().contains(course)) {
            student.assignGrade(course, grade); // Assign the grade if the student is enrolled
            System.out.println("Grade assigned.");
        } else {
            System.out.println("Student not enrolled in course.");
        }
    }

    /**
     * Calculates the overall grade for a student based on their grades in all courses.
     *
     * @param student The student to calculate the grade for.
     * @return The overall grade.
     */
    public static double calculateOverallGrade(Student student) {
        Map<Course, Double> grades = student.getGrades();
        if (grades.isEmpty()) return 0.0; // Return 0 if no grades are available
        double sum = grades.values().stream().mapToDouble(Double::doubleValue).sum(); // Sum all grades
        double avg = sum / grades.size(); // Calculate the average
        overallGrades.put(student, avg); // Store the overall grade
        return avg;
    }

    /**
     * Finds a student by their ID.
     *
     * @param id The student ID to search for.
     * @return The Student object if found, otherwise null.
     */
    public static Student findStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student; // Return the student if the ID matches
            }
        }
        return null; // Return null if the student is not found
    }
}