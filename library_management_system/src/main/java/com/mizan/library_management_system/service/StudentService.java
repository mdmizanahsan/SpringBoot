package com.mizan.library_management_system.service;

import com.mizan.library_management_system.model.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(Student student);

    List<Student> getAllStudents();

    Student updateStudent(Long id, Student updatedStudent);

    void deleteStudent(Long id);
}
