package model;

public class FootballPlayer {

    private int playerNumber;
    private String name;
    private int age;
    private Position position;
    private String nationality;
    private String playstyle;
    private Contract contract;

    // Constructor
    public FootballPlayer(int playerNumber, String name, int age, Position position, String nationality, String playstyle, Contract contract) {
        this.playerNumber = playerNumber;
        this.name = name;
        this.age = age;
        this.position = position;
        this.nationality = nationality;
        this.playstyle = playstyle;
        this.contract = contract;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    @Override
    public String toString() {
        return "FootballPlayer{" +
                "playerNumber=" + playerNumber +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", nationality='" + nationality + '\'' +
                ", playstyle='" + playstyle + '\'' +
                ", contract=" + contract.toString() +
                '}';
    }
}
