package com.example.patientmange.controller;

import com.example.patientmange.entity.PhysiologicalMetric;
import com.example.patientmange.mapper.PhysiologicalMetricMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.patientmange.utils.DataGenerator;
import java.util.List;
import java.util.Map;

@RestController
public class PhyController {
    @Autowired //自动注入mapper实例化对象
    private PhysiologicalMetricMapper physiologicalMetricMapper;

    //根据用户id和随机生成数据
    @PostMapping("/utils/addPhy")
    public void addPhyUtils(@RequestBody Map map){
        DataGenerator dataGenerator = new DataGenerator();
        int id = (int) map.get("userID");
        String date = (String) map.get("PhyDate");
        List<PhysiologicalMetric> list  = DataGenerator.generateDailyMetrics(date,id);
        for(PhysiologicalMetric l:list){
            physiologicalMetricMapper.insert(l);
        }
    }
}
