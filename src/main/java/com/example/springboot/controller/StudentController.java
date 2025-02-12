package com.example.springboot.controller;

import com.example.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

    // Spring BOOT REST API with Path Variable
    // {id} - URI template variable
    // http://localhost:8080/students/1
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);

    }

    // Spring boot REST API with Request param
    // http://localhost:8080/students/query?id=1&firsName=John&lastName=Doe
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName) {
        return new Student(id, firstName, lastName);
    }
}
