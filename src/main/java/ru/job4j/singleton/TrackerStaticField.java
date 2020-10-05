package ru.job4j.singleton;

import ru.job4j.tracker.Tracker;

public class TrackerStaticField {
    private static Tracker instance;

    private TrackerStaticField() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }
}
