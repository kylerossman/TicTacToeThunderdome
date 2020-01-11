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
        Game game = new Game(new ArrayList<Space>());
    }

    @Test
    public void verifyThatGameArrayIsLengthNine() {
        Game game = new Game(new ArrayList<Space>());

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
        Game game = new Game(new ArrayList<Space>());

        game.instantiateSpaces();

        assertEquals(0, game.getGameBoxes().get(0).getTeam());
    }

}
