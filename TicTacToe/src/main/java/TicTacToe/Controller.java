package TicTacToe;


import java.util.ArrayList;
import java.util.List;

public class Controller {
    public Game startGame() {

        Player playerOne = new Player("Kyle", 0);
        Player playerTwo = new Player("The Chainsmokers",  1);



        Game g = new Game();
        g.setPlayerOne(playerOne);
        g.setPlayerTwo(playerTwo);

        //g.instantiateSpaces();

        return g;
    }

    public void main(String[] args) {


    }


}
