package com.example.patientmange.controller;

import com.example.patientmange.entity.Message;
import com.example.patientmange.mapper.MessgeMapper;
import com.example.patientmange.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class MessgeController {
    @Autowired
    MessgeMapper messageMapper;

    @GetMapping("/getAllMessage")
    public Result getAllMessage(){
        return Result.ok().data("Message",messageMapper.selectList(null));
    }

    @PostMapping("/insertMessage")
    public Result insertMessage(@RequestBody Message message){
        // 获取今天的日期
        LocalDate today = LocalDate.now();
        message.setDate(today);
        messageMapper.insert(message);
        return Result.ok();
    }
}
