package ru.job4j.singleton;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackerStaticFinalClassTest {
    @Test
    public void whenTrackerSingleton() {
        TrackerStaticFinalClass trackerStaticFinalClass1 = TrackerStaticFinalClass.getInstance();
        TrackerStaticFinalClass trackerStaticFinalClass2 = TrackerStaticFinalClass.getInstance();
        assertEquals(trackerStaticFinalClass1, trackerStaticFinalClass2);
        assertNotNull(trackerStaticFinalClass1);
        assertNotNull(trackerStaticFinalClass2);
    }
}