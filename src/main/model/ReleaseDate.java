package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.Objects;

// Represents a release date with a year, month, day
public class ReleaseDate implements Writable {
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

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("year", year);
        json.put("month", month);
        json.put("day", day);
        return json;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        } else {
            ReleaseDate that = (ReleaseDate) o;
            return year == that.year && month == that.month && day == that.day;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}
