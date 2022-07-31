package persistence;

import model.Media;
import model.WatchList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

// adapted JsonSerializationDemo; refer to link below:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
public class JsonWriterTest {
    private WatchList watchList;
    private Media movie;
    private Media tv;

    @BeforeEach
    public void setup() {
        movie = new Media();
        movie.setTitle("ponyo");
        movie.setReleaseDate(2000,12,31);
        movie.setRating(57.5);
        movie.setGenre("anime");
        movie.setMovie(true); // So, this is a movie now!

        tv = new Media();
        tv.setTitle("Jujutsu Kaisen");
        tv.setReleaseDate(2020,4,27);
        tv.setRating(100.0);
        tv.setGenre("anime");
        tv.setTVShow(true); // So, this is a TV show now!

        watchList = new WatchList();
    }

    @Test
    public void testWriterIllegalFile() {
        try {
            JsonWriter jsonWriter = new JsonWriter("./data/my\0illegal:fileName.json");
            jsonWriter.openWriter();
            fail("IOException was expected");
        } catch (IOException e) {
            // Test passes!
        }
    }

    @Test
    public void testWriterEmptyWatchList() {
        try {
            JsonWriter jsonWriter = new JsonWriter("./data/testWriterEmptyWatchList.json");
            jsonWriter.openWriter();
            jsonWriter.writeFile(watchList);
            jsonWriter.closeWriter();

            JsonReader jsonReader = new JsonReader("./data/testWriterEmptyWatchList.json");
            watchList = jsonReader.read();
            assertTrue(watchList.getCurrentlyWatching().isEmpty());
            assertTrue(watchList.getPlannedToWatch().isEmpty());
            assertTrue(watchList.getDropped().isEmpty());

        } catch (IOException e) {
            fail("Exception should not have been thrown :(");
        }
    }

    @Test
    public void testWriterWatchListWithMedia() {
        // Set-up putting two media into each watchlist category
        try {
            watchList.addCurrentlyWatching(movie);
            watchList.addCurrentlyWatching(tv);
            watchList.addPlannedToWatch(movie);
            watchList.addPlannedToWatch(tv);
            watchList.addDropped(movie);
            watchList.addDropped(tv);

            JsonWriter jsonWriter = new JsonWriter("./data/testWriterWatchListWithMedia.json");
            jsonWriter.openWriter();
            jsonWriter.writeFile(watchList);
            jsonWriter.closeWriter();

            JsonReader jsonReader = new JsonReader("./data/testWriterWatchListWithMedia.json");
            watchList = jsonReader.read();
            assertEquals(2, watchList.getCurrentlyWatching().size());
            assertEquals(2, watchList.getPlannedToWatch().size());
            assertEquals(2, watchList.getDropped().size());

            assertTrue(movie.equals(watchList.getCurrentlyWatching().get(0)));
            assertEquals(tv, watchList.getCurrentlyWatching().get(1));
            assertEquals(movie, watchList.getDropped().get(0));
            assertEquals(tv, watchList.getDropped().get(1));
            assertEquals(movie, watchList.getPlannedToWatch().get(0));
            assertEquals(tv, watchList.getPlannedToWatch().get(1));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
