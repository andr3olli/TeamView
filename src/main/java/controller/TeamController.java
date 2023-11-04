package controller;

import model.Team;
import model.manager.TeamEntityManager;
import view.HomeScreen;

import javax.swing.*;

public class TeamController {
    private TeamEntityManager teamManager;
    private HomeScreen homeScreen;

    public TeamController(TeamEntityManager teamManager, HomeScreen homeScreen){
        this.teamManager = teamManager;
        this.homeScreen = homeScreen;

        this.homeScreen.setTeamController(this);
        setupListeners();
    }

    private void setupListeners() {
        this.homeScreen.getAddButton().addActionListener(e -> handleClick());
    }

    public void updateTeamList(){
        homeScreen.updateTeamList();
    }
    private void handleClick() {
        String teamName = JOptionPane.showInputDialog(homeScreen, "Enter the team name:", "Add Team", JOptionPane.PLAIN_MESSAGE);
        if (teamName != null && !teamName.trim().isEmpty()) {
            // User entered a valid team name
            teamManager.addTeam(teamName.trim());
        }
    }

    public void addTeam(String teamName) {
        this.teamManager.addTeam(teamName);
    }

    public void removeTeam(Team team){
        teamManager.removeTeam(team);
    }


}
