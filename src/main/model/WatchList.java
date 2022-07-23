package model;

import java.util.ArrayList;

// Represents a list of Media (and its subclasses) with fields representing different categories of
public class WatchList {
    private ArrayList<Media> currentlyWatching;
    private ArrayList<Media> dropped;
    private ArrayList<Media> plannedToWatch;

    // EFFECTS: instantiates a WatchList object with fields initialized with empty ArrayLists
    public WatchList() {
        this.currentlyWatching = new ArrayList<>();
        this.dropped = new ArrayList<>();
        this.plannedToWatch = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: inserts the media to the currently watching list
    public void addCurrentlyWatching() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: inserts the media to the dropped shows watch list
    public void addDropped() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: inserts the media to the planned to watch list
    public void addMediaPlannedToWatch() {
        // stub
    }

    // EFFECTS: calculates the average rating across the currently watching list
    public int averageRatingCurrentlyWatching() {
        return 1;
    }

    // EFFECTS: calculates the average rating across the dropped shows watch list
    public int averageRatingDropped() {
        return 1;
    }

    // EFFECTS: calculates the average rating across the planned to watch list
    public int averageRatingPlannedToWatch() {
        return 1;
    }
}
