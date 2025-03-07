package com.university.system;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Provides a command-line interface for administrators to manage courses, students, and grades.
 */
public class AdministratorInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu(); // Display the menu
            int choice = readChoice(scanner); // Read the user's choice
            handleChoice(choice, scanner); // Handle the choice
        }
    }

    /**
     * Displays the menu options.
     */
    private static void printMenu() {
        System.out.println("\n1. Add Course");
        System.out.println("2. Enroll Student");
        System.out.println("3. Assign Grade");
        System.out.println("4. Calculate Overall Grade");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    /**
     * Reads the user's choice from the input.
     *
     * @param scanner The Scanner object to read input.
     * @return The user's choice as an integer.
     */
    private static int readChoice(Scanner scanner) {
        try {
            return scanner.nextInt(); // Read the integer choice
        } catch (InputMismatchException e) {
            return -1; // Return -1 for invalid input
        } finally {
            scanner.nextLine(); // Clear the input buffer
        }
    }

    /**
     * Handles the user's choice by calling the appropriate method.
     *
     * @param choice  The user's choice.
     * @param scanner The Scanner object to read input.
     */
    private static void handleChoice(int choice, Scanner scanner) {
        switch (choice) {
            case 1: addCourse(scanner); break; // Add a new course
            case 2: enrollStudent(scanner); break; // Enroll a student
            case 3: assignGrade(scanner); break; // Assign a grade
            case 4: calculateOverallGrade(scanner); break; // Calculate overall grade
            case 5: exit(); // Exit the program
            default: System.out.println("Invalid option."); // Handle invalid choices
        }
    }

    /**
     * Adds a new course to the system.
     *
     * @param scanner The Scanner object to read input.
     */
    private static void addCourse(Scanner scanner) {
        System.out.print("Enter course code: ");
        String code = scanner.nextLine();
        System.out.print("Enter course name: ");
        String name = scanner.nextLine();
        System.out.print("Enter max capacity: ");
        try {
            int maxCap = scanner.nextInt();
            if (maxCap <= 0) throw new IllegalArgumentException();
            CourseManagement.addCourse(code, name, maxCap); // Add the course
            System.out.println("Course added.");
        } catch (Exception e) {
            System.out.println("Invalid capacity."); // Handle invalid input
        }
        scanner.nextLine(); // Clear the input buffer
    }

    /**
     * Enrolls a student in a course.
     *
     * @param scanner The Scanner object to read input.
     */
    private static void enrollStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter course code: ");
        String code = scanner.nextLine();
        Student student = CourseManagement.getOrCreateStudent(id, name); // Get or create the student
        Course course = CourseManagement.findCourseByCode(code); // Find the course
        if (course != null) {
            CourseManagement.enrollStudent(student, course); // Enroll the student
        } else {
            System.out.println("Course not found.");
        }
    }

    /**
     * Assigns a grade to a student for a specific course.
     *
     * @param scanner The Scanner object to read input.
     */
    private static void assignGrade(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        Student student = CourseManagement.findStudentById(id); // Find the student
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter course code: ");
        Course course = CourseManagement.findCourseByCode(scanner.nextLine()); // Find the course
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }
        System.out.print("Enter grade: ");
        try {
            double grade = scanner.nextDouble();
            CourseManagement.assignGrade(student, course, grade); // Assign the grade
        } catch (InputMismatchException e) {
            System.out.println("Invalid grade."); // Handle invalid input
        }
        scanner.nextLine(); // Clear the input buffer
    }

    /**
     * Calculates the overall grade for a student.
     *
     * @param scanner The Scanner object to read input.
     */
    private static void calculateOverallGrade(Scanner scanner) {
        System.out.print("Enter student ID: ");
        Student student = CourseManagement.findStudentById(scanner.nextLine()); // Find the student
        if (student != null) {
            double grade = CourseManagement.calculateOverallGrade(student); // Calculate the overall grade
            System.out.println("Overall grade: " + grade);
        } else {
            System.out.println("Student not found.");
        }
    }

    /**
     * Exits the program.
     */
    private static void exit() {
        System.out.println("Exiting...");
        System.exit(0); // Terminate the program
    }
}