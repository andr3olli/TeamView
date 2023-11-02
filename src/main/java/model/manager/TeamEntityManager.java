package model.manager;

import model.Team;
import model.factory.TeamFactory;

import java.util.ArrayList;
import java.util.List;

public class TeamEntityManager {
    private List<Team> teams;
    private TeamFactory teamFactory;

    public TeamEntityManager() {
        this.teams = new ArrayList<>();
        this.teamFactory = new TeamFactory();
    }

    public void addTeam(String teamName){
        Team team = teamFactory.createTeam(teamName);
        teams.add(team);
    }

    public void removeTeam(Team team){
        teams.remove(team);
    }

    public List<Team> getAllTeam(){
        return new ArrayList<>(teams);
    }

}
