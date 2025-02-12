package com.example.patientmange.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;

@Data
@TableName("PatientInfo") // 指定实体类对应的数据库表名为 "users"
public class PatientInfo {
    @TableId("id")
    @TableField("id")
    private int id;
    @TableField("userid")
    private int userid; //用户账号名称
    @TableField("date")
    private LocalDate date; //日期
    @TableField("steps")
    private int steps; //步数
    @TableField("distance")
    private double distance; //距离/米
    @TableField("runDistance")
    private double runDistance; //跑步距离
    @TableField("calories")
    private int calories; //消耗卡路里
}
