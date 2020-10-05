package ru.job4j.singleton;

import org.junit.Test;
import ru.job4j.tracker.Tracker;

import static org.junit.Assert.*;

public class TrackerStaticFinalFieldTest {
    @Test
    public void whenTrackerSingleton() {
        Tracker trackerStaticFinalField1 = TrackerStaticFinalField.getInstance();
        Tracker trackerStaticFinalField2 = TrackerStaticFinalField.getInstance();
        assertEquals(trackerStaticFinalField1, trackerStaticFinalField2);
        assertNotNull(trackerStaticFinalField1);
        assertNotNull(trackerStaticFinalField2);
    }
}