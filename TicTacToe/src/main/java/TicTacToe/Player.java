package TicTacToe;

import java.util.Scanner;

public class Player {
    private int wins;
    private int losses;
    private boolean isVictoriousYet;
    private String playerName;
    private boolean turn;
    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Player(String playerName, int index) {
        this.playerName = playerName;
        this.index = index;
        this.isVictoriousYet = false;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public boolean isVictoriousYet() {
        return isVictoriousYet;
    }

    public void setVictoriousYet(boolean victoriousYet) {
        isVictoriousYet = victoriousYet;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setTurn(boolean b) {
        this.turn = b;
    }

    public boolean getTurn() {
        return turn;
    }

    public void endTurn() {
        this.setTurn(false);
    }

}
