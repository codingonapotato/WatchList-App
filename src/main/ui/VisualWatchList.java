package ui;

import model.EventLog;
import model.Media;
import model.WatchList;
import model.Event;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VisualWatchList extends JFrame implements ActionListener {
    private static final String JSON_SAVE_DESTINATION = "./data/watchlist.json";
    private WatchList watchList;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private JTextArea logScreen;
    private JButton addButton;
    private JButton rateButton;
    private JButton avgButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton viewButton;

    // EFFECTS: instantiates the object which will run the GUI for the user
    public VisualWatchList() {
        super();
        init();
        setTitle("myWatchList Application");
        setBounds(1080, 720,700,500);
        setLocation(0,0);
        setLayout(new FlowLayout());
        prepareButtons();
        loadImage();
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        logScreen = new JTextArea();
        logScreen.setEditable(false);
        JScrollPane scroller = new JScrollPane(logScreen);
        logScreen.setSize(500,200);
        scroller.setSize(1000, 350);
        scroller.setLocation(0,720);
        logScreen.setText("Akjglajgajgagakgajga");
        add(scroller);
        scroller.setVisible(true);
        logScreen.setVisible(true);

    }

    // MODIFIES: this
    // EFFECTS: instantiates watchlist, jsonReader, and jsonWriter objects
    private void init() {
        watchList = new WatchList();
        jsonWriter = new JsonWriter(JSON_SAVE_DESTINATION);
        jsonReader = new JsonReader(JSON_SAVE_DESTINATION);

    }

    // EFFECTS: adds a background image to the GUI
    private void loadImage() {
        String fileDir = "./data/sameHello.jpg";
        int width = 700;
        int height = 1000;
        ImageIcon img = new ImageIcon(fileDir);
        JLabel label = new JLabel(img);
        label.setPreferredSize(new Dimension(width, height));
        add(label);
        setVisible(true);
    }

    // EFFECTS: executes method calls to specify the behaviour of all buttons for the WatchList
    private void prepareButtons() {
        makeButtons();
        addStartingButtons();
        setButtonActionCommands();
        addButtonActionListener();
        setVisible(true);
    }

    // EFFECTS: instantiate new JButton with the appropriate label
    private void makeButtons() {
        // Starting buttons
        addButton = new JButton("Add media to WatchList");
        rateButton = new JButton("Rate media in WatchList");
        avgButton = new JButton("Calculate the average rating in a watchlist category");
        saveButton = new JButton("Save the state of the application");
        loadButton = new JButton("Load from save");
        viewButton = new JButton("View watchlist contents");
    }

    // EFFECTS: adds starting menu JButtons to the GUI
    private void addStartingButtons() {
        add(addButton);
        add(rateButton);
        add(avgButton);
        add(saveButton);
        add(loadButton);
        add(viewButton);
    }

    // EFFECTS: sets the ActionCommand for the specific JButton
    private void setButtonActionCommands() {
        addButton.setActionCommand("add");
        rateButton.setActionCommand("rate");
        avgButton.setActionCommand("avg");
        saveButton.setActionCommand("save");
        loadButton.setActionCommand("load");
        viewButton.setActionCommand("view");
    }

    // EFFECTS adds an ActionListener object for the instantiated JButtons
    private void addButtonActionListener() {
        addButton.addActionListener(this);
        rateButton.addActionListener(this);
        avgButton.addActionListener(this);
        saveButton.addActionListener(this);
        loadButton.addActionListener(this);
        viewButton.addActionListener(this);

    }

    // EFFECTS: creates a JOptionPane with a message dialog box that indicates that a task was completed successfully
    private void taskCompletedPane() {
        JOptionPane.showMessageDialog(null,"Task completed successfully");
    }

    // EFFECTS: creates a JOptionPane with a message dialog box that indicates that a task was completed successfully
    private void mediaListSizePane(List<Media> medias) {
        String msg = "The size of your selected watchlist category is: ";
        msg += medias.size();
        JOptionPane.showMessageDialog(null,msg);
    }

    // EFFECTS: Handles and calls the proper methods depending on which button/event is initiated by the user
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("add")) {
            Media m = chooseMedia();
            List<Media> medias = getListByCommand();
            medias.add(m);
            mediaListSizePane(medias);
            taskCompletedPane();
        } else if (e.getActionCommand().equalsIgnoreCase("rate")) {
            List<Media> medias = getListByCommand();
            addRating(processRating(medias));
        } else if (e.getActionCommand().equalsIgnoreCase("avg")) {
            double avg = avgListByCommand();
            JOptionPane.showMessageDialog(null,"The average score in your selected watchlist is: "
                    + avg);
        } else if (e.getActionCommand().equalsIgnoreCase("view")) {
            viewWatchList();
        } else if (e.getActionCommand().equalsIgnoreCase("save")) {
            saveWatchList();
            JOptionPane.showMessageDialog(null, "Saved watchlist to: " + JSON_SAVE_DESTINATION);
        } else if (e.getActionCommand().equalsIgnoreCase("load")) {
            loadWatchList();
            JOptionPane.showMessageDialog(null, "Loaded watchlist from: " + JSON_SAVE_DESTINATION);
        } else {
            // do nothing
        }
    }

    // EFFECTS: save watchlist to file
    private void saveWatchList() {
        try {
            jsonWriter.openWriter();
            jsonWriter.writeFile(watchList);
            jsonWriter.closeWriter();
            System.out.println("Your watchlist has been stored successfully to: " + JSON_SAVE_DESTINATION);
        } catch (FileNotFoundException e) {
            System.err.println("Sorry! Writing the watchlist to " + JSON_SAVE_DESTINATION + " has failed...");
        }
    }

    // MODIFIES: this
    // EFFECTS: load watchlist from file
    private void loadWatchList() {
        try {
            watchList = jsonReader.read();
            System.out.println("Your watchlist has been loaded successfully from: " + JSON_SAVE_DESTINATION);
        } catch (IOException e) {
            System.err.println("Sorry! Reading from  " + JSON_SAVE_DESTINATION + " has failed...");
        }
    }

    // EFFECTS: returns the titles of the Media from a list of media concatenated into a single string
    // with a number in front of each title to show the number of media objects in the watchlist category
    private static String getWatchListTitles(List<Media> mediaList) {
        String str = "";
        int i = 1;
        for (Media m : mediaList) {
            str += "[" + i + "] " + m.getTitle() + ", ";
            i++;
        }
        return str;
    }

    // EFFECTS: prints the chosen watchlist onto the GUI with the media titles and the size of the watchlist categories
    private void viewWatchList() {
        String currentlyWatchingTitles = getWatchListTitles(watchList.getCurrentlyWatching());
        String droppedTitles = getWatchListTitles(watchList.getDropped());
        String plannedToWatchTitles = getWatchListTitles(watchList.getPlannedToWatch());

        JLabel blank = new JLabel(" ");
        JLabel blank2 = new JLabel(" ");

        JLabel currLabel = new JLabel("[Currently-watching Watchlist] : " + currentlyWatchingTitles
                + " <Size> : " + watchList.getCurrentlyWatching().size());
        JLabel dropLabel = new JLabel("[Dropped Watchlist] : " + droppedTitles
                + " <Size> : " + watchList.getDropped().size());
        JLabel planLabel = new JLabel("[Planning-to-watch Watchlist] : " + plannedToWatchTitles
                + " <Size> : " + watchList.getPlannedToWatch().size());
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JFrame viewWindow = new JFrame();
        panel.add(currLabel);
        panel.add(blank);
        panel.add(dropLabel);
        panel.add(blank2);
        panel.add(planLabel);
        viewWindow.add(panel);
        viewWindow.setVisible(true);
        viewWindow.setBounds(1080, 720,700,500);
    }

    // EFFECTS: returns the average rating in the selected watchlist category
    // otherwise returns -1 and a JOptionPane that advises the user
    private double avgListByCommand() {
        String input = JOptionPane.showInputDialog(this, "Which list are you trying to access:"
                + " 'currently-watching', 'dropped', or 'planning-to-watch'?");
        double avg = -1;
        if (input.equalsIgnoreCase("currently-watching")) {
            avg = watchList.averageRatingCurrentlyWatching();
        } else if (input.equalsIgnoreCase("dropped")) {
            avg = watchList.averageRatingDropped();
        } else if (input.equalsIgnoreCase("planning-to-watch")) {
            avg = watchList.averageRatingPlannedToWatch();
        } else {
            JOptionPane.showMessageDialog(null,"Attempt to average rating has failed");
        }
        return avg;
    }

    // EFFECTS: returns media object with the matching title, otherwise returns a new media object
    private Media processRating(List<Media> medias) {
        Media med = new Media();
        String title = JOptionPane.showInputDialog(this,
                "What is the title of the media you want to rate?");
        for (Media m : medias) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                med = m;
            }
        }
        JOptionPane.showMessageDialog(null,"Retrieved " + med.getTitle());
        return med;
    }

    // MODIFIES: Media med
    // EFFECTS: applies the rating to the media object with the matching title
    // otherwise shows JOptionPane with a message to advise the user
    private void addRating(Media med) {
        String input = JOptionPane.showInputDialog(this,
                "What is the rating you would like to apply?");
        double rating = Double.parseDouble(input);

        if (rating >= 0 && rating <= 100) {
            med.setRating(rating);
            JOptionPane.showMessageDialog(null,"A rating of " + med.getRating()
                    + " has been applied to " + med.getTitle());
        } else {
            JOptionPane.showMessageDialog(null, "Please input a valid rating between 0 and 100");
        }
    }

    // EFFECTS: return a watchlist field, otherwise shows JOptionPane with a message to advise the user
    public List<Media> getListByCommand() {
        List<Media> medias = new ArrayList<>();
        String input = JOptionPane.showInputDialog(this, "Which list are you trying to access:"
                + " 'currently-watching', 'dropped', or 'planning-to-watch'?");
        if (input.equalsIgnoreCase("currently-watching")) {
            medias = watchList.getCurrentlyWatching();
        } else if (input.equalsIgnoreCase("dropped")) {
            medias = watchList.getDropped();
        } else if (input.equalsIgnoreCase("planning-to-watch")) {
            medias = watchList.getPlannedToWatch();
        } else {
            JOptionPane.showMessageDialog(null,"Attempt to add media has failed");
        }
        return medias;
    }

    // MODIFIES: Media newMedia
    // EFFECTS: returns a media object with the user specified input
    private Media chooseMedia() {
        Media newMedia = new Media();
        String input = JOptionPane.showInputDialog(this, "What type of media are you adding?");

        if (input.equalsIgnoreCase("movie")) {
            newMedia.setMovie(true);
        } else {
            newMedia.setTVShow(true);
        }
        constructMedia(newMedia);
        return newMedia;
    }

    // MODIFIES: this
    // EFFECTS: helper method to call methods that specify new media object with desired user input
    private void constructMedia(Media newMedia) {
        processMediaTitle(newMedia);
        processMediaReleaseDate(newMedia);
        processMediaGenre(newMedia);
    }

    // REQUIRES: input.length() > 1
    // MODIFIES: this
    // EFFECTS: sets the user input as the genre of the media object
    private void processMediaGenre(Media newMedia) {
        String input = JOptionPane.showInputDialog(this,
                "What is the genre of the media you are adding?");
        newMedia.setGenre(input);
    }

    // REQUIRES: year >= 1700, month is in [1, 12], day is in [1, 31]
    // MODIFIES: this
    // EFFECTS: sets the user input as the genre of the media object
    private void processMediaReleaseDate(Media newMedia) {
        int year;
        int month;
        int day;
        String input = JOptionPane.showInputDialog(this,
                "What is the release year for the media you are adding?");
        try {
            year = Integer.parseInt(input);
            input = JOptionPane.showInputDialog(this,
                    "What is the release month for the media you are adding?");
            month = Integer.parseInt(input);
            input = JOptionPane.showInputDialog(this,
                    "What is the release day for the media you are adding?");
            day = Integer.parseInt(input);
            if (year < 1700 | month < 0 | month > 12 | day < 1 | day > 31) {
                numberFormatErrMsg();
            } else {
                newMedia.setReleaseDate(year, month, day);
            }
        } catch (NumberFormatException e) {
            numberFormatErrMsg();
        }
    }

    // EFFECTS: creates a JOptionPane that advises the user of actions to take
    private void numberFormatErrMsg() {
        JOptionPane.showMessageDialog(null, "Please try again. Year needs to be greater than 1700"
                + ", month needs to be between 1 and 12, and day should be between 1 and 31");
    }

    // REQUIRES: input.length() > 1
    // MODIFIES: this
    // EFFECTS: sets the user input as the title of the media object
    private void processMediaTitle(Media newMedia) {
        String input = JOptionPane.showInputDialog(this,
                "What is the title of the media you are adding?");
        newMedia.setTitle(input);
    }

    private void printLog(EventLog el) {
        for (Event e : el) {
            logScreen.setText(logScreen.getText() + e.toString());
        }
    }
}


