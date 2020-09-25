package TicTacToe;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Game {


    private List<Space> gameBoxes = new ArrayList<Space>();

    public Game(List<Space> gameBoxes) {
        this.gameBoxes = gameBoxes;
    }

    public List<Space> getGameBoxes() {
        return gameBoxes;
    }

    public void setGameBoxes(List<Space> gameBoxes) {
        this.gameBoxes = gameBoxes;
    }

    public void instantiateSpaces() {
        List<Space> newGameBoxes = new ArrayList<Space>();

        for (int x = 0; x < 9; x++) {
            newGameBoxes.add(new Space());
        }

        this.gameBoxes = newGameBoxes;
    }

    public boolean didUserWin(int i) {
        int box0 = this.getGameBoxes().get(0).getTeam();
        int box1 = this.getGameBoxes().get(1).getTeam();
        int box2 = this.getGameBoxes().get(2).getTeam();
        int box3 = this.getGameBoxes().get(3).getTeam();
        int box4 = this.getGameBoxes().get(4).getTeam();
        int box5 = this.getGameBoxes().get(5).getTeam();
        int box6 = this.getGameBoxes().get(6).getTeam();
        int box7 = this.getGameBoxes().get(7).getTeam();
        int box8 = this.getGameBoxes().get(8).getTeam();

        boolean didWin = false;

        if (box0 == i && box1 == i && box2 == i) {
            return true;
        } else if (box3 == i && box4 == i && box5 == i) {
            return true;
        } else if (box6 == i && box7 == i && box8 == i) {
            return true;
        } else if (box0 == i && box3 == i && box6 == i) {
          return true;
        } else if (box1 == i && box4 == i && box7 == i) {
            return true;
        } else if (box2 == i && box5 == i && box8 == i) {
            return true;
        } else if (box0 == i && box4 == i && box8 == i) {
            return true;
        } else if (box2 == i && box4 == i && box6 == i) {
            return true;
        }

        return didWin;

    }
}
