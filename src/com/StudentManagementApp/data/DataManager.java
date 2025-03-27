package com.StudentManagementApp.data;



import com.StudentManagementApp.model.Student;
import com.StudentManagementApp.model.Course;
import com.StudentManagementApp.model.Enrollment;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static DataManager instance;
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private List<Enrollment> enrollments = new ArrayList<>();

    private DataManager() {
        // Sample data
        students.add(new Student("S001", "Alice", "alice@example.com"));
        students.add(new Student("S002", "Bob", "bob@example.com"));
        courses.add(new Course("CSE101", "Intro to Programming"));
        courses.add(new Course("MAT202", "Advanced Math"));
    }

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public void addStudent(Student student) throws Exception {
        if (students.stream().anyMatch(s -> s.getId().equals(student.getId()))) {
            throw new Exception("Student ID already exists.");
        }
        students.add(student);
    }

    public List<Student> getStudents() { return students; }
    public List<Course> getCourses() { return courses; }

    public List<Student> getEligibleStudents(Course course) {
        List<Student> enrolled = enrollments.stream()
                .filter(e -> e.getCourse().equals(course))
                .map(Enrollment::getStudent)
                .toList();
        return students.stream()
                .filter(s -> !enrolled.contains(s))
                .toList();
    }

    public void enrollStudent(Student student, Course course) {
        enrollments.add(new Enrollment(student, course, null));
    }

    public List<Enrollment> getEnrollmentsForStudent(Student student) {
        return enrollments.stream()
                .filter(e -> e.getStudent().equals(student))
                .toList();
    }

    public void updateGrade(Enrollment enrollment, String grade) {
        enrollment.setGrade(grade);
    }
}
