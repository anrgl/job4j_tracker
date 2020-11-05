package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        }

        char[] lChars = left.toCharArray();
        char[] rChars = right.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : lChars) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            }
            map.putIfAbsent(ch, 1);
        }

        for (char ch : rChars) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    map.remove(ch);
                }
            }
        }

        return map.size() == 0;
    }
}
