package model.factory;

import model.Team;

import java.util.ArrayList;

public class TeamFactory {
    public Team createTeam(String teamName){
        return new Team(teamName, new ArrayList<>());
    }
}
