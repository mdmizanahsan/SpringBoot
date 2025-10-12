package com.mizan.student_management_system.service;

import com.mizan.student_management_system.model.Student;
import com.mizan.student_management_system.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
       return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Student Not Found with id: " + id));
    }

    @Override
    public Student updateStudent(Long id, Student student) {
      Student existing = getStudentById(id);
      existing.setName(student.getName());
      existing.setEmail(student.getEmail());
      existing.setCourse(student.getCourse());
      existing.setMarks(student.getMarks());
      return studentRepository.save(existing);
    }

    @Override
    public Void deleteStudent(Long id) {
       Student existing = getStudentById(id);
        studentRepository.delete(existing);

        return null;
    }
}
