package persistence;

import model.Media;
import model.ReleaseDate;
import model.WatchList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;


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
        String jsonData = readFile(sourceFile);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWatchList(jsonObject);
    }

    // EFFECTS: read source file as a string and return the string
    private String readFile(String sourceFile) throws IOException {
        StringBuilder contentConstructor = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(sourceFile), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentConstructor.append(s));
        }

        return contentConstructor.toString();
    }

    // EFFECTS: parse WatchList from JSON object and return the WatchList
    private WatchList parseWatchList(JSONObject jsonObject) {
        JSONArray currentlyWatching = jsonObject.getJSONArray("currentlyWatching");
        JSONArray dropped = jsonObject.getJSONArray("dropped");
        JSONArray plannedToWatch = jsonObject.getJSONArray("plannedToWatch");
        WatchList watchList = new WatchList();

        addCurrentlyWatching(watchList, currentlyWatching);
        addDropped(watchList, dropped);
        addPlannedToWatch(watchList, plannedToWatch);
        return watchList;
    }

    // MODIFIES: watchList
    // EFFECTS: parses currentlyWatching from JSON object and adds them to WatchList
    private void addCurrentlyWatching(WatchList watchList, JSONArray jsonObject) {
        for (Object json : jsonObject) {
            JSONObject nextMedia = (JSONObject) json;
            Media media = addMedia(watchList, nextMedia);
            watchList.addCurrentlyWatching(media);
        }
    }

    // MODIFIES: watchList
    // EFFECTS: parses dropped from JSON object and adds them to WatchList
    private void addDropped(WatchList watchList, JSONArray jsonObject) {
        for (Object json : jsonObject) {
            JSONObject nextMedia = (JSONObject) json;
            Media media = addMedia(watchList, nextMedia);
            watchList.addDropped(media);
        }
    }

    // MODIFIES: watchList
    // EFFECTS: parses plannedToWatch from JSON object and adds them to WatchList
    private void addPlannedToWatch(WatchList watchList, JSONArray jsonObject) {
        for (Object json : jsonObject) {
            JSONObject nextMedia = (JSONObject) json;
            Media media = addMedia(watchList, nextMedia);
            watchList.addPlannedToWatch(media);
        }
    }

    // MODIFIES: watchList
    // EFFECTS: parses media from JSON object and adds it to WatchList
    private Media addMedia(WatchList watchList, JSONObject jsonObject) {
        Media media = new Media();
        String title = jsonObject.getString("title");
        media.setTitle(title); // set title
        JSONObject releaseDateJson = jsonObject.getJSONObject("releaseDate");
        int day = releaseDateJson.getInt("day");
        int month = releaseDateJson.getInt("month");
        int year = releaseDateJson.getInt("year");
        media.setReleaseDate(year, month, day); // set ReleaseDate
        String genre = jsonObject.getString("genre");
        media.setGenre(genre);
        double rating = jsonObject.getDouble("rating");
        media.setRating(rating);
        boolean movie = jsonObject.getBoolean("movie");
        media.setMovie(movie);
        boolean tv = jsonObject.getBoolean("tvShow");
        media.setTVShow(tv);
        return media;
    }

}
