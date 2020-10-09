package TicTacToe;


import java.util.ArrayList;
import java.util.List;

public class Controller {
    public Game startGame() {







        Game g = new Game();

        String playerOneName =  "Kyle" ;//g.askUserForPlayerName("Player One: ");
        String playerTwoName = "The Chainsmokers" ;//g.askUserForPlayerName("Player One: ");

        Player playerOne = new Player(playerOneName, 0);
        Player playerTwo = new Player(playerTwoName,  1);

        g.setPlayerOne(playerOne);
        g.setPlayerTwo(playerTwo);

        //g.instantiateSpaces();

        return g;
    }

    public static void main(String [ ] args) {
        Controller gameController = new Controller();
        gameController.startGame();
    }


}
