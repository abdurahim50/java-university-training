# Course Enrollment and Grade Management System

## Overview
This assignment will assess your skills and knowledge to:
- Implement class methods and instance methods to define behavior and manipulate object state.
- Apply access modifiers to control access to class members.

## Project Context
You have been assigned to develop a **Course Enrollment and Grade Management System** in Java for a university. The system should provide functionality to:
- Enroll students in courses.
- Assign grades to students.
- Calculate overall course grades for each student.

The project should demonstrate the effective utilization of **static methods and variables** to keep track of enrollment and grade-related information across multiple instances of the `Student` and `Course` classes. It should also showcase your ability to **manipulate object state and define behavior** through instance methods.

## Requirements
### Student Class
- The `Student` class should have **private instance variables** to store student information such as name, ID, and enrolled courses.
- Implement **appropriate access modifiers** and provide **public getter and setter methods** for accessing and updating student information.
- Design a method to **enroll students in courses**. It should accept a `Course` object as a parameter and add the course to the student's enrolled courses.
- Implement a method to **assign grades to students**. It should accept a `Course` object and a grade for the student and update the student's grade for that course.

### Course Class
- The `Course` class should have **private instance variables** to store course information such as course code, name, and maximum capacity.
- Use **appropriate access modifiers** and provide **public getter methods** for accessing course information.
- Implement a **static variable** to keep track of the total number of enrolled students across all instances of the `Course` class.
- Design a **static method** to retrieve the total number of enrolled students.

### CourseManagement Class
- The `CourseManagement` class should have **private static variables** to store a list of courses and the overall course grades for each student.
- Use **appropriate access modifiers** to control access to the variables.
- Implement **static methods** to:
    - Add new courses.
    - Enroll students.
    - Assign grades.
    - Calculate overall course grades for each student.
- The `addCourse` method should accept parameters for course information, create a new `Course` object, and add it to the list of courses.
- The `enrollStudent` method should accept a `Student` object and a `Course` object and enroll the student in the course.
- The `assignGrade` method should accept a `Student` object, a `Course` object, and a grade, and assign the grade to the student.
- The `calculateOverallGrade` method should accept a `Student` object and calculate the overall course grade for that student.

### Administrator Interface
- Develop an **interactive command-line interface** for administrators.
- Display a menu with options to:
    - Add a new course.
    - Enroll students.
    - Assign grades.
    - Calculate overall course grades.
- Prompt the administrator for necessary inputs and call appropriate methods in the `CourseManagement` and `Student` classes.
- Implement **error handling** to manage invalid inputs and ensure students cannot be enrolled in courses that have reached maximum capacity.

## Documentation
- Provide comprehensive documentation explaining:
    - The purpose and usage of each class, method, and variable.
    - How **static methods and variables** are used to track enrollment and grade-related information across multiple instances.
- Include **instructions** for running the program and interacting with the administrator interface.

## Assessment Criteria
- **Object-Oriented Design**: Modular code organization, encapsulation, and effective use of static methods and variables.
- **Student Update Feature**: Ability to modify student information including name, ID, and enrolled courses.
- **Course Update Feature**: Ability to update course information such as course code, name, and maximum capacity.
- **Course Management Update**: Functionality to add, modify, or remove courses.
- **Administrator Interface**: A user-friendly command-line interface to manage courses, enroll students, assign grades, and calculate overall course grades.
- **Documentation**: Clear instructions and explanations to ensure ease of understanding and maintenance.

## Running the Program
To run the **Course Enrollment and Grade Management System**, follow these steps:
1. Compile all Java files using:
   ```sh
   javac *.java
   ```
2. Run the main class:
   ```sh
   java CourseManagement
   ```
3. Follow the on-screen prompts to interact with the system.

Ensure Java is installed on your system before executing the program.

---
This project aims to enhance your understanding of **object-oriented programming** in Java while demonstrating key concepts such as **encapsulation, static members, and instance methods** in a practical context.

