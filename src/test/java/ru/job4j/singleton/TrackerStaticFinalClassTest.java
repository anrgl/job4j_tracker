package ru.job4j.singleton;

import org.junit.Test;
import ru.job4j.tracker.Tracker;

import static org.junit.Assert.*;

public class TrackerStaticFinalClassTest {
    @Test
    public void whenTrackerSingleton() {
        Tracker trackerStaticFinalClass1 = TrackerStaticFinalClass.getInstance();
        Tracker trackerStaticFinalClass2 = TrackerStaticFinalClass.getInstance();
        assertEquals(trackerStaticFinalClass1, trackerStaticFinalClass2);
        assertNotNull(trackerStaticFinalClass1);
        assertNotNull(trackerStaticFinalClass2);
    }
}