package ru.job4j.singleton;

import ru.job4j.tracker.Tracker;

public enum TrackerEnum {
    INSTANCE;
    private Tracker instance = new Tracker();

    public Tracker getInstance() {
        return instance;
    }
}
