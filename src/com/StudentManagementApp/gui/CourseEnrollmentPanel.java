package com.StudentManagementApp.gui;


import com.StudentManagementApp.model.Course;
import com.StudentManagementApp.model.Student;
import com.StudentManagementApp.data.DataManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CourseEnrollmentPanel extends JPanel {
    private JComboBox<Course> courseCombo = new JComboBox<>();
    private DefaultListModel<Student> listModel = new DefaultListModel<>();
    private JList<Student> studentList = new JList<>(listModel);

    public CourseEnrollmentPanel() {
        setLayout(new BorderLayout());

        // Course selection dropdown
        DataManager data = DataManager.getInstance();
        courseCombo.setModel(new DefaultComboBoxModel<>(data.getCourses().toArray(new Course[0])));
        courseCombo.addActionListener(e -> updateStudentList());
        add(courseCombo, BorderLayout.NORTH);

        // Eligible students list
        studentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(studentList), BorderLayout.CENTER);

        // Enroll button
        JButton enrollButton = new JButton("Enroll Student");
        enrollButton.addActionListener(e -> enrollStudent());
        add(enrollButton, BorderLayout.SOUTH);

        updateStudentList();
    }

    private void updateStudentList() {
        listModel.clear();
        Course selectedCourse = (Course) courseCombo.getSelectedItem();
        if (selectedCourse != null) {
            List<Student> eligibleStudents = DataManager.getInstance().getEligibleStudents(selectedCourse);
            eligibleStudents.forEach(listModel::addElement);
        }
    }

    private void enrollStudent() {
        Student selectedStudent = studentList.getSelectedValue();
        Course selectedCourse = (Course) courseCombo.getSelectedItem();

        if (selectedStudent == null || selectedCourse == null) {
            JOptionPane.showMessageDialog(this, "Select a course and student!");
            return;
        }

        DataManager.getInstance().enrollStudent(selectedStudent, selectedCourse);
        updateStudentList(); // Refresh the list after enrollment
        JOptionPane.showMessageDialog(this, "Enrollment successful!");
    }
}