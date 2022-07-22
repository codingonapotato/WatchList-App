package model;

import java.util.List;

// Represents a movie having a movie title, release date, list of characters, a genre, and a rating
public class Movie {
    private String title;
    private ReleaseDate releaseDate;
    private List<Character> characters;
    private String genre;
    private int rating;

    // REQUIRES: title length > 0,
    // EFFECTS: constructs a movie object with a title, release date, list of characters, genre, and rating
    public Movie(String title, ReleaseDate releaseDate, List<Character> characters, String genre, int rating) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.characters = characters;
        this.genre = genre;
        this.rating = rating;
    }

}
