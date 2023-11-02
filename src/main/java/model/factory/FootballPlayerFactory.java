package model.factory;

import model.Contract;
import model.FootballPlayer;
import model.Position;

public class FootballPlayerFactory {
    public FootballPlayer createPlayer(int playerNumber, String name, int age, Position position, String nationality, String playstyle, Contract contract) {
        return new FootballPlayer(playerNumber, name, age, position, nationality, playstyle, contract);
    }
}
