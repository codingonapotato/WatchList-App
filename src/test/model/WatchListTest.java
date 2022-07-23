package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void testAddCurrentlyWatching() {
        // Set-up:
        testWatchList.addCurrentlyWatching(movie1);
        testWatchList.addCurrentlyWatching(movie2);
        // Verify outputs:
        assertTrue(2 == testWatchList.getCurrentlyWatching().size());
        assertTrue(testWatchList.getCurrentlyWatching().contains(movie1));
        assertTrue(testWatchList.getCurrentlyWatching().contains(movie2));
    }

    @Test
    public void testAddDropped() {
        // Set-up:
        testWatchList.addDropped(movie1);
        testWatchList.addDropped(movie2);

        // Verify outputs:
        assertTrue(2 == testWatchList.getDropped().size());
        assertTrue(testWatchList.getDropped().contains(movie1));
        assertTrue(testWatchList.getDropped().contains(movie2));
    }

    @Test
    public void testAddPlannedToWatch() {
        // Set-up:
        testWatchList.addPlannedToWatch(movie1);
        testWatchList.addPlannedToWatch(movie2);

        // Verify outputs:
        assertTrue(2 == testWatchList.getPlannedToWatch().size());
        assertTrue(testWatchList.getPlannedToWatch().contains(movie1));
        assertTrue(testWatchList.getPlannedToWatch().contains(movie2));
    }

    @Test
    public void testAverageRatingCurrentlyWatching() {
        // Set-up:
        testWatchList.addCurrentlyWatching(movie1);
        testWatchList.addCurrentlyWatching(movie2);
        movie1.setRating(1);
        movie2.setRating(2);
        // check outputs:
        assertEquals(1.5, testWatchList.averageRatingCurrentlyWatching());

        // Set-up:
        testWatchList.addCurrentlyWatching(movie1);
        testWatchList.addCurrentlyWatching(movie2);
        movie1.setRating(0);
        movie2.setRating(0);
        // check outputs:
        assertEquals(0, testWatchList.averageRatingCurrentlyWatching());

        // Set-up:
        testWatchList.addCurrentlyWatching(movie1);
        testWatchList.addCurrentlyWatching(movie2);
        movie1.setRating(100);
        movie2.setRating(100);
        // check outputs:
        assertEquals(100, testWatchList.averageRatingCurrentlyWatching());
    }

    @Test
    public void testAverageRatingDropped() {
        // Set-up:
        testWatchList.addDropped(movie1);
        testWatchList.addDropped(movie2);
        movie1.setRating(1);
        movie2.setRating(2);
        // check outputs:
        assertEquals(1.5, testWatchList.averageRatingDropped());

        // Set-up:
        testWatchList.addDropped(movie1);
        testWatchList.addDropped(movie2);
        movie1.setRating(0);
        movie2.setRating(0);
        // check outputs:
        assertEquals(0, testWatchList.averageRatingDropped());

        // Set-up:
        testWatchList.addDropped(movie1);
        testWatchList.addDropped(movie2);
        movie1.setRating(100);
        movie2.setRating(100);
        // check outputs:
        assertEquals(100, testWatchList.averageRatingDropped());
    }

    @Test
    public void testAverageRatingPlannedToWatch() {
        // Set-up:
        testWatchList.addPlannedToWatch(movie1);
        testWatchList.addPlannedToWatch(movie2);
        movie1.setRating(1);
        movie2.setRating(2);
        // check outputs:
        assertEquals(1.5, testWatchList.averageRatingPlannedToWatch());

        // Set-up:
        testWatchList.addPlannedToWatch(movie1);
        testWatchList.addPlannedToWatch(movie2);
        movie1.setRating(0);
        movie2.setRating(0);
        // check outputs:
        assertEquals(0, testWatchList.averageRatingPlannedToWatch());

        // Set-up:
        testWatchList.addPlannedToWatch(movie1);
        testWatchList.addPlannedToWatch(movie2);
        movie1.setRating(100);
        movie2.setRating(100);
        // check outputs:
        assertEquals(100, testWatchList.averageRatingPlannedToWatch());
    }
}