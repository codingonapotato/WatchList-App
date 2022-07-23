package model;

import java.util.ArrayList;

// Represents an episode having a title, release date, list of characters, a genre, and a rating
public class Episode extends Movie {

    public Episode(String title, ReleaseDate releaseDate, ArrayList<Character> characters, String genre, int rating) {
        super(title, releaseDate, characters, genre, rating);
    }
}
