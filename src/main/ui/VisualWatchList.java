package ui;

import model.WatchList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualWatchList extends JFrame implements ActionListener {
    private WatchList watchList;

    // EFFECTS: instantiates the object which will run the GUI for the user
    public VisualWatchList() {
        super();
        watchList = new WatchList();
        setTitle("myWatchList Application");
        setBounds(1080, 720,1080,720);
        setLayout(new FlowLayout());
        // Extract a helper method that initializes all buttons that I need
        JButton addButton = new JButton("Add media to WatchList");
        addButton.setActionCommand("add");
        addButton.addActionListener(this);
        JButton rateButton = new JButton("Rate media in WatchList");
        rateButton.setActionCommand("rate");
        rateButton.addActionListener(this);
        add(addButton);
        add(rateButton);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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


