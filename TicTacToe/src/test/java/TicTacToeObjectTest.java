import TicTacToe.Controller;
import TicTacToe.Game;
import TicTacToe.Space;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TicTacToeObjectTest {


    @Test
    public void checkThatClassInitiazationIsSuccessfulTest() throws Exception {
        //creating game object
        Game game = new Game();

    }

    @Test
    public void verifyThatGameArrayIsLengthNine() {
        Game game = new Game();

        game.instantiateSpaces();

        assertEquals(9,game.getGameBoxes().size());
    }

    @Test
    public void assignSpaceToTeamOneTest() {
        Space space = new Space();

        space.setTeam(1);

        assertEquals(1, space.getTeam());
    }

    @Test
    public void initiateSpaceToZeroTest() {
        Game game = new Game();

        game.instantiateSpaces();

        assertEquals(0, game.getGameBoxes().get(0).getTeam());
    }

    @Test
    public void checkForWinTest() {
        Game game = new Game();

        game.instantiateSpaces();

        game.getGameBoxes().get(0).setTeam(1);
        game.getGameBoxes().get(1).setTeam(1);
        game.getGameBoxes().get(2).setTeam(1);

        boolean didUserWin = game.didUserWin(1);

        assertEquals(true, didUserWin);

    }

    @Test
    public void checkForWinDiagonalTest() {
        Game game = new Game();

        game.instantiateSpaces();

        game.getGameBoxes().get(0).setTeam(1);
        game.getGameBoxes().get(4).setTeam(1);
        game.getGameBoxes().get(8).setTeam(1);

        boolean didUserWin = game.didUserWin(1);

        assertEquals(true, didUserWin);

    }

    @Test
    public void userHasntWonYetTest() {
        Game game = new Game();

        game.instantiateSpaces();

        game.getGameBoxes().get(0).setTeam(1);
        game.getGameBoxes().get(5).setTeam(1);
        game.getGameBoxes().get(8).setTeam(1);

        boolean didUserWin = game.didUserWin(1);

        assertEquals(false, didUserWin);

    }

    @Test
    public void startControllerLogicTest() {
        Controller c = new Controller();

        Game g = c.startGame();

        assertEquals("Kyle", g.getPlayerOne().getPlayerName());

    }


}
