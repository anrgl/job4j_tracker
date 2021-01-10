package ru.job4j.singleton;

import org.junit.Test;
import ru.job4j.tracker.MemTracker;

import static org.junit.Assert.*;

public class MemTrackerStaticFieldTest {
    @Test
    public void whenTrackerSingleton() {
        MemTracker memTrackerStaticField1 = TrackerStaticField.getInstance();
        MemTracker memTrackerStaticField2 = TrackerStaticField.getInstance();
        assertEquals(memTrackerStaticField1, memTrackerStaticField2);
        assertNotNull(memTrackerStaticField1);
        assertNotNull(memTrackerStaticField2);
    }
}