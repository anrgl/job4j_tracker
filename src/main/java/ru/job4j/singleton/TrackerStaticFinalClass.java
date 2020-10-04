package ru.job4j.singleton;

public class TrackerStaticFinalClass {
    private TrackerStaticFinalClass() {
    }

    public static TrackerStaticFinalClass getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerStaticFinalClass INSTANCE = new TrackerStaticFinalClass();
    }
}
