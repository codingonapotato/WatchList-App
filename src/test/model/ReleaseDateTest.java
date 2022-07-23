package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReleaseDateTest {
    private ReleaseDate testReleaseDate;
    private int year = 2020;
    private int month = 4;
    private int day = 1;

    @BeforeEach
    public void setup() {
        testReleaseDate = new ReleaseDate(year, month,day);
    }

    @Test
    public void testConstructor() {
        assertEquals(day, testReleaseDate.getDay());
        assertEquals(month, testReleaseDate.getMonth());
        assertEquals(year, testReleaseDate.getYear());
    }
}
