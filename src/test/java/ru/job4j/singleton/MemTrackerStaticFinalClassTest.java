package ru.job4j.singleton;

import org.junit.Test;
import ru.job4j.tracker.MemTracker;

import static org.junit.Assert.*;

public class MemTrackerStaticFinalClassTest {
    @Test
    public void whenTrackerSingleton() {
        MemTracker memTrackerStaticFinalClass1 = TrackerStaticFinalClass.getInstance();
        MemTracker memTrackerStaticFinalClass2 = TrackerStaticFinalClass.getInstance();
        assertEquals(memTrackerStaticFinalClass1, memTrackerStaticFinalClass2);
        assertNotNull(memTrackerStaticFinalClass1);
        assertNotNull(memTrackerStaticFinalClass2);
    }
}