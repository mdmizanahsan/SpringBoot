package com.mizan.student.Service;


import com.mizan.student.Entity.Student;
import com.mizan.student.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // GET - GET all students
    public List<Student> getallStudents()
    {
        return (List<Student>) studentRepository.findAll();
    }

    //POST - add student

    public Student addStudent(Student student)
    {
        return studentRepository.save(student);
    }

    // PUT - updates

    public Student updateStudent(Student student , Long id)
    {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());

        return studentRepository.save(existingStudent);

    }

    public Student deleteStudent(Long id)
    {
       Optional<Student> student = studentRepository.findById(id);

          if(student.isPresent())
          {
              studentRepository.deleteById(id);
          }
        return null;
    }
}