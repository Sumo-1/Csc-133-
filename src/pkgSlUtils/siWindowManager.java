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