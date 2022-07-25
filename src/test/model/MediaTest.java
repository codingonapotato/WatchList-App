package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MediaTest {
    private Media testMedia;
    private String title;
    private String genre;
    private boolean movie;
    private boolean tvShow;

    @BeforeEach
    public void setup() {
        title = "Kimetsu no Yaiba - Mugen Train";
        genre = "anime";
        testMedia = new Media();

        testMedia.setTitle(title);
        testMedia.setGenre(genre);
        testMedia.setReleaseDate(2020,10,16);

    }

    @Test
    public void testConstructor() {
        // Verify outputs
        assertEquals("Kimetsu no Yaiba - Mugen Train",testMedia.getTitle());
        assertEquals(2020, testMedia.getReleaseDate().getYear());
        assertEquals(10, testMedia.getReleaseDate().getMonth());
        assertEquals(16, testMedia.getReleaseDate().getDay());
        assertEquals("anime", testMedia.getGenre());
        assertTrue(testMedia.getRating() == 0);
        assertFalse(testMedia.getMovie());
        assertFalse(testMedia.getTVShow());

        // Test setters for movie and tv show field:
        testMedia.setTVShow();
        testMedia.setMovie();
        assertTrue(testMedia.getTVShow());
        assertTrue(testMedia.getMovie());
    }

    @Test
    public void testGetRating() {
        // set-up:
        testMedia.setRating(1);
        //check output:
        assertEquals(1, testMedia.getRating());

        // set-up:
        testMedia.setRating(100);
        //check output:
        assertEquals(100, testMedia.getRating());

        // set-up:
        testMedia.setRating(27.5);
        //check output:
        assertEquals(27.5, testMedia.getRating());
    }
}