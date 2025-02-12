package com.example.patientmange.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@TableName("physiological_metrics") // 指定实体类对应的数据库表名为 "physiological_metrics"
@Data
public class PhysiologicalMetric {
    @TableId
    private int id;
    @TableField("user_id")
    private int userID;
    @TableField("timestamp")
    private String timeSTAMP;
    @TableField("temperature")
    private int temperature;
    @TableField("heart_rate")
    private int heartRate;
    @TableField("blood_pressure_systolic")
    private int bloodPressureSys;
    @TableField("blood_pressure_diastolic")
    private int bloodPressureDias;
    @TableField("blood_oxygen_level")
    private double bloodOxygenLevel;
    @TableField("blood_glucose_level")
    private double bloodGlucoseLevel;
}
