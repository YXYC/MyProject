package com.example.patientmange.utils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

//统一返回结果的类
@Data
public class Result {
    private Boolean success;//请求是否成功
    private Integer code;//状态码
    private String message;
    private Map<String,Object> data = new HashMap<>();

    //成功静态方法
    public static Result ok(){
        Result r =new Result();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }

    //失败静态方法
    public static Result error(){
        Result r =new Result();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("失败");
        return r;
    }

    public Result data(String key,Object value){
        this.data.put(key, value);
        return this;
    }

    public Result data(Map<String,Object> map){
        this.setData(map);
        return this;
    }
}
