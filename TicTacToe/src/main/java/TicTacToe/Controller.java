package TicTacToe;


import java.util.ArrayList;
import java.util.List;

public class Controller {
    public Game setUpGame() {

        Game game = new Game();

        String playerOneName =  game.askUserForPlayerName("Player One: ");
        String playerTwoName = game.askUserForPlayerName("Player Two: ");
        Player playerOne = new Player(playerOneName, 0);
        Player playerTwo = new Player(playerTwoName,  1);

        game.setPlayerOne(playerOne);
        game.setPlayerTwo(playerTwo);

        game.instantiateSpaces();

        return game;
    }

    public static void main(String [ ] args) {
        Controller gameController = new Controller();
        Game game = gameController.setUpGame();
        try {
            game.play();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        if (game.getPlayerOne().isVictoriousYet() || game.getPlayerTwo().isVictoriousYet()) {
            System.out.print("THE WINNER IS: ");
            System.out.print(game.getPlayerOne().isVictoriousYet() ? game.getPlayerOne().getPlayerName() : game.getPlayerTwo().getPlayerName());
        } else {
            System.out.println("The game ended in a tie :(");
        }

    }
}
