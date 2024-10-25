package pkgSlUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class siWindowManager {

    private JFrame window;
    private JPanel renderPanel;
    private static siWindowManager instance = null;

    // Private constructor for Singleton pattern
    private siWindowManager() {}

    // Static method to get the single instance of the class
    public static siWindowManager get() {
        if (instance == null) {
            instance = new siWindowManager();
        }
        return instance;
    }
    // Initialize the Swing window
    public void initWindow(int width, int height, String title) {
        // Create the main window
        window = new JFrame(title);
        window.setSize(width, height);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
