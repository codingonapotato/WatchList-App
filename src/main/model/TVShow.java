package model;

import java.util.List;

// Represents a TV show having a title, release date, list of characters, a genre, and a rating
public class TVShow extends Movie{

    public TVShow(String title, ReleaseDate releaseDate, List<Character> characters, String genre, int rating) {
        super(title, releaseDate, characters, genre, rating);
    }
}
