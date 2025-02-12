package com.example.patientmange.entity;

import java.time.LocalDateTime;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@Data
@TableName("medical_record") // 指定实体类对应的数据库表名为 "medical_record"
public class MedicalRecord {

    @TableId("record_id")
    @TableField("record_id")
    private int recordId;

    @TableField("userid")
    private int userid; // 用户ID

    @TableField("visit_date")
    private LocalDateTime visitDate; // 就诊时间

    @TableField("main_symptoms")
    private String mainSymptoms; // 主要症状

    @TableField("present_illness_history")
    private String presentIllnessHistory; // 现病史

    @TableField("past_history")
    private String pastHistory; // 既往史

    @TableField("family_history")
    private String familyHistory; // 家族史

    @TableField("personal_history")
    private String personalHistory; // 个人史

    @TableField("physical_examination")
    private String physicalExamination; // 体格检查

    @TableField("auxiliary_examination_results")
    private String auxiliaryExaminationResults; // 辅助检查结果

    @TableField("final_diagnosis")
    private String finalDiagnosis; // 最终诊断

    @TableField("treatment_plan")
    private String treatmentPlan; // 治疗方案

    @TableField("course_of_disease")
    private String courseOfDisease; // 病程记录

    @TableField("discharge_summary")
    private String dischargeSummary; // 出院小结
}
