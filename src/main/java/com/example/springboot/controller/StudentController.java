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
        Student student = new Student(1, "Simon", "Vargas", "sbc@gmail.com", "1234567",
                "123 Main St", "Springfield", "IL", "62704", "USA"
        );
        return student;
    }

    @GetMapping("students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Simon", "Vargas","sjv@gmail.com","1234565",
                "123 Main St", "Springfield", "IL", "62704", "USA"));
        students.add(new Student(2, "John", "Doe","jdoe@gmail.com","9876543",
                "456 Elm St", "Springfield", "IL", "62704", "USA"));
        students.add(new Student(3, "Jane", "Smith","jsmith@yahoo.com","4567890",
                "789 Oak St", "Springfield", "IL", "62704", "USA"));
        students.add(new Student(4, "Mr", "Robot","mrobot@gmail.com", "1122334",
                "101 Pine St", "Springfield", "IL", "62704", "USA")
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
