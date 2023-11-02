package model;


import model.manager.PlayerEntityManager;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    private PlayerEntityManager playerManager;

    // Constructor
    public Team(String teamName) {
        this.teamName = teamName;
        this.playerManager = new PlayerEntityManager();
    }

    public Team(String teamName, ArrayList<Object> objects) {
    }

    public void addPlayer(int playerNumber, String name, int age, Position position, String nationality, String playstyle, Contract contract){
        this.playerManager.addPlayer(playerNumber, name, age, position, nationality, playstyle, contract);
    }

    public void removePlayer(int playerId){
        this.playerManager.removePlayerById(playerId);
    }
    public void findPlayerByID(int playerId){
        System.out.println(this.playerManager.findPlayerById(playerId).toString());
    }

    public void printAllPlayer(){
        List<FootballPlayer> allPlayers = playerManager.getAllPlayers();

        for(FootballPlayer player : allPlayers){
            System.out.println(player.toString());
        }
    }


}
