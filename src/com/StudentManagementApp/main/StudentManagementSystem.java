package com.StudentManagementApp.main;


import com.StudentManagementApp.gui.StudentPanel;
import com.StudentManagementApp.gui.CourseEnrollmentPanel;
import com.StudentManagementApp.gui.GradeManagementPanel;

import javax.swing.*;

public class StudentManagementSystem extends JFrame {
    public StudentManagementSystem() {
        setTitle("Student Management System");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Students", new StudentPanel());
        tabbedPane.addTab("Course Enrollment", new CourseEnrollmentPanel());
        tabbedPane.addTab("Grades", new GradeManagementPanel());

        add(tabbedPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentManagementSystem().setVisible(true));
    }
}