package persistence;

import model.WatchList;
import org.json.JSONObject;

import java.io.IOException;

// adapted JsonSerializationDemo; refer to link below:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

// Represents a reader that reads WatchList from JSON data stored in file
public class JsonReader {
    private String sourceFile;

    // EFFECTS: instantiate a JsonReader object that reads source files
    public JsonReader(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    // EFFECTS: read WatchList from file and return the WatchList
    // throws IOException if an error happens when reading data from the file
    public WatchList read() throws IOException {
        return null; // stub
    }

    // EFFECTS: read source file as a string and return the string
    private String readFile(String sourceFile) throws IOException {
        return null; // stub
    }

    // EFFECTS: parse WatchList from JSON object and return the WatchList
    private WatchList parseWatchList(JSONObject jsonObject) {
        return null; // stub
    }

    // MODIFIES: watchList
    // EFFECTS: parses currentlyWatching from JSON object and adds them to WatchList
    private void addCurrentlyWatching(WatchList watchList, JSONObject jsonObject) {

    }

    // MODIFIES: watchList
    // EFFECTS: parses dropped from JSON object and adds them to WatchList
    private void addDropped(WatchList watchList, JSONObject jsonObject) {

    }

    // MODIFIES: watchList
    // EFFECTS: parses plannedToWatch from JSON object and adds them to WatchList
    private void addPlannedToWatch(WatchList watchList, JSONObject jsonObject) {

    }

    // MODIFIES: watchList
    // EFFECTS: parses media from JSON object and adds it to WatchList
    private void addMedia(WatchList wl, JSONObject jsonObject) {

    }

}
