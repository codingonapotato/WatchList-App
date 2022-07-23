package model;

import java.util.ArrayList;
import java.util.List;

// Represents a TV show having a title, release date, genre, and rating
public class TVShow extends Movie {
    public TVShow(String title, ReleaseDate releaseDate, String genre) {
        super(title, releaseDate, genre);
    }
}

