package ru.job4j.singleton;

import ru.job4j.tracker.Item;

public class TrackerStaticFinalField {
    private static final TrackerStaticFinalField INSTANCE = new TrackerStaticFinalField();

    private TrackerStaticFinalField() {
    }

    public static TrackerStaticFinalField getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }
}
