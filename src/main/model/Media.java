package model;

// Represents a piece of media having a title, release date, a genre, and a rating
public class Media {
    private String title;
    private ReleaseDate releaseDate;
    private String genre;
    private double rating;

    // REQUIRES: title length > 0 and rating is in [0, 100]
    // EFFECTS: constructs a media object with a title, release date, genre, and rating.
    // Rating is initialized at 0
    public Media(String title, ReleaseDate releaseDate, String genre) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.rating = 0;
    }

    // REQUIRES: rating is in [0, 100]
    // MODIFIES: this
    // EFFECTS: sets rating with the user's desired rating input
    public void setRating(double rating) {
        this.rating = rating;
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

}
