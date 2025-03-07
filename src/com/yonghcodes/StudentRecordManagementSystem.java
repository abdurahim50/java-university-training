package com.yonghcodes;


import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Student Record Management System
 *
 * This program allows administrators to manage student records. It provides
 * functionalities to add new students, update student information, and view
 * student details.
 */

public class StudentRecordManagementSystem {
    // static variable to store student data
    private static final ArrayList<Student> studentList = new ArrayList<>();

    // student class representing a student's information
    static class Student {
        String name;
        int id;
        int age;
        String grade;

        // Constructor to initialize student details
        public Student(String name, int id, int age, String grade){
            this.name = name;
            this.id = id;
            this.grade = grade;
        }
        // Override toString() to display student details
        @Override
        public String toString(){

            return "Student Details:\nID: " + id + ", \nName: " + name + ", \nAge: " + age + ", \nGrade: " + grade;
        }
    }

    // Method to add a new student to the system
    private static void addStudent(Scanner scanner){
        System.out.println("\n--- Add New Student ---");
        System.out.print("Enter Student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        // Check if student ID already exists
        if (studentList.stream().anyMatch(s -> s.id == id)){
            System.out.println("Error: Student ID already exists!");
            return;
        }
        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Student Grade: ");
        String grade = scanner.nextLine();

        studentList.add(new Student(name, id, age, grade));
        System.out.println("Student added successfully");

    }

    // Method to update existing student's information
    private static void updateStudent(Scanner scanner){
        System.out.println("\n--- Update Student Information---");
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Student student = studentList.stream().filter(s -> s.id == id).findFirst().orElse(null);

        if (student == null){
            System.out.println("Error: Student ID not found!");
            return;
        }
        // Prompt for updated details
        System.out.print("Enter new Name (leave blank to keep current): ");
        String newName = scanner.nextLine();
        if (!newName.isBlank()){
            student.name = newName;
        }
        System.out.print("Enter new Age (leave 0 to keep current): ");
        int newAge = scanner.nextInt();
        scanner.nextLine();
        if (newAge > 0){
            student.age = newAge;
        }

        System.out.print("Enter new Grade (leave blank to keep current): ");
        String newGrade = scanner.nextLine();
        if (!newGrade.isBlank()){
            student.grade = newGrade;
        }

        System.out.println("Student Information updated successfully!");

    }

    // Method to view student details based on ID
    private static void viewStudent(Scanner scanner){
        System.out.println("\n--- View Student Details ---");
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Student student = studentList.stream().filter(s -> s.id == id).findFirst().orElse(null);

        if (student == null){
            System.out.println("Error: Student ID not found!");
        } else {
            System.out.println(student);
        }

    }
    // Method to display the main menu
    private static void displayMenu() {
        System.out.println("\n--- Student Record Management System ---");
        System.out.println("1. Add New Student");
        System.out.println("2. Update Student Information");
        System.out.println("3. View Student Details");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }


    // main method to run the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running){
            displayMenu();
            int choice;

            if (scanner.hasNextInt()){
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (choice){
                case 1 -> addStudent(scanner);
                case 2 -> updateStudent(scanner);
                case 3 -> viewStudent(scanner);
                case 4 -> {
                    running = false;
                    System.out.println("Exiting the program. Goodbye!");
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }
}