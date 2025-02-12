package com.example.patientmange.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;

@Data
@TableName("plan") // 指定实体类对应的数据库表名为 "plan"
public class Plan {
    @TableId("id")
    private int id;
    @TableField("userid")
    private int userid;
    @TableField("plandate")
    private LocalDate plandate;
    @TableField("plans")
    private String plans;
}
