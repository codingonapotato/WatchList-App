package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// Represents a watch list with fields representing different categories of watch lists that all store media objects
public class WatchList implements Writable {
    private List<Media> currentlyWatching;
    private List<Media> dropped;
    private List<Media> plannedToWatch;

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
            EventLog.getInstance().logEvent(new Event("Media added to currently-watching watchlist"));
            System.out.println("done!");
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
            EventLog.getInstance().logEvent(new Event("Media added to dropped watchlist"));
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
            EventLog.getInstance().logEvent(new Event("Media added to planning-to-watch watchlist"));
            return true;
        } else {
            return false;
        }
    }

    // REQUIRES: currentlyWatching.size()>= 1
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

    // REQUIRES: dropped.size()>= 1
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

    // REQUIRES: plannedToWatch.size() >= 1
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
    public List<Media> getCurrentlyWatching() {
        return currentlyWatching;
    }

    // EFFECTS: returns the dropped list
    public List<Media> getDropped() {
        return dropped;
    }

    // EFFECTS: returns the planned to watch list
    public List<Media> getPlannedToWatch() {
        return plannedToWatch;
    }

    // REQUIRES: title.length() > 0 and currentlyWatching.size() >= 0
    // EFFECTS: returns the media from the currently watching list with the matching title
    // otherwise instantiate a new media object using the default constructor
    public Media retrieveMediaCurrentlyWatching(String title) {
        Media m = new Media();

        for (Media med : currentlyWatching) {
            if (med.getTitle().toLowerCase().equals(title.toLowerCase())) {
                m = med;
            }
        }
        return m;
    }

    // REQUIRES: title.length() > 0 and dropped.size() >= 0
    // EFFECTS: returns the media from the dropped list with the matching title
    // otherwise instantiate a new media object using the default constructor
    public Media retrieveMediaDropped(String title) {
        Media m = new Media();

        for (Media med : dropped) {
            if (med.getTitle().toLowerCase().equals(title.toLowerCase())) {
                m = med;
            }
        }
        return m;
    }

    // REQUIRES: title.length() > 0 and plannedToWatch.size() >= 0
    // EFFECTS: returns the media from the plannedToWatch list with the matching title
    // otherwise instantiate a new media object using the default constructor
    public Media retrieveMediaPlannedToWatch(String title) {
        Media m = new Media();

        for (Media med : plannedToWatch) {
            if (med.getTitle().toLowerCase().equals(title.toLowerCase())) {
                m = med;
            }
        }
        return m;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("currentlyWatching", mediaListToJson(currentlyWatching));
        json.put("dropped", mediaListToJson(dropped));
        json.put("plannedToWatch", mediaListToJson(plannedToWatch));
        return json;
    }

    // EFFECTS: return Media in List<Media> as a JSON array
    private static JSONArray mediaListToJson(List<Media> mediaList) {
        JSONArray jsonArray = new JSONArray();

        for (Media m : mediaList) {
            jsonArray.put(m.toJson());
        }
        return jsonArray;
    }
}
