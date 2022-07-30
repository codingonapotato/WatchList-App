package persistence;

import model.Media;
import model.WatchList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

// adapted JsonSerializationDemo; refer to link below:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
public class JsonReaderTest extends RunBefore{

    @BeforeEach
    public void runBefore() {
        RunBefore rb = new RunBefore();
        rb.runBefore();
    }

    @Test
    public void testReadFileThatDoesNotExist() {
        JsonReader jsonReader = new JsonReader("./data/LolWhereFile.json");
        try {
            WatchList watchlist = jsonReader.read();
            fail("IOException was expected");
        } catch (IOException e) {
            // Test passes!
        }
    }

    @Test
    public void testReadEmptyWatchList() {
        JsonReader jsonReader = new JsonReader("./data/testWriterEmptyWatchList.json");
        try {
            WatchList watchList = jsonReader.read();
            assertTrue(watchList.getCurrentlyWatching().isEmpty());
            assertTrue(watchList.getPlannedToWatch().isEmpty());
            assertTrue(watchList.getDropped().isEmpty());
        } catch (IOException e) {
            fail("Failed to read from file");
        }
    }

    @Test
    public void testReadTypicalWatchList() {
        JsonReader jsonReader = new JsonReader("./data/testWriterWatchListWithMedia.json");
        try {
            WatchList watchList = jsonReader.read();
            assertEquals(2, watchList.getCurrentlyWatching().size());
            assertEquals(2, watchList.getPlannedToWatch().size());
            assertEquals(2, watchList.getDropped().size());

            assertEquals(movie, watchList.getCurrentlyWatching().get(0));
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
