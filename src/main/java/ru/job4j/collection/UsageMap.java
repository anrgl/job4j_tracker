package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        map.put("galimovaynur@yandex.ru", "Aynur Galimov");
        map.put("ivanivanov@yandex.ru", "Ivan Ivanov");
        map.put("oleggrach@yandex.ru", "Oleg Grach");
        map.put("irina@yandex.ru", "Prosto Irina");

        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
