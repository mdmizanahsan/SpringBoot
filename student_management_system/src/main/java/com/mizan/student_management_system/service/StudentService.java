package com.mizan.student_management_system.service;


import com.mizan.student_management_system.model.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);

    List<Student> getAllStudent();

    Student getStudentById(Long id);

    Student updateStudent(Long id, Student student);

    Void deleteStudent(Long id);
}
