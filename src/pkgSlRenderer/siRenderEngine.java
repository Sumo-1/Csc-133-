package pkgSlRenderer;

import pkgSlUtils.siWindowManager;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.Random;

public class siRenderEngine {

    public void render() {
        // Set up the rendering panel
        siWindowManager.get().setRenderPanel(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Clear the panel (set background to black)
                setBackground(Color.BLACK
                );



                // Draw multiple circles at random postions
                Random rand = new Random();
                for (int i = 0; i < 100; i++) {// Draw 10 circles
                    int x = rand.nextInt(getWidth() -50); // Random x postion
                    int y = rand.nextInt(getHeight() -50); // Random y postion
                    int diameter = 50; // Fixed diamter for each circle
                    Color randomColor = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
                    g.setColor(randomColor); // set random color
                    g.fillOval(x, y, diameter, diameter); // Draw the cricle
                }
            }
        });

        // Start the render loop (using Swing's repaint mechanism)
        siWindowManager.get().startRenderLoop();
    }
}
