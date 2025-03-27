package com.StudentManagementApp.gui;


import com.StudentManagementApp.model.Student;
import com.StudentManagementApp.data.DataManager;

import javax.swing.*;
import java.awt.*;

public class StudentDialog extends JDialog {
    private JTextField idField, nameField, emailField;
    private boolean success = false;

    public StudentDialog(Student student) {
        setTitle(student == null ? "Add Student" : "Edit Student");
        setModal(true);
        setLayout(new GridLayout(4, 2));

        idField = new JTextField();
        nameField = new JTextField();
        emailField = new JTextField();

        add(new JLabel("ID:"));
        add(idField);
        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Email:"));
        add(emailField);

        JButton save = new JButton("Save");
        save.addActionListener(e -> saveStudent(student));
        add(save);

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(e -> dispose());
        add(cancel);

        if (student != null) {
            idField.setText(student.getId());
            idField.setEditable(false);
            nameField.setText(student.getName());
            emailField.setText(student.getEmail());
        }

        pack();
        setLocationRelativeTo(null);
    }

    private void saveStudent(Student existing) {
        try {
            String id = idField.getText().trim();
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();

            if (id.isEmpty() || name.isEmpty() || email.isEmpty())
                throw new Exception("All fields required.");

            DataManager dm = DataManager.getInstance();
            if (existing == null) {
                dm.addStudent(new Student(id, name, email));
            } else {
                existing.setName(name);
                existing.setEmail(email);
            }
            success = true;
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean isSuccess() { return success; }
}