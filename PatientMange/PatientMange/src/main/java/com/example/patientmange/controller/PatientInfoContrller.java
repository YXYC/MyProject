package com.example.patientmange.controller;

import com.example.patientmange.entity.PatientInfo;
import com.example.patientmange.entity.User;
import com.example.patientmange.mapper.PatientInfoMapper;
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
public class PatientInfoContrller {
    @Autowired //自动注入mapper实例化对象
    private PatientInfoMapper patientInfoMapper;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/getAllInfo")
    public Result getAllInfo(){
        System.out.println(1111113242);
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
            List<PatientInfo> patientInfos;
            patientInfos = patientInfoMapper.selectByMap(map);
            return Result.ok().data("userInfo",patientInfos);
        }
        else{
            return Result.error();
        }
    }
}
