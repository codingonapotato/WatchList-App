package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

// Represents a piece of media having a title, release date, a genre, a rating, and two states/categories
// (movie or TV show)
public class Media implements Writable {
    private String title;
    private ReleaseDate releaseDate;
    private String genre;
    private double rating;
    private boolean movie;
    private boolean tvShow;

    // REQUIRES: genre.length() && title.length() > 0
    // EFFECTS: constructs a media object with a title = "default"
    // release date = a ReleaseDate object initialized with 2000,1,1
    // genre = "anime"
    // rating initialized at 0
    // and movie & tvShow both set to false.
    public Media() {
        this.title = "default";
        this.releaseDate = new ReleaseDate(2000,1,1);
        this.genre = "anime";
        this.rating = 0;
        this.tvShow = false;
        this.movie = false;
    }

    // REQUIRES: rating is in [0, 100]
    // MODIFIES: this
    // EFFECTS: updates rating to a new value
    public void setRating(double rating) {
        this.rating = rating;
    }

    // REQUIRES: title.length() > 0
    // MODIFIES: this
    // EFFECTS: updates title to a new value
    public void setTitle(String title) {
        this.title = title;
    }

    // REQUIRES: year >= 1700 && 1 <= month <= 12 %% 1 <= day <= 31
    // MODIFIES: this
    // EFFECTS: instantiate new ReleaseDate object with new fields for year, month, and day
    public void setReleaseDate(int year, int month, int day) {
        this.releaseDate = new ReleaseDate(year, month, day);
    }

    // REQUIRES: genre.length() > 0
    // MODIFIES: this
    // EFFECTS: sets rating with the user's desired rating input
    public void setGenre(String genre) {
        this.genre = genre;
    }

    // EFFECTS: sets movie to true
    public void setMovie() {
        this.movie = true;
    }

    // EFFECTS: set tvShow to true
    public void setTVShow() {
        this.tvShow = true;
    }

    // EFFECTS: returns the title of the piece of media
    public String getTitle() {
        return this.title;
    }

    // EFFECTS: returns the release date of the piece of media
    public ReleaseDate getReleaseDate() {
        return this.releaseDate;
    }

    // EFFECTS: returns the genre of the piece of media
    public String getGenre() {
        return this.genre;
    }

    // EFFECTS: returns the rating of the piece of media
    public double getRating() {
        return rating;
    }

    // EFFECTS: returns true if the media is a movie, false otherwise
    public boolean getMovie() {
        return movie;
    }

    // EFFECTS: returns true if the media is a TV Show, false otherwise
    public boolean getTVShow() {
        return tvShow;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("title", title);
        json.put("releaseDate", releaseDate);
        json.put("genre", genre);
        json.put("rating", rating);
        json.put("movie", movie);
        json.put("tvShow", tvShow);
        return json;
    }
}
