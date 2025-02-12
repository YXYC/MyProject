package com.example.patientmange.utils;

import com.example.patientmange.entity.Plan;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;


public class PlanUtil {

    private static final Gson gson = new GsonBuilder().create();

    public static Plan parseStringToPlan(String input) {
        // 去掉开头和结尾的花括号
        String trimmedInput = input.substring(1, input.length() - 1).trim();
        String[] pairs = trimmedInput.split(", (?![^{}]*\\})"); // 匹配逗号，但不匹配大括号内的逗号

        Map<String, String> map = new HashMap<>();
        for (String pair : pairs) {
            String[] keyValue = pair.split("=", 2);
            map.put(keyValue[0].trim(), keyValue[1].trim());
        }

        Plan plan = new Plan();
        plan.setId(Integer.parseInt(map.get("id")));
        plan.setUserid(Integer.parseInt(map.get("userid")));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        plan.setPlandate(LocalDate.parse(map.get("plandate"), formatter));

        // 使用 Gson 将 plans 字段内容转换为 JSON 字符串
        String plansContent = map.get("plans");
        plan.setPlans(plansContent);

        return plan;
    }

    public static void main(String[] args) {
        String input = "{id=0, userid=6, plandate=2024-06-17, plans={content=学习新的软件工程技能, completed=false, remark=请详细记录}}";
        Plan plan = parseStringToPlan(input);
        System.out.println(plan);
    }
}
