package model.manager;

import model.Team;
import model.factory.TeamFactory;
import model.observer.TeamObserver;

import java.util.ArrayList;
import java.util.List;

public class TeamEntityManager {
    private List<Team> teams;
    private List<TeamObserver> observers;
    private TeamFactory teamFactory;

    public TeamEntityManager() {
        this.teams = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.teamFactory = new TeamFactory();
    }

    public void addObserver(TeamObserver observer){
        observers.add(observer);
    }

    public void removeObserver(TeamObserver observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        for (TeamObserver observer : observers) {
            observer.update();
        }
    }
    // methods to manage teams (addTeam, removeTeam, etc.)
    public void addTeam(String teamName){
        Team team = teamFactory.createTeam(teamName);
        teams.add(team);
        notifyObservers();
    }

    public void removeTeam(Team team){
        teams.remove(team);
    }

    public List<Team> getAllTeams(){
        return new ArrayList<>(teams);
    }

}
