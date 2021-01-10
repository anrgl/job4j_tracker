package ru.job4j.singleton;

import org.junit.Test;
import ru.job4j.tracker.MemTracker;

import static org.junit.Assert.*;

public class MemTrackerEnumTest {
    @Test
    public void whenTrackerEnumSingleton() {
        MemTracker memTrackerEnum1 = TrackerEnum.INSTANCE.getInstance();
        MemTracker memTrackerEnum2 = TrackerEnum.INSTANCE.getInstance();
        assertEquals(memTrackerEnum1, memTrackerEnum2);
        assertNotNull(memTrackerEnum1);
        assertNotNull(memTrackerEnum2);
    }
}
