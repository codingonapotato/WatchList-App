package ui;

import model.WatchList;

import java.util.Scanner;

// adapted from Teller app; refer to link below:
// https://github.students.cs.ubc.ca/CPSC210/TellerApp.git
public class WatchListApp {
    private Scanner userInput;
    private WatchList watchlist;

    // EFFECTS: runs the watchlist application
    public WatchListApp() {
        runApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runApp() {
        boolean remainRunning = true;
        String userCommand = "";

        init();

        while (remainRunning) {
            displayMenu();
            userCommand = userInput.next();
            userCommand = userCommand.toLowerCase();

            if (userCommand.equals("q")) {
                remainRunning = false;
            } else {
                processCommand(userCommand);
            }
        }

        System.out.println("\n See you next time!");
    }

    // MODIFIES: this
    // EFFECTS: processes user commands
    private void processCommand(String userCommand) {
        if (userCommand.equals("add")) {
            doAddToList();
        } else if (userCommand.equals("avg")) {
            doAverage();
        } else {
            System.out.println("Selection is invalid. Please try again!");
        }
    }

    private void doAverage() {
    }

    private void doAddToList() {
        doRating();
    }

    private void doRating() {
    }

    // TODO
    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tadd -> Add Movie");
        System.out.println("\tavg -> Calculate average");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: initializes watchlist
    private void init() {
        watchlist = new WatchList();
        userInput = new Scanner(System.in);
        userInput.useDelimiter("\n");
    }
}
