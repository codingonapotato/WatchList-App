package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReleaseDateTest {
    private ReleaseDate testReleaseDate;
    private ReleaseDate testReleaseDate2;
    private ReleaseDate testReleaseDate3;
    private int year = 2020;
    private int month = 4;
    private int day = 1;

    @BeforeEach
    public void setup() {
        testReleaseDate = new ReleaseDate(year, month,day);
        testReleaseDate2 = new ReleaseDate(year, month,day);
        testReleaseDate3 = new ReleaseDate(2009, 9, 27);
    }

    @Test
    public void testConstructor() {
        assertEquals(day, testReleaseDate.getDay());
        assertEquals(month, testReleaseDate.getMonth());
        assertEquals(year, testReleaseDate.getYear());
    }

    @Test
    public void testEquals() {
        assertFalse(testReleaseDate.equals(null));
        assertFalse(testReleaseDate.equals(year));
        assertTrue(testReleaseDate.equals(testReleaseDate2)); // every field same
        assertFalse(testReleaseDate.equals(testReleaseDate3));
        testReleaseDate2.setYear(2000);
        assertFalse(testReleaseDate.equals(testReleaseDate2)); // only year diff
        testReleaseDate2.setYear(2020);
        testReleaseDate2.setMonth(5);
        assertFalse(testReleaseDate.equals(testReleaseDate2)); // only month diff
        testReleaseDate2.setMonth(4);
        testReleaseDate2.setDay(20);
        assertFalse(testReleaseDate.equals(testReleaseDate2)); // only day diff
        assertTrue(testReleaseDate.equals(testReleaseDate));
        assertFalse(testReleaseDate.equals(testReleaseDate2));
    }
}
