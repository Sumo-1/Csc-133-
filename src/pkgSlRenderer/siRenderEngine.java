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
