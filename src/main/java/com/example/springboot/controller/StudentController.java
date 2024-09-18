package com.example.springboot.controller;

import com.example.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("student")
    public Student getStudent() {
        Student student = new Student(1, "Simon", "Vargas"
        );
        return student;
    }

    @GetMapping("students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Simon", "Vargas"));
        students.add(new Student(2, "John", "Doe"));
        students.add(new Student(3, "Jane", "Smith"));
        students.add(new Student(4, "Mr", "Robot")
        );
        return students;

    }
}
