package com.example.patientmange.utils;

import com.example.patientmange.entity.SleepRecord;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;


import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static List<SleepRecord> readCSV(String filePath) {
        List<SleepRecord> sleepRecords = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            String[] values;
            csvReader.readNext(); // Skip header row
            while ((values = csvReader.readNext()) != null) {
                SleepRecord sleepRecord = new SleepRecord();
                sleepRecord.setDate(LocalDate.parse(values[0], DATE_FORMATTER));
                sleepRecord.setDeepSleepTime(Integer.parseInt(values[1]));
                sleepRecord.setShallowSleepTime(Integer.parseInt(values[2]));
                sleepRecord.setWakeTime(Integer.parseInt(values[3]));

                // Remove timezone information by splitting the string and taking the first part
                String startWithoutTimezone = values[4].substring(0, 19);
                String stopWithoutTimezone = values[5].substring(0, 19);

                sleepRecord.setStart(LocalDateTime.parse(startWithoutTimezone, DATETIME_FORMATTER));
                sleepRecord.setStop(LocalDateTime.parse(stopWithoutTimezone, DATETIME_FORMATTER));
                sleepRecord.setREMTime(Integer.parseInt(values[6]));
                sleepRecord.setNaps(values[7].isEmpty() ? null : values[7]);
                sleepRecord.setUserid(6);
                sleepRecords.add(sleepRecord);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        return sleepRecords;
    }

    public static void main(String[] args) {
        String path = "D:/1004178348_1718883521886/SLEEP/SLEEP_1718883520388.csv";
        System.out.println(readCSV(path));
    }
}
