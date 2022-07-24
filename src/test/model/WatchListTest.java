package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WatchListTest {
    private WatchList testWatchList;
    private Movie movie1;
    private Movie movie2;
    private TVShow show1;
    private TVShow show2;


    @BeforeEach
    public void setup() {
        testWatchList = new WatchList();
        movie1 = new Movie("Jujutsu Kaisen 0", new ReleaseDate(2021, 12,24), "Anime");
        movie2 = new Movie("My Neighbor Totoro", new ReleaseDate(1988, 4,16), "Anime");
        show1 = new TVShow("Spy x Family", new ReleaseDate(2022, 4,9), "Anime");
        show2 = new TVShow("Re:Zero - Starting life in Another World", new ReleaseDate(2016, 4,4),
                "Anime");
    }

    @Test
    public void testConstructor() {
        assertTrue(testWatchList.getCurrentlyWatching().isEmpty());
        assertTrue(testWatchList.getDropped().isEmpty());
        assertTrue(testWatchList.getPlannedToWatch().isEmpty());
    }

    @Test
    // TODO:
    public void testAddCurrentlyWatching() {
        // Set-up and check outputs:
        assertTrue(testWatchList.addCurrentlyWatching(movie1));
        assertTrue(testWatchList.addCurrentlyWatching(movie2));
        assertTrue(testWatchList.addCurrentlyWatching(show1));
        assertFalse(testWatchList.addCurrentlyWatching(movie1));
        // Verify outputs:
        assertTrue(3 == testWatchList.getCurrentlyWatching().size());
        assertTrue(testWatchList.getCurrentlyWatching().contains(movie1));
        assertTrue(testWatchList.getCurrentlyWatching().contains(movie2));
        assertTrue(testWatchList.getCurrentlyWatching().contains(show1));
    }

    @Test
    public void testAddDropped() {
        // Set-up and check outputs:
        assertTrue(testWatchList.addDropped(movie1));
        assertTrue(testWatchList.addDropped(movie2));
        assertTrue(testWatchList.addDropped(show1));
        assertFalse(testWatchList.addDropped(movie1));

        // Verify outputs:
        assertTrue(3 == testWatchList.getDropped().size());
        assertTrue(testWatchList.getDropped().contains(movie1));
        assertTrue(testWatchList.getDropped().contains(movie2));
        assertTrue(testWatchList.getDropped().contains(show1));
    }

    @Test
    public void testAddPlannedToWatch() {
        // Set-up and check outputs:
        assertTrue(testWatchList.addPlannedToWatch(movie1));
        assertTrue(testWatchList.addPlannedToWatch(movie2));
        assertTrue(testWatchList.addPlannedToWatch(show1));
        assertFalse(testWatchList.addPlannedToWatch(movie1));

        // Verify outputs:
        assertTrue(3 == testWatchList.getPlannedToWatch().size());
        assertTrue(testWatchList.getPlannedToWatch().contains(movie1));
        assertTrue(testWatchList.getPlannedToWatch().contains(movie2));
        assertTrue(testWatchList.getPlannedToWatch().contains(show1));
    }

    @Test
    public void testAverageRatingCurrentlyWatching() {
        // Set-up:
        testWatchList.addCurrentlyWatching(movie1);
        testWatchList.addCurrentlyWatching(show1);
        movie1.setRating(5);
        show1.setRating(20);
        // check outputs:
        assertEquals(12.5, testWatchList.averageRatingCurrentlyWatching());

        // Set-up:
        movie1.setRating(0);
        show1.setRating(0);
        // check outputs:
        assertEquals(0, testWatchList.averageRatingCurrentlyWatching());

        // Set-up:
        movie1.setRating(100);
        show1.setRating(100);
        // check outputs:
        assertEquals(100, testWatchList.averageRatingCurrentlyWatching());
    }

    @Test
    public void testAverageRatingDropped() {
        // Set-up:
        testWatchList.addDropped(movie1);
        testWatchList.addDropped(show1);
        movie1.setRating(20);
        show1.setRating(5);
        // check outputs:
        assertEquals(12.5, testWatchList.averageRatingDropped());

        // Set-up:
        movie1.setRating(0);
        show1.setRating(0);
        // check outputs:
        assertEquals(0, testWatchList.averageRatingDropped());

        // Set-up:
        movie1.setRating(100);
        show1.setRating(100);
        // check outputs:
        assertEquals(100, testWatchList.averageRatingDropped());
    }

    @Test
    public void testAverageRatingPlannedToWatch() {
        // Set-up:
        testWatchList.addPlannedToWatch(movie1);
        testWatchList.addPlannedToWatch(show1);
        movie1.setRating(5);
        show1.setRating(98);
        // check outputs:
        assertEquals(51.5, testWatchList.averageRatingPlannedToWatch());

        //Set-up:
        movie1.setRating(0);
        show1.setRating(0);
        // check outputs:
        assertEquals(0, testWatchList.averageRatingPlannedToWatch());

        // Set-up:
        movie1.setRating(100);
        show1.setRating(100);
        // check outputs:
        assertEquals(100, testWatchList.averageRatingPlannedToWatch());
    }

    @Test
    public void testRetrieveMediaCurrentlyWatching() {
        // Set-up:
        testWatchList.addCurrentlyWatching(movie1);
        testWatchList.addCurrentlyWatching(show1);

        // Check outputs:
        assertEquals(movie1, testWatchList.retrieveMediaCurrentlyWatching("Jujutsu Kaisen 0"));
        assertEquals(show1, testWatchList.retrieveMediaCurrentlyWatching("Spy x Family"));
        Media otherwiseCase = testWatchList.retrieveMediaCurrentlyWatching("Rem");
        assertEquals(otherwiseCase.getTitle(), "Rem");
    }

    @Test
    public void testRetrieveMediaDropped() {
        // Set-up:
        testWatchList.addDropped(movie1);
        testWatchList.addDropped(show1);

        // Check outputs:
        assertEquals(movie1, testWatchList.retrieveMediaDropped("Jujutsu Kaisen 0"));
        assertEquals(show1, testWatchList.retrieveMediaDropped("Spy x Family"));
        Media otherwiseCase = testWatchList.retrieveMediaDropped("Ram");
        assertEquals(otherwiseCase.getTitle(), "Ram");
    }

    @Test
    public void testRetrieveMediaPlannedToWatch() {
        // Set-up:
        testWatchList.addPlannedToWatch(movie1);
        testWatchList.addPlannedToWatch(show1);

        // Check outputs:
        assertEquals(movie1, testWatchList.retrieveMediaPlannedToWatch("Jujutsu Kaisen 0"));
        assertEquals(show1, testWatchList.retrieveMediaPlannedToWatch("Spy x Family"));
        Media otherwiseCase = testWatchList.retrieveMediaPlannedToWatch("Bethroldt");
        assertEquals(otherwiseCase.getTitle(), "Bethroldt");
    }
}