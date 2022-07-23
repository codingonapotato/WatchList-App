package model;

import java.util.ArrayList;

// Represents a movie having a movie title, release date, list of characters, a genre, and a rating
public class Movie extends Media {

    public Movie(String title, ReleaseDate releaseDate, String genre) {
        super(title, releaseDate, genre);
    }
}
