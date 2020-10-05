package ru.job4j.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class TrackerStaticFinalField {
    private static final Tracker INSTANCE = new Tracker();

    private TrackerStaticFinalField() {
    }

    public static Tracker getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }
}
