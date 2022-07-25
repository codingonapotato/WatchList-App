package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MediaTest {
    private Media testMedia;
    private ReleaseDate releaseDate;

    @BeforeEach
    public void setup() {
        releaseDate = new ReleaseDate(2020,10,16);
        testMedia = new Media();
    }

    @Test
    public void testConstructor() {
        assertEquals("Kimetsu no Yaiba - Mugen Train",testMedia.getTitle());
        assertEquals(releaseDate, testMedia.getReleaseDate());
        assertEquals("Anime", testMedia.getGenre());
        assertTrue(testMedia.getRating() == 0);
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