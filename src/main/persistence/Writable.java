package persistence;

import org.json.JSONObject;

// adapted JsonSerializationDemo; refer to link below:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
public interface Writable {
    // EFFECTS: return this as a JSON object
    JSONObject toJson();
}
