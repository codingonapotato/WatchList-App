package ui;

import model.WatchList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualWatchList extends JFrame implements ActionListener {
    private WatchList watchList;
    private JButton addButton;
    private JButton rateButton;
    private JButton avgButton;
    private JButton saveButton;
    private JButton loadButton;

    // EFFECTS: instantiates the object which will run the GUI for the user
    public VisualWatchList() {
        super();
        watchList = new WatchList();
        setTitle("myWatchList Application");
        setBounds(1080, 720,700,500);
        setLayout(new FlowLayout());
        prepareButtons();
        loadImage();
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        addButtons();
        setButtonActionCommands();
        addButtonActionListener();
        setVisible(true);
    }

    // EFFECTS: instantiate new JButton with the appropriate label
    private void makeButtons() {
        addButton = new JButton("Add media to WatchList");
        rateButton = new JButton("Rate media in WatchList");
        avgButton = new JButton("Calculate the average rating in a watchlist category");
        saveButton = new JButton("Save the state of the application");
    }

    // EFFECTS: adds all instantiated JButton to the GUI
    private void addButtons() {
        add(addButton);
        add(rateButton);
        add(avgButton);
        add(saveButton);
    }

    // EFFECTS: sets the ActionCommand for the specific JButton
    private void setButtonActionCommands() {
        addButton.setActionCommand("add");
        rateButton.setActionCommand("rate");
    }

    // EFFECTS adds an ActionListener object for the instantiated JButtons
    private void addButtonActionListener() {
        addButton.addActionListener(this);
        rateButton.addActionListener(this);
    }

    // EFFECTS: Handles and calls the proper methods depending on which button/event is initiated by the user
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("add")) {
            // Returns string
            JOptionPane.showInputDialog(this, "What is the name of the media you wish to add?");
            // Use at end to show that task completed successfully (potentially extract to helper method)
            JOptionPane.showMessageDialog(null,"Task completed successfully");
        } else {
            JOptionPane.showMessageDialog(null,"Yay!!!!!!!!");
        }
    }

    public static void main(String[] args) {
        VisualWatchList visualWatchList = new VisualWatchList();
    }
}


