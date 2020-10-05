package ru.job4j.singleton;

import org.junit.Test;
import ru.job4j.tracker.Tracker;

import static org.junit.Assert.*;

public class TrackerEnumTest {
    @Test
    public void whenTrackerEnumSingleton() {
        Tracker trackerEnum1 = TrackerEnum.INSTANCE.getInstance();
        Tracker trackerEnum2 = TrackerEnum.INSTANCE.getInstance();
        assertEquals(trackerEnum1, trackerEnum2);
        assertNotNull(trackerEnum1);
        assertNotNull(trackerEnum2);
    }
}
