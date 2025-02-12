package com.example.patientmange.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping ("/hello")
    public String hello(){
        return "emo";
    }

    @GetMapping("/hell")
    public String hello2(){
        return "你好";
    }
}
