package com.example.spring_boot_aop.controllers;

import com.example.spring_boot_aop.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greeting")
    public ResponseEntity<?> greeting() {
        return ResponseEntity.ok(Collections.singletonMap("greeting",
                greetingService.sayHello("Carol", "Hola, qué tal")));
    }

    @GetMapping("/greeting-error")
    public ResponseEntity<?> greetingError() {
        return ResponseEntity.ok(Collections.singletonMap("greeting",
                greetingService.sayHelloError("Carol", "Hola, qué tal")));
    }
}
