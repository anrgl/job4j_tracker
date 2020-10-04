package ru.job4j.singleton;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackerStaticFinalFieldTest {
    @Test
    public void whenTrackerSingleton() {
        TrackerStaticFinalField trackerStaticFinalField1 = TrackerStaticFinalField.getInstance();
        TrackerStaticFinalField trackerStaticFinalField2 = TrackerStaticFinalField.getInstance();
        assertEquals(trackerStaticFinalField1, trackerStaticFinalField2);
        assertNotNull(trackerStaticFinalField1);
        assertNotNull(trackerStaticFinalField2);
    }
}