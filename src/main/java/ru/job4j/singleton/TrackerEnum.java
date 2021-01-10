package ru.job4j.singleton;

import ru.job4j.tracker.MemTracker;

public enum TrackerEnum {
    INSTANCE;
    private MemTracker instance = new MemTracker();

    public MemTracker getInstance() {
        return instance;
    }
}
