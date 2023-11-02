package model.manager;

import exceptions.DuplicatePlayerException;
import model.Contract;
import model.FootballPlayer;
import model.Position;
import model.factory.FootballPlayerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class PlayerEntityManager {
    private List<FootballPlayer> players;
    private FootballPlayerFactory playerFactory;

    public PlayerEntityManager() {
        this.players = new ArrayList<>();
        this.playerFactory = new FootballPlayerFactory();
    }

    public void addPlayer(int playerNumber, String name, int age, Position position, String nationality, String playstyle, Contract contract) {
        if (isPlayerNumberUnique(playerNumber)) {
            FootballPlayer player = playerFactory.createPlayer(playerNumber, name, age, position, nationality, playstyle, contract);
            players.add(player);
        } else {
            throw new DuplicatePlayerException("Player with Number " + playerNumber + " already exists. Choose a different ID.");
        }
    }

    public void removePlayerById(int playerId) {
        boolean removed = players.removeIf(player -> player.getPlayerNumber() == playerId);

        if (!removed) {
            throw new NoSuchElementException("Player with ID " + playerId + " not found.");
        }
    }

    public FootballPlayer findPlayerById(int playerId) {
        return players.stream().filter(player -> player.getPlayerNumber() == playerId)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Player with ID" + playerId + " not found."));
    }

    public List<FootballPlayer> getAllPlayers() {
        return new ArrayList<>(players);
    }

    private boolean isPlayerNumberUnique(int playerNumber) {
        return players.stream().noneMatch(player -> player.getPlayerNumber() == playerNumber);
    }

}
