package com.example.patientmange.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class RESTfulTestController {
    @GetMapping("/user/{id}")
    public String getUserById (@PathVariable int id){
        return "根据id获取用户信息";
    }

    @PostMapping("/user")
    public String save (Class user){
        return "添加用户";
    }

    @PutMapping("/user")
    public String update (Class user){
        return "更新用户";
    }

    @DeleteMapping("/user/{id}")
    public String deleteUserById (@PathVariable int id){
        return "根据id删除用户信息";
    }
}
