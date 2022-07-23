package model;

// Represents a release date with a year, month, day
public class ReleaseDate {
    private int year;
    private int month;
    private int day;

    // REQUIRES: year >= 1700, month is [1, 12], day is [1, 31]
    // EFFECTS: instantiates a ReleaseDate object with a year, month and day
    public ReleaseDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // EFFECTS: returns the year
    public int getYear() {
        return this.year;
    }

    // EFFECTS: returns the month
    public int getMonth() {
        return this.month;
    }

    // EFFECTS: returns the day
    public int getDay() {
        return this.day;
    }

}
