import view.HomeScreen;
import view.LoginScreen;
import model.manager.TeamEntityManager;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            TeamEntityManager teamManager = new TeamEntityManager();
            teamManager.addTeam("1.FC Köln");
            teamManager.addTeam("Bayern München");

            HomeScreen homeScreen = new HomeScreen(teamManager);
            LoginScreen loginScreen = new LoginScreen();

            loginScreen.setVisible(true);
        });

    }
}