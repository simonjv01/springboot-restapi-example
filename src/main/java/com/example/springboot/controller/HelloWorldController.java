package com.example.springboot.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld() {

        return "Sophie's Soccer World! Welcome to the game!";
    }
}
