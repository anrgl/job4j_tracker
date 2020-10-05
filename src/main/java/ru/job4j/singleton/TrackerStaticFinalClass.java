package ru.job4j.singleton;

import ru.job4j.tracker.Tracker;

public class TrackerStaticFinalClass {
    private TrackerStaticFinalClass() {
    }

    public static Tracker getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final Tracker INSTANCE = new Tracker();
    }
}
