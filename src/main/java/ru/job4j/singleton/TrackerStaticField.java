package ru.job4j.singleton;

import ru.job4j.tracker.MemTracker;

public class TrackerStaticField {
    private static MemTracker instance;

    private TrackerStaticField() {
    }

    public static MemTracker getInstance() {
        if (instance == null) {
            instance = new MemTracker();
        }
        return instance;
    }
}
