package ru.job4j.tracker;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class HbmTrackerRun {
    public static void main(String[] args) {
        HbmTracker tracker = new HbmTracker();
        tracker.add(new Item(
                "Item #12",
                "Desc of Item #12",
                new Timestamp(new Date().getTime())));
        List<Item> items = tracker.findAll();
        for (var item : items) {
            System.out.println(item.getName());
        }
        Item item1 = tracker.findById(5);
        Item newItem = new Item(
                "Item #42",
                "Desc of Item #42",
                new Timestamp(new Date().getTime()));
        System.out.println(item1.getName());
        tracker.replace(5, newItem);
        System.out.println(tracker.findById(5).getName());
    }
}
