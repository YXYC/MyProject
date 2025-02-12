package com.example.patientmange.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.patientmange.entity.MedicalRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MediMapper extends BaseMapper<MedicalRecord> {
}
