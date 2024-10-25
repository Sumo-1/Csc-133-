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
    // Set the rendering panel
    public void setRenderPanel(JPanel panel) {
        this.renderPanel = panel;
        window.add(panel);
        window.revalidate();
    }
    // Start a simple render loop
    public void startRenderLoop(int frameDelay) {
        // Use a Timer to trigger repaint events (simple render loop)
        Timer timer = new Timer(frameDelay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (renderPanel != null) {
                    renderPanel.repaint();
                }
            }
        });
        timer.start();
    }
}