package com.example.patientmange.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.patientmange.entity.PatientInfo;
import com.example.patientmange.entity.Plan;
import com.example.patientmange.entity.User;
import com.example.patientmange.mapper.PlanMapper;
import com.example.patientmange.mapper.UserMapper;
import com.example.patientmange.utils.PlanUtil;
import com.example.patientmange.utils.Result;
import com.example.patientmange.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PlanController {
    @Autowired
    PlanMapper planMapper;
    @Autowired
    UserMapper userMapper;
    @PostMapping("/getUserFlagBydate")
    public Result getUserFlagByDate(@RequestBody Map<String,Object> toMap){
//        System.out.println("前端发来数据："+toMap);
        String dateTime = (String) toMap.get("param");
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
            map.put("plandate",dateTime);
            List<Plan> plans;
            plans = planMapper.selectByMap(map);
            return Result.ok().data("plans",plans);
        }
        else{
            return Result.error();
        }
    }

    @PostMapping("/AddFlag")
    public Result AddFlg(@RequestBody Map<String,Object> toMap) {
        System.out.println("前端发来数据：" + toMap.get("param"));
        System.out.println("前端发来数据：" + toMap);

        Map<String,Object> paramJson = (Map<String, Object>) toMap.get("param"); // 假设前端传来的 JSON 数据在 "param" 字段中
        System.out.println(paramJson.get("plans"));
        int UserId = Integer.parseInt((String) paramJson.get("userid"));// 将Map对象转换为JSON字符串
        String jsonString = JSONObject.toJSONString(paramJson.get("plans"));
        System.out.println(paramJson.get("plandate"));
        System.out.println(jsonString);
        LocalDate localDate = LocalDate.parse((String)paramJson.get("plandate"));
        Plan plan = new Plan();
        plan.setUserid(UserId);
        plan.setPlandate(localDate);
        plan.setPlans(jsonString);
        planMapper.insert(plan);
        return Result.ok(); // 返回操作成功的结果
    }
}
