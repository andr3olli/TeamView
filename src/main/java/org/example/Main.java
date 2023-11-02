package org.example;

import gui.HomeScreen;
import gui.LoginScreen;
import model.Contract;
import model.Position;
import model.Team;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Team testTeam = new Team("1.FC Köln");
        testTeam.addPlayer(1,"Adam", 22, Position.GOALKEEPER, "Germany", "Hunter", new Contract("Pro", 2, 2222));
        testTeam.addPlayer(2,"Peter", 21, Position.DEFENDER, "Germany", "Hawk", new Contract("Amateur", 1, 122));

        testTeam.printAllPlayer();

        SwingUtilities.invokeLater(() -> {
            HomeScreen homeScreen = new HomeScreen();
            LoginScreen loginScreen = new LoginScreen(homeScreen);
            loginScreen.setVisible(true);
        });

    }
}