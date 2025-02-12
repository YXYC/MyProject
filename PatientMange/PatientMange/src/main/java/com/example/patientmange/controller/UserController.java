package com.example.patientmange.controller;
import com.example.patientmange.entity.*;
import com.example.patientmange.utils.JwtCreate;
import com.example.patientmange.utils.Result;
import com.example.patientmange.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.patientmange.mapper.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired //自动注入mapper实例化对象
    private UserMapper userMapper;

    //根据用户名称和密码查询用户
    //即登录
    @PostMapping("/findUserByUsernamePass")
    public Result findUserByUsernamePass(@RequestBody User user){
        String username = user.getUsername();
        String password = user.getPassword();
        System.out.println(user.toString());
        Map<String,Object> map=new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        List<User> UserList = userMapper.selectByMap(map);
        if(!UserList.isEmpty()){
            String token = JwtCreate.generateToken(user.getUsername());//生成token
            System.out.println(token);
            System.out.println(JwtCreate.getClaimsByToken(token));
            return Result.ok().data("token",token);
        }else{
            return Result.error();
        }
    }

    //添加用户
    //即注册
    @PostMapping("/registerUser")
    public int registerUser(@RequestBody User user){
        System.out.println(1);
        return userMapper.insert(user);
    }

    //返回用户信息
    @GetMapping("/userspace/userinfo")
    public Result getUserInfo(){
        Map<String,Object> data = ThreadLocalUtil.get();
        String username = (String) data.get("sub");
        System.out.println(data);
        Map<String,Object> map=new HashMap<>();
        map.put("username",username);
        List<User> UserList = userMapper.selectByMap(map);
        if(UserList.size()!=0){
        UserList.get(0).setPassword("");//密码为隐私信息，不应传递到前端
        return Result.ok().data("userInfo",UserList.get(0));
        }
        else{
            return Result.error();
        }
    }
}
