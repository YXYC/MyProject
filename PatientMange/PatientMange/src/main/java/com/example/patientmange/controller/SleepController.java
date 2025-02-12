package com.example.patientmange.controller;

import com.example.patientmange.entity.SleepRecord;
import com.example.patientmange.mapper.SleepMapper;
import com.example.patientmange.mapper.UserMapper;
import com.example.patientmange.utils.CSVUtils;
import com.example.patientmange.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SleepController {
    @Autowired //自动注入mapper实例化对象
    private SleepMapper sleepMapper;

    //添加睡眠记录
    @GetMapping("/addSleep")
    public Result addSleep(){
        List<SleepRecord> sleepRecords = CSVUtils.readCSV("D:/1004178348_1718883521886/SLEEP/SLEEP_1718883520388.csv");
        for(SleepRecord s:sleepRecords) {
            sleepMapper.insert(s);
        }
        return Result.ok();
    }
}
