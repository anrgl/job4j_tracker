package ru.job4j.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.MemTracker;

public class TrackerStaticFinalField {
    private static final MemTracker INSTANCE = new MemTracker();

    private TrackerStaticFinalField() {
    }

    public static MemTracker getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }
}
