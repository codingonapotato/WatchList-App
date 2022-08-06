package ui;

import model.Media;
import model.WatchList;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualWatchList extends JFrame implements ActionListener {
    private static final String JSON_SAVE_DESTINATION = "./data/watchlist.json";
    private WatchList watchList;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private JButton addButton;
    private JButton rateButton;
    private JButton avgButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton cwButton;
    private JButton drButton;
    private JButton ptwButton;

    // EFFECTS: instantiates the object which will run the GUI for the user
    public VisualWatchList() {
        super();
        init();
        setTitle("myWatchList Application");
        setBounds(1080, 720,700,500);
        setLayout(new FlowLayout());
        prepareButtons();
        loadImage();
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        loadButton = new JButton("Load the state of the application");
        // Watchlist category buttons
        cwButton = new JButton("Currently-watching watchlist");
        drButton = new JButton("Dropped watchlist");
        ptwButton = new JButton("Planned-to-watch watchlist");
    }

    // EFFECTS: adds starting menu JButtons to the GUI
    private void addStartingButtons() {
        add(addButton);
        add(rateButton);
        add(avgButton);
        add(saveButton);
        add(loadButton);
    }

    // EFFECTS: sets the ActionCommand for the specific JButton
    private void setButtonActionCommands() {
        addButton.setActionCommand("add");
        rateButton.setActionCommand("rate");
        cwButton.setActionCommand("curr");
        drButton.setActionCommand("drop");
        ptwButton.setActionCommand("plan");
    }

    // EFFECTS adds an ActionListener object for the instantiated JButtons
    private void addButtonActionListener() {
        addButton.addActionListener(this);
        rateButton.addActionListener(this);
        avgButton.addActionListener(this);
        saveButton.addActionListener(this);
        loadButton.addActionListener(this);
        cwButton.addActionListener(this);
        drButton.addActionListener(this);
        ptwButton.addActionListener(this);
    }

    // EFFECTS: creates a JOptionPane with a message dialog box that indicates that a task was completed successfully
    private void taskCompletedPane() {
        JOptionPane.showMessageDialog(null,"Task completed successfully");
    }

    // EFFECTS: Handles and calls the proper methods depending on which button/event is initiated by the user
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("add")) {
            doAddList();
        } else if (e.getActionCommand().equalsIgnoreCase("rate")) {
            taskCompletedPane();
        } else if (e.getActionCommand().equalsIgnoreCase("avg")) {
            taskCompletedPane();
        } else if (e.getActionCommand().equalsIgnoreCase("curr")) {
            taskCompletedPane();
            JOptionPane.showMessageDialog(null,"curr");
        } else if (e.getActionCommand().equalsIgnoreCase("drop")) {
            taskCompletedPane();
            JOptionPane.showMessageDialog(null,"drop");
        } else if (e.getActionCommand().equalsIgnoreCase("plan")) {
            taskCompletedPane();
        } else {
            taskCompletedPane();
        }
    }

    // TODO:
    private void doAddList() {
        Media newMedia = chooseMedia();
        removeStartingButtons();
        addCategoryListButtons();
    }

    // EFFECTS: adds JButtons related to watchlist categories to the GUI
    private void addCategoryListButtons() {
        add(cwButton);
        add(drButton);
        add(ptwButton);
        setVisible(true);
    }

    // EFFECTS: removes the starting menu JButtons from the GUI
    private void removeStartingButtons() {
        remove(addButton);
        remove(rateButton);
        remove(saveButton);
        remove(loadButton);
        remove(avgButton);
        setVisible(false);
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
        String input = JOptionPane.showInputDialog(this, "What is the genre of the media you are adding?");
        newMedia.setGenre(input);
    }

    // REQUIRES: year >= 1700, month is in [1, 12], day is in [1, 31]
    // MODIFIES: this
    // EFFECTS: sets the user input as the genre of the media object
    private void processMediaReleaseDate(Media newMedia) {
        String input = JOptionPane.showInputDialog(this, "What is the release year for the media you are adding?");
        int year = Integer.parseInt(input);
        input = JOptionPane.showInputDialog(this, "What is the release month for the media you are adding?");
        int month = Integer.parseInt(input);
        input = JOptionPane.showInputDialog(this, "What is the release day for the media you are adding?");
        int day = Integer.parseInt(input);
        newMedia.setReleaseDate(year, month, day);
    }

    // REQUIRES: input.length() > 1
    // MODIFIES: this
    // EFFECTS: sets the user input as the title of the media object
    private void processMediaTitle(Media newMedia) {
        String input = JOptionPane.showInputDialog(this, "What is the title of the media you are adding?");
        newMedia.setTitle(input);
    }
}


