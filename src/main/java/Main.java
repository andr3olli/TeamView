import controller.LoginController;
import controller.TeamController;
import view.HomeScreen;
import view.LoginScreen;
import model.manager.TeamEntityManager;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            TeamEntityManager teamManager = new TeamEntityManager();
            teamManager.addTeam("1. FC Köln");
            teamManager.addTeam("1. FC Köln II");

            HomeScreen homeScreen = new HomeScreen();

            homeScreen.setTeamManager(teamManager);

            // Create the controllers
            TeamController teamController = new TeamController(teamManager, homeScreen);
            // Set the controllers for the views

            homeScreen.setTeamController(teamController);

            homeScreen.setVisible(true);
        });

    }
}