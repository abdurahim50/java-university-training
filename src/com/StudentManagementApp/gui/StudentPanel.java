package com.StudentManagementApp.gui;

import com.StudentManagementApp.model.Student;
import com.StudentManagementApp.data.DataManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StudentPanel extends JPanel {
    private DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "Name", "Email"}, 0);
    private JTable table = new JTable(model);

    public StudentPanel() {
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel buttons = new JPanel();
        JButton add = new JButton("Add");
        JButton update = new JButton("Update");

        add.addActionListener(e -> showStudentDialog(null));
        update.addActionListener(e -> updateStudent());

        buttons.add(add);
        buttons.add(update);
        add(buttons, BorderLayout.SOUTH);

        refresh();
    }

    private void showStudentDialog(Student student) {
        StudentDialog dialog = new StudentDialog(student);
        dialog.setVisible(true);
        if (dialog.isSuccess()) refresh();
    }

    private void updateStudent() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a student.");
            return;
        }
        String id = (String) model.getValueAt(row, 0);
        Student student = DataManager.getInstance().getStudents().stream()
                .filter(s -> s.getId().equals(id))
                .findFirst().orElse(null);
        if (student != null) showStudentDialog(student);
    }

    private void refresh() {
        model.setRowCount(0);
        DataManager.getInstance().getStudents().forEach(s ->
                model.addRow(new Object[]{s.getId(), s.getName(), s.getEmail()})
        );
    }
}