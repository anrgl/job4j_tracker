package ru.job4j.singleton;

public class TrackerStaticField {
    private static TrackerStaticField instance;

    private TrackerStaticField() {
    }

    public static TrackerStaticField getInstance() {
        if (instance == null) {
            instance = new TrackerStaticField();
        }
        return instance;
    }
}
