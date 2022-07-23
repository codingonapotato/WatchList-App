package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MovieTest {
    private Movie testMovie;
    private ReleaseDate releaseDate;

    @BeforeEach
    public void setup() {
        releaseDate = new ReleaseDate(2001, 7, 20);
        testMovie = new Movie("Spirited Away", releaseDate, "Anime");
    }

    @Test
    public void testConstructor() {
        assertEquals("Spirited Away", testMovie.getTitle());
        assertEquals(releaseDate, testMovie.getReleaseDate());
        assertEquals("Anime", testMovie.getGenre());
        assertTrue(testMovie.getRating() == 0);
    }

    @Test
    public void testGetRating() {
        // set-up:
        testMovie.setRating(1);
        //check output:
        assertEquals(1, testMovie.getRating());

        // set-up:
        testMovie.setRating(100);
        //check output:
        assertEquals(100, testMovie.getRating());

        // set-up:
        testMovie.setRating(27.5);
        //check output:
        assertEquals(27.5, testMovie.getRating());
    }
}
