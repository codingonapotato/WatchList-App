//package model;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//class MovieTest {
//    private Movie testMovie;
//    private ReleaseDate releaseDate = new ReleaseDate(2001, 7, 20);
//    private String title = "Spirited Away";
//    private String genre = "anime";
//
//    @BeforeEach
//    public void setup() {
//        testMovie = new Movie();
//        testMovie.setGenre(genre);
//        testMovie.setTitle(title);
//        testMovie.setReleaseDate(2001,7,20);
//    }
//
//    @Test
//    public void testConstructor() {
//        assertEquals(title, testMovie.getTitle());
//        assertEquals(releaseDate, testMovie.getReleaseDate());
//        assertEquals(genre, testMovie.getGenre());
//        assertTrue(testMovie.getRating() == 0);
//    }
//
//    @Test
//    public void testGetRating() {
//        // set-up:
//        testMovie.setRating(1);
//        //check output:
//        assertEquals(1, testMovie.getRating());
//
//        // set-up:
//        testMovie.setRating(100);
//        //check output:
//        assertEquals(100, testMovie.getRating());
//
//        // set-up:
//        testMovie.setRating(27.5);
//        //check output:
//        assertEquals(27.5, testMovie.getRating());
//    }
//}
