package com.codeweasel;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDamerauLevenshtein {
    @Test
    public void testCalculateDistance() {
        assertEquals(4, DamerauLevenshtein.calculateDistance("", "test"));
        assertEquals(4, DamerauLevenshtein.calculateDistance("test", ""));
        assertEquals(0, DamerauLevenshtein.calculateDistance("", ""));
        assertEquals(0, DamerauLevenshtein.calculateDistance(" ", " "));
        assertEquals(1, DamerauLevenshtein.calculateDistance("", " "));
        assertEquals(1, DamerauLevenshtein.calculateDistance(" ", ""));
        assertEquals(0, DamerauLevenshtein.calculateDistance("test", "test"));
        assertEquals(1, DamerauLevenshtein.calculateDistance("Test", "test"));
        assertEquals(1, DamerauLevenshtein.calculateDistance("test", "testy"));
        assertEquals(1, DamerauLevenshtein.calculateDistance("testy", "test"));
        assertEquals(3, DamerauLevenshtein.calculateDistance("test", "testing"));
        assertEquals(1, DamerauLevenshtein.calculateDistance("test", "tets"));
        assertEquals(2, DamerauLevenshtein.calculateDistance("test", "tsety"));
        assertEquals(3, DamerauLevenshtein.calculateDistance("Test", "tsety"));
        assertEquals(1, DamerauLevenshtein.calculateDistance("test", "test "));
        assertEquals(4, DamerauLevenshtein.calculateDistance("file", "test"));
        assertEquals(5, DamerauLevenshtein.calculateDistance("file", "testy"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSourceNull() {
        DamerauLevenshtein.calculateDistance(null, "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTargetNull() {
        DamerauLevenshtein.calculateDistance("", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSourceAndTargetNull() {
        DamerauLevenshtein.calculateDistance(null, null);
    }
}
