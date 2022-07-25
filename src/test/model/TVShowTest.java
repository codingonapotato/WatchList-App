//package model;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//class TVShowTest {
//    private TVShow testShow;
//    private ReleaseDate releaseDate;
//    private String title;
//    private String genre;
//
//    @BeforeEach
//    public void setup() {
//        releaseDate = new ReleaseDate(2004, 5, 31);
//        genre = "children";
//        title = "Peppa Pig";
//        testShow = new TVShow();
//    }
//
//    @Test
//    public void testConstructor() {
//        assertEquals("Peppa Pig", testShow.getTitle());
//        assertEquals(releaseDate, testShow.getReleaseDate());
//        assertEquals("Child", testShow.getGenre());
//        assertTrue(testShow.getRating() == 0);
//    }
//
//    @Test
//    public void testGetRating() {
//        // set-up:
//        testShow.setRating(1);
//        //check output:
//        assertEquals(1, testShow.getRating());
//
//        // set-up:
//        testShow.setRating(100);
//        //check output:
//        assertEquals(100, testShow.getRating());
//
//        // set-up:
//        testShow.setRating(27.5);
//        //check output:
//        assertEquals(27.5, testShow.getRating());
//    }
//}