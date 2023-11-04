package manager;

import javax.swing.*;

public class NavigationManager {
    private static NavigationManager instance;
    private JFrame currentFrame;
    private NavigationManager() {

    }

    public static NavigationManager getInstance() {
        if (instance == null) {
            instance = new NavigationManager();
        }
        return instance;
    }

    public void navigateTo(JFrame destinationFrame) {
        if (currentFrame != null) {
            currentFrame.dispose();
        }

        currentFrame = destinationFrame;
        currentFrame.setVisible(true);
    }
}
