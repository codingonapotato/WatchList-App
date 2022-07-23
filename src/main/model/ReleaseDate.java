package model;

// Represents a release date with a year, month, day
public class ReleaseDate {
    private int year;
    private int month;
    private int day;
    private static final int PRESENT_YEAR = 2022;

    // REQUIRES: year is [1700, PRESENT_YEAR], month is [1, 12], day is [1, 31]
    // EFFECTS: Instantiates a ReleaseDate object with a year, month and day
    public ReleaseDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

}
