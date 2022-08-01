package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

class MediaTest {
    private Media testMedia;
    private Media testMedia2;
    private Media testMedia3;
    private String title;
    private String genre;
    private boolean movie;
    private boolean tvShow;

    @BeforeEach
    public void setup() {
        title = "Kimetsu no Yaiba - Mugen Train";
        genre = "anime";
        testMedia = new Media();
        testMedia2 = new Media();
        testMedia3 = new Media();

        testMedia.setTitle(title);
        testMedia.setGenre(genre);
        testMedia.setReleaseDate(2020,10,16);
        testMedia.setTVShow(true);
        testMedia.setMovie(false);

        testMedia2.setTitle(title);
        testMedia2.setGenre(genre);
        testMedia2.setReleaseDate(2020,10,16);
        testMedia2.setTVShow(true);
        testMedia2.setMovie(false);

        testMedia3.setTitle("Saw");
        testMedia3.setGenre("Horror");
        testMedia3.setReleaseDate(2009,3,18);
        testMedia3.setTVShow(false);
        testMedia3.setMovie(true);
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
        assertTrue(testMedia.getTVShow());
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

    @Test
    public void testEquals() {
        assertTrue(testMedia.equals(testMedia));
        assertTrue(testMedia.equals(testMedia2)); // diff obj same fields
        testMedia2.setRating(21.0); // testMedia2.getRating() > testMedia.getRating()
        assertFalse(testMedia.equals(testMedia2));
        testMedia.setRating(39); // testMedia2.getRating() < testMedia.getRating()
        assertFalse(testMedia.equals(testMedia2));
        testMedia.setRating(-0); // testMedia2.getRating() < testMedia.getRating()
        assertFalse(testMedia.equals(testMedia2));
        testMedia2.setRating(39); // now ratings are all ==
        testMedia.setRating(39);
        assertTrue(testMedia.equals(testMedia2));
        testMedia2.setTitle("The Good Place"); // only title is different
        assertFalse(testMedia.equals(testMedia2));
        testMedia2.setTitle(title); // now titles are all ==
        assertTrue(testMedia.equals(testMedia2));
        testMedia2.setGenre("sitcom"); // only genre is different
        assertFalse(testMedia.equals(testMedia2));
        testMedia2.setGenre("anime");
        assertTrue(testMedia.equals(testMedia2));
        testMedia2.setReleaseDate(2000,1,13); // only releasedate is different
        assertFalse(testMedia.equals(testMedia2));
        testMedia2.setReleaseDate(2020,10,16); // now releasedates are ==
        assertTrue(testMedia.equals(testMedia2));
        testMedia2.setMovie(true);
        testMedia2.setTVShow(false);
        assertFalse(testMedia.equals(testMedia2));
        testMedia2.setMovie(false);
        testMedia2.setTVShow(true);
        assertTrue(testMedia.equals(testMedia2));
        assertFalse(testMedia.equals(null)); // test null branch
        assertFalse(testMedia.equals(title)); // test diff obj type branch
        assertFalse(testMedia.equals(testMedia3)); // diff obj diff fields
    }
}