package ru.job4j.singleton;

import org.junit.Test;
import ru.job4j.tracker.Tracker;

import static org.junit.Assert.*;

public class TrackerStaticFieldTest {
    @Test
    public void whenTrackerSingleton() {
        Tracker trackerStaticField1 = TrackerStaticField.getInstance();
        Tracker trackerStaticField2 = TrackerStaticField.getInstance();
        assertEquals(trackerStaticField1, trackerStaticField2);
        assertNotNull(trackerStaticField1);
        assertNotNull(trackerStaticField2);
    }
}