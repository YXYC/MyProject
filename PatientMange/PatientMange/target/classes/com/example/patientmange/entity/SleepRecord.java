package com.example.patientmange.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@TableName("sleepRecords") // 指定实体类对应的数据库表名为 "sleepRecords"
public class SleepRecord {
    @TableId("id")
    @TableField("id")
    private int id;

    @TableField("userid")
    private int userid; // 用户账号名称

    @TableField("date")
    private LocalDate date; // 日期

    @TableField("deepSleepTime")
    private int deepSleepTime; // 深度睡眠时间

    @TableField("shallowSleepTime")
    private int shallowSleepTime; // 浅睡眠时间

    @TableField("wakeTime")
    private int wakeTime; // 清醒时间

    @TableField("start")
    private LocalDateTime start; // 开始时间

    @TableField("stop")
    private LocalDateTime stop; // 结束时间

    @TableField("REMTime")
    private int REMTime; // 快速眼动睡眠时间

    @TableField("naps")
    private String naps; // 小睡时间 (JSON 格式字符串)
}
