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
}
