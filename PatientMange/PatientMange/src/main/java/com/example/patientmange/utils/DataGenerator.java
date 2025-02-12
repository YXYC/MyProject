package com.example.patientmange.utils;

import com.example.patientmange.entity.PhysiologicalMetric;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataGenerator {

    public static List<PhysiologicalMetric> generateDailyMetrics(String dateStr, int userId) {
        List<PhysiologicalMetric> metricsList = new ArrayList<>();
        LocalDate date = LocalDate.parse(dateStr);
        Random random = new Random();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        for (int hour = 0; hour < 24; hour++) {
            LocalDateTime timestamp = LocalDateTime.of(date, LocalTime.of(hour, 0));

            PhysiologicalMetric metric = new PhysiologicalMetric();
            metric.setUserID(userId);
            metric.setTimeSTAMP(timestamp.format(formatter));
            metric.setTemperature((int) (36.0 + (38.0 - 36.0) * random.nextDouble()));
            metric.setHeartRate(60 + random.nextInt(41)); // 60 to 100
            metric.setBloodPressureSys(90 + random.nextInt(51)); // 90 to 140
            metric.setBloodPressureDias(60 + random.nextInt(31)); // 60 to 90
            metric.setBloodOxygenLevel(95.0 + (100.0 - 95.0) * random.nextDouble());
            metric.setBloodGlucoseLevel(70.0 + (140.0 - 70.0) * random.nextDouble());
            metricsList.add(metric);
        }

        return metricsList;
    }

    public static void main(String[] args) {
        DataGenerator generator = new DataGenerator();
        List<PhysiologicalMetric> metrics = generator.generateDailyMetrics("2024-06-19", 1);

        for (PhysiologicalMetric metric : metrics) {
            System.out.println(metric.toString());
        }
    }
}
