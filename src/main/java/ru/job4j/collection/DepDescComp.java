package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] left = o1.split("/");
        String[] right = o2.split("/");
        int min = Math.min(left.length, right.length);
        for (int i = 0; i < min; i++) {
            String depLeft = left[i];
            String depRight = right[i];
            if (depLeft.compareTo(depRight) != 0) {
                return depLeft.compareTo(depRight);
            }
        }
        return left.length - right.length;
    }
}
