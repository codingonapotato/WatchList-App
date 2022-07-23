package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WatchListTest {
    private Movie movie1;
    private Movie movie2;
    private TVShow show1;
    private TVShow show2;


    @BeforeEach
    public void setup() {
        movie1 = new Movie("Jujutsu Kaisen 0", new ReleaseDate(2021, 12,24), "Anime");
        movie2 = new Movie("My Neighbor Totoro", new ReleaseDate(1988, 4,16), "Anime");
        show1 = new TVShow("Spy x Family", new ReleaseDate(2022, 4,9), "Anime");
        show2 = new TVShow("Re:Zero - Starting life in Another World", new ReleaseDate(2016, 4,4),
                "Anime");
    }

    @Test
    public void testAddCurrentlyWatching() {

    }

    @Test
    public void testAddDropped() {

    }

    @Test
    public void testAddPlannedToWatch() {

    }

    @Test
    public void testAverageRatingCurrentlyWatching() {

    }

    @Test
    public void testAverageRatingDropped() {

    }

    @Test
    public void testAverageRatingPlannedToWatch() {

    }
}