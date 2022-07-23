package model;

import java.util.ArrayList;

// Represents a piece of media having a title, release date, a genre, and a rating
public class Media {
    private String title;
    private ReleaseDate releaseDate;
    private String genre;
    private int rating;

    // REQUIRES: title length > 0 and rating is in [0, 100]
    // EFFECTS: constructs a media object with a title, release date, genre, and rating.
    // Rating is initialized at 0
    public Media(String title, ReleaseDate releaseDate, String genre) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.rating = 0;
    }

    // EFFECTS: returns the title of the piece of media
    public String getTitle() {
        return ""; // stub
    }

    // EFFECTS: returns the release date of the piece of media
    public ReleaseDate getReleaseDate() {
        return new ReleaseDate(1,2,3); // stub
    }

    // EFFECTS: returns the genre of the piece of media
    public String getGenre() {
        return ""; // stub
    }

    // EFFECTS: returns the rating of the piece of media
    public int getRating() {
        return 0; // stub
    }

}
