package ui;

import model.Media;
import model.Movie;
import model.TVShow;
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

    private void doAddToList() {
        Media media = chooseMedia();
        selectList(media);
    }

    // EFFECTS: Processes steps to make TVSHow for user input "tv"
    private TVShow processStepsTVShow() {
        TVShow newTVShow = new TVShow();
        processTitleTV(newTVShow);
        processReleaseDateTV(newTVShow);
        processGenreTV(newTVShow);
        return newTVShow;
    }

    // EFFECTS: Processes steps to make movie for user input "m"
    private Movie processStepsMovie() {
        Movie newMovie = new Movie();
        processMovieTitle(newMovie);
        processMovieReleaseDate(newMovie);
        processMovieGenre(newMovie);
        return newMovie;
    }

    private void selectList(Media media) {
        String option = "";
        while (option != "c" || option != "d" || option != "p") {
            System.out.println("Which list would you like to add the media to?");
            displayListMenu();
            option = userInput.next();
            option = option.toLowerCase();

            if (option.equals("c")) {
                watchlist.addCurrentlyWatching(media);
                break;
            } else if (option.equals("d")) {
                watchlist.addDropped(media);
                break;
            } else if (option.equals("p")) {
                watchlist.addPlannedToWatch(media);
                break;
            } else {
                System.out.println("Invalid selection. Please try again!");
            }
        }
        System.out.println("Media with media title: " + '"' + media.getTitle() + '"'
                + " added successfully!");
    }

    private void doAverage() {
    }

    private Media chooseMedia() {
        String option = "";
        Media newMovie = new Movie();
        Media newTVShow = new TVShow();

        while (!option.equals("tv") || !option.equals("m")) {
            System.out.println("User please select 'm' if you are adding a Movie");
            System.out.println("User please select 'tv' if you are adding a TV show");
            option = userInput.next();
            option = option.toLowerCase();

            if (option.equals("tv")) {
                processStepsTVShow();
                break;
            } else if (option.equals("m")) {
                newMovie = processStepsMovie();
                break;
            } else {
                System.out.println("Selection is invalid. Please try again!");
            }
        }
        return newMovie;
    }

    private Movie processMovieTitle(Movie newMovie) {
        String input = "";
        boolean ongoing = true;
        while (ongoing) {
            System.out.println("What is the title of the Movie?");
            input = userInput.next();
            input = input.toLowerCase();

            if (input.length() >= 1) {
                newMovie.setTitle(input);
                ongoing = false;
            } else {
                System.out.println("Title length should be greater than 1 character");
            }
        }
        return newMovie;
    }

    private Movie processMovieGenre(Movie newMovie) {
        String input = "";
        boolean ongoing = true;
        while (ongoing) {
            System.out.println("What is the genre of the Movie?");
            input = userInput.next();
            input = input.toLowerCase();

            if (input.length() >= 1) {
                newMovie.setGenre(input);
                ongoing = false;
            } else {
                System.out.println("Title length should be greater than 1 character");
            }
        }
        return newMovie;
    }

    @SuppressWarnings("methodlength")
    private Movie processMovieReleaseDate(Movie newMovie) {
        String input = "";
        int year = 0;
        int month = 0;
        int day = 0;
        boolean ongoing = true;

        while (ongoing) {
            System.out.println("\nWhat is the release year of the Movie?");
            input = userInput.next();
            year = Integer.parseInt(input);

            System.out.println("What is the release month of the Movie?");
            input = userInput.next();
            month = Integer.parseInt(input);

            System.out.println("What is the release day of the Movie?");
            input = userInput.next();
            day = Integer.parseInt(input);

            if (year < 1700 | month < 0 | month > 12 | day < 1 | day > 31) {
                System.out.println("Year must be greater than 1700");
                System.out.println("Month must be between 1 to 12");
                System.out.println("Day must be between 1 to 31");
            } else {
                newMovie.setReleaseDate(year,month,day);
                ongoing = false;
            }
        }
        return newMovie;
    }

    private TVShow processGenreTV(TVShow newTVShow) {
        String input = "";
        boolean ongoing = true;
        while (ongoing) {
            System.out.println("What is the genre of the Movie?");
            input = userInput.next();
            input = input.toLowerCase();

            if (input.length() >= 1) {
                newTVShow.setGenre(input);
                ongoing = false;
            } else {
                System.out.println("Title length should be greater than 1 character");
            }
        }
        return newTVShow;
    }

    @SuppressWarnings("methodlength")
    private TVShow processReleaseDateTV(TVShow newTVShow) {
        String input = "";
        int year = 0;
        int month = 0;
        int day = 0;
        boolean ongoing = true;

        while (ongoing) {
            System.out.println("\nWhat is the release year of the Movie?");
            input = userInput.next();
            year = Integer.parseInt(input);

            System.out.println("What is the release month of the Movie?");
            input = userInput.next();
            month = Integer.parseInt(input);

            System.out.println("What is the release day of the Movie?");
            input = userInput.next();
            day = Integer.parseInt(input);

            if (year < 1700 | month < 0 | month > 12 | day < 1 | day > 31) {
                System.out.println("Year must be greater than 1700");
                System.out.println("Month must be between 1 to 12");
                System.out.println("Day must be between 1 to 31");
            } else {
                newTVShow.setReleaseDate(year,month,day);
                ongoing = false;
            }
        }
        return newTVShow;
    }

    private TVShow processTitleTV(TVShow newTVShow) {
        String input = "";
        boolean ongoing = true;
        while (ongoing) {
            System.out.println("What is the title of the Movie?");
            input = userInput.next();
            input = input.toLowerCase();

            if (input.length() >= 1) {
                newTVShow.setTitle(input);
                ongoing = false;
            } else {
                System.out.println("Title length should be greater than 1 character");
            }
        }
        return newTVShow;
    }

    private void doRating() {
    }

    // TODO
    // EFFECTS: displays starting menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tadd -> Add Media");
        System.out.println("\tavg -> Calculate average");
        System.out.println("\tq -> quit");
    }

    private void displayListMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tc -> Currently Watching");
        System.out.println("\td -> Dropped List");
        System.out.println("\tp -> Planning to watch");
    }

    // MODIFIES: this
    // EFFECTS: initializes watchlist
    private void init() {
        watchlist = new WatchList();
        userInput = new Scanner(System.in);
        userInput.useDelimiter("\n");
    }
}
