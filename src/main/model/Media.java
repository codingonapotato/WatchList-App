package model;

// Represents a piece of media having a title, release date, a genre, and a rating
public class Media {
    private String title;
    private ReleaseDate releaseDate;
    private String genre;
    private double rating;
    private boolean movie;
    private boolean tvShow;

    // EFFECTS: constructs a media object with a title = "default", release date = a ReleaseDate object initialized with
    // "1,1,1", genre = "anime, rating initialized at 0, and movie & tvShow set to false.
    public Media() {
        this.title = "default";
        this.releaseDate = new ReleaseDate(1,1,1);
        this.genre = "anime";
        this.rating = 0;
        this.tvShow = false;
        this.movie = false;
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
        this.releaseDate = new ReleaseDate(year, month, day);
    }

    // REQUIRES: rating is in [0, 100]
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
}
