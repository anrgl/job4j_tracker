package ru.job4j.singleton;

import ru.job4j.tracker.MemTracker;

public class TrackerStaticFinalClass {
    private TrackerStaticFinalClass() {
    }

    public static MemTracker getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final MemTracker INSTANCE = new MemTracker();
    }
}
