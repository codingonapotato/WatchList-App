package model;

import java.util.ArrayList;

// Represents a movie having a movie title, release date, list of characters, a genre, and a rating
public class Movie {
    private String title;
    private ReleaseDate releaseDate;
    private ArrayList<Character> characters;
    private String genre;
    private int rating;

    // REQUIRES: title length > 0,
    // EFFECTS: constructs a movie object with a title, release date, list of characters, genre, and rating
    public Movie(String title, ReleaseDate releaseDate, ArrayList<Character> characters, String genre, int rating) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.characters = characters;
        this.genre = genre;
        this.rating = rating;
    }

    // EFFECTS: returns the title of the movie
    public String getTitle() {
        return "";// stub
    }

    // EFFECTS: returns the release date of the movie
    public ReleaseDate getReleaseDate() {
        return new ReleaseDate(1,2,3);// stub
    }

    // EFFECTS: returns the list of characters in the movie
    public ArrayList<Character> getCharacters() {
        return new ArrayList<>();// stub
    }

    // EFFECTS: returns the genre of the movie
    public String getGenre() {
        return "";// stub
    }

    // EFFECTS: returns the rating of the movie
    public int getRating() {
        return 0;// stub
    }

}
