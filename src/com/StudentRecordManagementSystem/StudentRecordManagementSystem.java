package com.StudentRecordManagementSystem;


import java.util.ArrayList;
import java.util.Scanner;

public class StudentRecordManagementSystem {

    // Static variables to store student data
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static int totalStudents = 0;

    // Student class to represent student data
    static class Student {
        String name;
        int id;
        int age;
        String grade;

        // Constructor to initialize student details
        public Student(String name, int id, int age, String grade) {
            this.name = name;
            this.id = id;
            this.age = age;
            this.grade = grade;
        }

        // Override toString() to display student details
        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade;
        }
    }

    // Method to add a new student
    public static void addStudent(Scanner scanner) {
        System.out.println("\n--- Add New Student ---");
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Student Grade: ");
        String grade = scanner.nextLine();

        // Check if student ID already exists
        for (Student student : studentList) {
            if (student.id == id) {
                System.out.println("Error: Student ID already exists!");
                return;
            }
        }

        // Add new student to the list
        studentList.add(new Student(name, id, age, grade));
        totalStudents++;
        System.out.println("Student added successfully!");
    }

    // Method to update student information
    public static void updateStudent(Scanner scanner) {
        System.out.println("\n--- Update Student Information ---");
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Find the student by ID
        Student studentToUpdate = null;
        for (Student student : studentList) {
            if (student.id == id) {
                studentToUpdate = student;
                break;
            }
        }

        if (studentToUpdate == null) {
            System.out.println("Error: Student ID not found!");
            return;
        }

        // Prompt for updated details
        System.out.print("Enter new Name (leave blank to keep current): ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            studentToUpdate.name = newName;
        }

        System.out.print("Enter new Age (leave 0 to keep current): ");
        int newAge = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (newAge != 0) {
            studentToUpdate.age = newAge;
        }

        System.out.print("Enter new Grade (leave blank to keep current): ");
        String newGrade = scanner.nextLine();
        if (!newGrade.isEmpty()) {
            studentToUpdate.grade = newGrade;
        }

        System.out.println("Student information updated successfully!");
    }

    // Method to view student details
    public static void viewStudentDetails(Scanner scanner) {
        System.out.println("\n--- View Student Details ---");
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Find the student by ID
        Student studentToView = null;
        for (Student student : studentList) {
            if (student.id == id) {
                studentToView = student;
                break;
            }
        }

        if (studentToView == null) {
            System.out.println("Error: Student ID not found!");
        } else {
            System.out.println(studentToView);
        }
    }

    // Method to display the main menu
    public static void displayMenu() {
        System.out.println("\n--- Student Record Management System ---");
        System.out.println("1. Add New Student");
        System.out.println("2. Update Student Information");
        System.out.println("3. View Student Details");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    // Main method to run the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    updateStudent(scanner);
                    break;
                case 3:
                    viewStudentDetails(scanner);
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }
}