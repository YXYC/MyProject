package com.example.patientmange.entity;

import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("Message") // 指定实体类对应的数据库表名为 "Message"
public class Message {
    @TableId("id")
    @TableField("id")
    private int id;
    @TableField("nickname")
    private String nickname; // 昵称
    @TableField("message")
    private String message; // 消息
    @TableField("date")
    private LocalDate date; // 日期
    @TableField("category")
    private String category; // 分类
}
