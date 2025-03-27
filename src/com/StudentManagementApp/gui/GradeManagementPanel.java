package com.StudentManagementApp.gui;


import com.StudentManagementApp.model.Enrollment;
import com.StudentManagementApp.model.Student;
import com.StudentManagementApp.data.DataManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class GradeManagementPanel extends JPanel {
    private JComboBox<Student> studentCombo = new JComboBox<>();
    private DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Course", "Grade"}, 0);
    private JTable enrollmentTable = new JTable(tableModel);
    private JTextField gradeField = new JTextField(5);

    public GradeManagementPanel() {
        setLayout(new BorderLayout());

        // Student selection dropdown
        DataManager data = DataManager.getInstance();
        studentCombo.setModel(new DefaultComboBoxModel<>(data.getStudents().toArray(new Student[0])));
        studentCombo.addActionListener(e -> updateEnrollmentTable());
        add(studentCombo, BorderLayout.NORTH);

        // Enrollment table
        add(new JScrollPane(enrollmentTable), BorderLayout.CENTER);

        // Grade input panel
        JPanel gradePanel = new JPanel();
        gradePanel.add(new JLabel("Grade:"));
        gradePanel.add(gradeField);

        JButton assignButton = new JButton("Assign Grade");
        assignButton.addActionListener(e -> assignGrade());
        gradePanel.add(assignButton);

        add(gradePanel, BorderLayout.SOUTH);

        updateEnrollmentTable();
    }

    private void updateEnrollmentTable() {
        tableModel.setRowCount(0);
        Student selectedStudent = (Student) studentCombo.getSelectedItem();

        if (selectedStudent != null) {
            List<Enrollment> enrollments = DataManager.getInstance().getEnrollmentsForStudent(selectedStudent);
            enrollments.forEach(e ->
                    tableModel.addRow(new Object[]{e.getCourse(), e.getGrade()})
            );
        }
    }

    private void assignGrade() {
        Student student = (Student) studentCombo.getSelectedItem();
        int selectedRow = enrollmentTable.getSelectedRow();
        String grade = gradeField.getText().trim();

        if (student == null || selectedRow == -1 || grade.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select a student/course and enter a grade!");
            return;
        }

        // Update grade in DataManager
        List<Enrollment> enrollments = DataManager.getInstance().getEnrollmentsForStudent(student);
        Enrollment selectedEnrollment = enrollments.get(selectedRow);
        selectedEnrollment.setGrade(grade);

        // Refresh UI
        updateEnrollmentTable();
        gradeField.setText("");
        JOptionPane.showMessageDialog(this, "Grade updated!");
    }
}