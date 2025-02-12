package com.example.patientmange.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.patientmange.entity.SleepRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SleepMapper extends BaseMapper<SleepRecord> {
}
