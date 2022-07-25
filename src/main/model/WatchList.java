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

    // REQUIRES: each media object in the watch list is unique
    // MODIFIES: this
    // EFFECTS: inserts the media to the currently watching list and returns true, otherwise do nothing and return false
    public boolean addCurrentlyWatching(Media media) {
        if (!currentlyWatching.contains(media)) {
            currentlyWatching.add(media);
            return true;
        } else {
            return false;
        }
    }

    // REQUIRES: each media object in the watch list is unique
    // MODIFIES: this
    // EFFECTS: inserts the media to the dropped shows watch list and returns true, false otherwise
    public boolean addDropped(Media media) {
        if (!dropped.contains(media)) {
            dropped.add(media);
            return true;
        } else {
            return false;
        }
    }

    // REQUIRES: each media object in the watch list is unique
    // MODIFIES: this
    // EFFECTS: inserts the media to the planned to watch list and returns true, false otherwise
    public boolean addPlannedToWatch(Media media) {
        if (!plannedToWatch.contains(media)) {
            plannedToWatch.add(media);
            return true;
        } else {
            return false;
        }
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

    // REQUIRES: title.length() > 0 and currentlyWatching.size() >= 0
    // EFFECTS: returns the media from the currently watching list with a matching title,
    // otherwise instantiate a new media object using the input title with a default release date, and default genre
    public Media retrieveMediaCurrentlyWatching(String title) {
        for (Media m : currentlyWatching) {
            if (m.getTitle() == title) {
                return m;
            }
        }
        return new Media();
    }

    // REQUIRES: title.length() > 0 and dropped.size() >= 0
    // EFFECTS: returns the media from the currently watching list with the matching title
    // otherwise instantiate a new media object using the input title with a default release date, and default genre
    public Media retrieveMediaDropped(String title) {
        for (Media m : dropped) {
            if (m.getTitle() == title) {
                return m;
            }
        }
        return new Media();
    }

    // REQUIRES: title.length() > 0 and plannedToWatch.size() >= 0
    // EFFECTS: returns the media from the currently watching list with the matching title
    // otherwise instantiate a new media object using the input title with a default release date, and default genre
    public Media retrieveMediaPlannedToWatch(String title) {
        for (Media m : plannedToWatch) {
            if (m.getTitle() == title) {
                return m;
            }
        }
        return new Media();
    }

}
