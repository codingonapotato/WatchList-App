package model;

import java.util.Timer;
import java.util.TimerTask;

public class MediaTimer extends Timer {

    // EFFECTS: Instantiates a MediaTimer object
    public MediaTimer() {
        super();
    }

    // REQUIRES: hours in [0, 24], minutes in [0, 60], seconds in [0,60]
    // MODIFIES: this
    // EFFECTS: Set countdown with the given inputs
    public void setCountDown(int hours, int minutes, int seconds) {}

    // REQUIRES: delay >= 0
    // MODIFIES: this
    // EFFECTS: Schedules a task to execute after a specified delay milliseconds
    @Override
    public void schedule(TimerTask task, long delay){

    }
}
