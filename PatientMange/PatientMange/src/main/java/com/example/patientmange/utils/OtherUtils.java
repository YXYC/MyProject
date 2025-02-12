package com.example.patientmange.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class OtherUtils {

    public static int getrandom(int MIN, int MAX) {
        Random random = new Random();
        return random.nextInt(MAX - MIN + 1) + MIN;
    }

    public static double getrandomDouble(double MIN, double MAX) {
        Random rand = new Random();
        double result = MIN + (rand.nextDouble() * (MAX - MIN));
        result = (double) Math.round(result * 10) / 10;
        return result;
    }

    public static List<Integer> getWeight(int num, int max, int min) {
        List<Integer> result = new ArrayList<Integer>();
        if (num == 1) {
            result.add(max);
            return result;
        } else {
            int num1 = getrandom(min, (max / num + 1));
            result.add(num1);
            int total = max;
            for (int i = 1; i < num; i++) {
                total = total - num1;
                while (total < min) {
                    int maxc = Collections.max(result);
                    result.set(result.indexOf(maxc), min);
                    int s = result.stream().map(e -> e).reduce(Integer::sum).get();
                    total = max - s;
                }
                if (i != num - 1) {
                    num1 = getrandom(min, total);
                    result.add(num1);
                } else {
                    result.add(total);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getWeight(18,8812,123));
    }
}
