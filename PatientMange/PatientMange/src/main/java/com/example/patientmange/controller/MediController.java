package com.example.patientmange.controller;

import com.example.patientmange.entity.MedicalRecord;
import com.example.patientmange.entity.PatientInfo;
import com.example.patientmange.entity.User;
import com.example.patientmange.mapper.MediMapper;
import com.example.patientmange.mapper.UserMapper;
import com.example.patientmange.utils.Result;
import com.example.patientmange.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MediController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    MediMapper mediMapper;

    @GetMapping("/getMeiRecord")
    public Result getMeiRecord(){
        Map<String,Object> data = ThreadLocalUtil.get();
        String username = (String) data.get("sub");
        System.out.println(data);
        Map<String,Object> map=new HashMap<>();
        map.put("username",username);
        List<User> UserList = userMapper.selectByMap(map);
        if(!UserList.isEmpty()){
            String userid = UserList.get(0).getId();//密码为隐私信息，不应传递到前端
            map.clear();
            map.put("userid",userid);
            List<MedicalRecord> medicalRecords;
            medicalRecords = mediMapper.selectByMap(map);
            return Result.ok().data("MediData",medicalRecords);
        }
        else{
            return Result.error();
        }
    }
}
