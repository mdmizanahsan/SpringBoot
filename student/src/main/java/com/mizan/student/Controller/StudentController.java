package com.mizan.student.Controller;

import com.mizan.student.Entity.Student;
import com.mizan.student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // GET - fetch all student
     @GetMapping
    public List<Student> getallStudents()
    {
        return studentService.getallStudents();
    }

    @GetMapping("/cred")
    public List<String> getAllStudentCred()
    {
        List<Student> students = studentService.getallStudents();

        return students.stream()
                .map(s-> "Name: " +s.getName() + ",Email: " + s.getEmail())
                .toList();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student)
    {
        return studentService.addStudent(student);
    }

    // PUT - update
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id ,@RequestBody Student student)
    {
        return studentService.updateStudent(student, id);
    }

    @DeleteMapping("/{id}")
    public Student deleteStudent(@PathVariable Long id)
    {
        return studentService.deleteStudent(id);
    }
}
