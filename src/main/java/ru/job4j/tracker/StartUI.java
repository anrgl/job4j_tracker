package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        Item item1 = new Item();
        String currentDateTimeFormat = formatter.format(item1.getCreated());
        System.out.println(currentDateTimeFormat);
    }
}
