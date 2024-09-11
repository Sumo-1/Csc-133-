package pkgDriver;

import pkgSlRenderer.siRenderEngine;
import pkgSlUtils.siWindowManager;

public class csc133Driver {

    public static void main(String[] my_args) {
        // Create an instance of the render engine
        siRenderEngine my_re = new siRenderEngine();

        // Initialize the window manager and create a Swing window
        siWindowManager.get().initWindow(800, 800, "CSUS CSC133");

        // Start the rendering loop
        my_re.render();
    }
}
