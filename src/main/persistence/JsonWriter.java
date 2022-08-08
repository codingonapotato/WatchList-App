package persistence;

import model.WatchList;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// adapted JsonSerializationDemo; refer to link below:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

// Represents a writer to format WatchList into a JSON file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String saveDestination;

    // EFFECTS: construct a JsonWriter object to write to saveDestination
    public JsonWriter(String saveDestination) {
        this.saveDestination = saveDestination;
    }

    // MODIFIES: this
    // EFFECTS: open writer; throw FileNotFoundException if saveDestination file cannot be opened for writing
    public void openWriter() throws FileNotFoundException {
        writer = new PrintWriter(new File(saveDestination));
    }

    // MODIFIES: this
    // EFFECTS: write JSON representation of WatchList to file
    public void writeFile(WatchList watchList) {
        JSONObject jsonObject = watchList.toJson();
        saveToFile(jsonObject.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: close writer
    public void closeWriter() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: write string to file
    private void saveToFile(String json) {
        writer.print(json);
    }
}
