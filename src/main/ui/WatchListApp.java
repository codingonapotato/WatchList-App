package ui;

import model.Media;
import model.Movie;
import model.TVShow;
import model.WatchList;

import java.util.ArrayList;
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
        } else if (userCommand.equals("rate")) {
            doRating();
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
        while (!(option.equals("c")) || !(option.equals("d")) || !(option.equals("p"))) {
            System.out.println("Which list would you like to add the media to?");
            displayListMenu();
            option = userInput.next();
            option = option.toLowerCase();

            if (option.equals("c")) {
                watchlist.addCurrentlyWatching(media);
                System.out.println(watchlist.getCurrentlyWatching().size());
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

    private Media chooseMedia() {
        String option = "";
        Media newMedia = new Movie();

        while (!option.equals("tv") || !option.equals("m")) {
            System.out.println("User please select 'm' if you are adding a Movie");
            System.out.println("User please select 'tv' if you are adding a TV show");
            option = userInput.next();
            option = option.toLowerCase();

            if (option.equals("tv")) {
                newMedia = processStepsTVShow();
                break;
            } else if (option.equals("m")) {
                newMedia = processStepsMovie();
                break;
            } else {
                System.out.println("Selection is invalid. Please try again!");
            }
        }
        return newMedia;
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
            System.out.println("What is the genre of the TV?");
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
            System.out.println("\nWhat is the release year of the TV show?");
            input = userInput.next();
            year = Integer.parseInt(input);

            System.out.println("What is the release month of the TV show?");
            input = userInput.next();
            month = Integer.parseInt(input);

            System.out.println("What is the release day of the TV show?");
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
            System.out.println("What is the title of the TV show?");
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

    // TODO:
    private void doAverage() {
        String option = "";
        while (!(option.equals("c")) || !(option.equals("d")) || !(option.equals("p"))) {
            System.out.println("Which list would you like to add the media to?");
            option = userInput.next();
            option = option.toLowerCase();
        }
    }



    private void doRating() {
        String chosenOption = ratingOptions();
        Media retrieved = retrieveMediaForRating(chosenOption);
        String input = "";
        boolean ongoing = true;
        double rating;

        while (ongoing) {
            System.out.println("What rating would you like to apply to " + '"' + retrieved.getTitle() + '"' + "?");
            input = userInput.next();
            rating = Double.parseDouble(input);

            if (rating >= 0 && rating <= 100) {
                retrieved.setRating(rating);
                break;
            } else {
                System.out.println("Rating must be between 0 to 100");
            }
        }
        System.out.println("Rating: " + retrieved.getRating() + " has been applied to: " + retrieved.getTitle() + "!");
    }

    private String ratingOptions() {
        String option = "";
        boolean ongoing = true;

        while (ongoing) {
            displayListMenu();
            option = userInput.next();
            option = option.toLowerCase();

            if (option.equals("c") || option.equals("d") || option.equals("p")) {
                break;
            } else {
                System.out.println("Invalid selection. Please try again!");
            }
        }
        return option;
    }

    private Media retrieveMediaForRating(String option) {
        String input = "";
        Media toBeRated;

        while (true) {
            System.out.println("What is the title of the Movie or TV show you wish to provide a rating for, user?");
            input = userInput.next();
            input = input.toLowerCase();

            if (option.equals("c")) {
                toBeRated = watchlist.retrieveMediaCurrentlyWatching(input);
                break;
            } else if (option.equals("d")) {
                toBeRated = watchlist.retrieveMediaDropped(input);
                break;
            } else {
                toBeRated = watchlist.retrieveMediaPlannedToWatch(input);
                break;
            }
        }
        return toBeRated;
    }

    // TODO
    // EFFECTS: displays starting menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tadd -> Add Media");
        System.out.println("\trate -> Rate Media");
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
