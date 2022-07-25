package model;

// Represents a piece of media having a title, release date, a genre, and a rating
public class Media {
    private String title;
    private ReleaseDate releaseDate;
    private String genre;
    private double rating;

    // EFFECTS: constructs a media object with a title = "default", release date = a ReleaseDate object initialized with
    // "1,1,1", genre = "anime, and rating initialized at 0
    public Media() {
        this.title = "default";
        this.releaseDate = new ReleaseDate(1,1,1);
        this.genre = "anime";
        this.rating = 0;
    }

    // REQUIRES: rating is in [0, 100]
    // MODIFIES: this
    // EFFECTS: sets rating with the user's desired rating input
    public void setRating(double rating) {
        this.rating = rating;
    }

    // REQUIRES: rating is in [0, 100]
    // MODIFIES: this
    // EFFECTS: sets rating with the user's desired rating input
    public void setTitle(String title) {
        this.title = title;
    }

    // REQUIRES: rating is in [0, 100]
    // MODIFIES: this
    // EFFECTS: sets rating with the user's desired rating input
    public void setReleaseDate(int year, int month, int day) {
        this.releaseDate = new ReleaseDate(year, month, year);
    }

    // REQUIRES: rating is in [0, 100]
    // MODIFIES: this
    // EFFECTS: sets rating with the user's desired rating input
    public void setGenre(String genre) {
        this.genre = genre;
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
