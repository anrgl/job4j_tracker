package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            char chLeft = left.charAt(i);
            char chRight = right.charAt(i);
            if (chLeft != chRight) {
                return chLeft - chRight;
            }
        }
        return left.length() - right.length();
    }
}
