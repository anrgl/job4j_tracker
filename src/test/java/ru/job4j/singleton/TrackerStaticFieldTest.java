package ru.job4j.singleton;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackerStaticFieldTest {
    @Test
    public void whenTrackerSingleton() {
        TrackerStaticField trackerStaticField1 = TrackerStaticField.getInstance();
        TrackerStaticField trackerStaticField2 = TrackerStaticField.getInstance();
        assertEquals(trackerStaticField1, trackerStaticField2);
        assertNotNull(trackerStaticField1);
        assertNotNull(trackerStaticField2);
    }
}