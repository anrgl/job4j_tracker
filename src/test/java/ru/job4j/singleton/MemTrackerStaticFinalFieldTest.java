package ru.job4j.singleton;

import org.junit.Test;
import ru.job4j.tracker.MemTracker;

import static org.junit.Assert.*;

public class MemTrackerStaticFinalFieldTest {
    @Test
    public void whenTrackerSingleton() {
        MemTracker memTrackerStaticFinalField1 = TrackerStaticFinalField.getInstance();
        MemTracker memTrackerStaticFinalField2 = TrackerStaticFinalField.getInstance();
        assertEquals(memTrackerStaticFinalField1, memTrackerStaticFinalField2);
        assertNotNull(memTrackerStaticFinalField1);
        assertNotNull(memTrackerStaticFinalField2);
    }
}