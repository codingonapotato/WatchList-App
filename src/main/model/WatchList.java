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
    public void addCurrentlyWatching(Media media) {
        currentlyWatching.add(media);
    }

    // MODIFIES: this
    // EFFECTS: inserts the media to the dropped shows watch list
    public void addDropped(Media media) {
        dropped.add(media);
    }

    // MODIFIES: this
    // EFFECTS: inserts the media to the planned to watch list
    public void addPlannedToWatch(Media media) {
        plannedToWatch.add(media);
    }

    // EFFECTS: calculates the average rating across the currently watching list
    public double averageRatingCurrentlyWatching() {
        int count = 0;
        double rsf = 0; // results-so-far
        for (Media m : currentlyWatching) {
            rsf += m.getRating();
            count++;
        }
        return (rsf / count);
    }

    // EFFECTS: calculates the average rating across the dropped shows watch list
    public double averageRatingDropped() {
        int count = 0;
        double rsf = 0; // results-so-far
        for (Media m : dropped) {
            rsf += m.getRating();
            count++;
        }
        return (rsf / count);
    }

    // EFFECTS: calculates the average rating across the planned to watch list
    public double averageRatingPlannedToWatch() {
        int count = 0;
        double rsf = 0; // results-so-far
        for (Media m : plannedToWatch) {
            rsf += m.getRating();
            count++;
        }
        return (rsf / count);
    }

    // EFFECTS: returns the currently watching list
    public ArrayList<Media> getCurrentlyWatching() {
        return currentlyWatching;
    }

    // EFFECTS: returns the dropped list
    public ArrayList<Media> getDropped() {
        return dropped;
    }

    // EFFECTS: returns the planned to watch list
    public ArrayList<Media> getPlannedToWatch() {
        return plannedToWatch;
    }
}
