package ru.job4j.condition;

public class WeeklySalary {
    public static int calculate(int[] hours) {
        int sum = 0;
        for (int i = 0; i < hours.length; i++) {
            if (i == 5 || i == 6) {
                if (hours[i] > 8) {
                    sum += 160 + (hours[i] - 8) * 2 * 15;
                } else if (hours[i] > 0) {
                    sum += hours[i] * 20;
                }
            } else {
                if (hours[i] > 8) {
                    sum +=  80 + (hours[i] - 8) * 15;
                } else if (hours[i] > 0) {
                    sum += hours[i] * 10;
                }
            }
        }
        return sum;
    }
}
