package com.example.patientmange.entity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@TableName("users") // 指定实体类对应的数据库表名为 "users"
@Data
public class User {
    @TableId("id")
    @TableField("id")
    private String id;
    @TableField("username")
    private String username;
    private String password;//隐私信息，生成Json信息时不应该返回
    private String phone;
    @TableField("registerTime")
    private LocalDateTime registerTime; // 使用LocalDateTime来表示注册时间
    @TableField("avatarUrl")
    private String avatarUrl;
    private LocalDate birthday; // 使用LocalDate来表示生日
    private String nickname;
}
