package TicTacToe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {


    public void main(String[] args) {
        System.out.println("Hello World!");
    }

    private List<Space> gameBoxes = new ArrayList<Space>();

    public Game() {
    }

    public static void main() {
    }

    public List<Space> getGameBoxes() {
        return gameBoxes;
    }

    private TicTacToe.Player playerOne;
    private Player playerTwo;

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) { this.playerOne = playerOne; }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) { this.playerTwo = playerTwo; }

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


    public void takeTurn(int squareToSelect, Player player) {
        this.getGameBoxes().get(squareToSelect).setTeam(player.getIndex());
    }

    public  String askUserForPlayerName(String message) {

        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        System.out.print(message + "");
        return sc.nextLine(); //reads string.
    }

    public void play() throws Exception {
        this.getPlayerOne().setTurn(true);
        while (!this.getPlayerOne().isVictoriousYet() && !this.getPlayerTwo().isVictoriousYet() && !gameOver())  {
            Player currentPlayer = this.getNextPlayerUp();
            if (currentPlayer == null) {
                throw new Exception("Error: No player ready for turn");
            }

            processTurn(currentPlayer);
            this.getNextPlayerUp().setVictoriousYet(didUserWin(currentPlayer.getIndex()));
            changeTurn(currentPlayer);
            displayGrid();

        }

    }

    private boolean gameOver() {
        List<Space> boxes = this.getGameBoxes();
        for (int index = 0; index < boxes.size(); index++) {
            if (boxes.get(index).getTeam() == -1) {
                return false;
            }
        }
        return true;
    }

    private void displayGrid() {
        List<Space> grid = this.getGameBoxes();
        System.out.println(Space.getSymbol(grid.get(0))
                + "|" + Space.getSymbol(grid.get(1)) + "|" + Space.getSymbol(grid.get(2)));
        System.out.println("-----");
        System.out.println(Space.getSymbol(grid.get(3))
                + "|" + Space.getSymbol(grid.get(4)) + "|" + Space.getSymbol(grid.get(5)));
        System.out.println("-----");
        System.out.println(Space.getSymbol(grid.get(6))
                + "|" + Space.getSymbol(grid.get(7)) + "|" + Space.getSymbol(grid.get(8)));
    }


    private void changeTurn(Player currentPlayer) {
        if (this.getPlayerOne() == currentPlayer) {
            this.getPlayerOne().setTurn(false);
            this.getPlayerTwo().setTurn(true);
        } else {
            this.getPlayerOne().setTurn(true);
            this.getPlayerTwo().setTurn(false);
        }
    }

    private void processTurn(Player currentPlayer) {

        boolean choiceValidated = false;
        while (!choiceValidated) {
            //get users input for which square they want
            String selection = getTurnInput(currentPlayer);
            try {
                int selectionIndex = Integer.parseInt(selection);
                Space selectedSpace = this.getGameBoxes().get(selectionIndex-1);
                if (selectedSpace.getTeam() == -1) {
                    //Let's set it as their value
                    selectedSpace.setTeam(currentPlayer.getIndex());
                    choiceValidated = true;
                } else {
                    System.out.println("Error: That space has already been selected.");
                    //TODO list valid spaces
                }
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Error: Input not a number between 1-9.");
            }
        }
    }

    private String getTurnInput(Player currentPlayer) {
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        ;
        System.out.print(currentPlayer.getPlayerName() + " select the box you are choosing: ");
        return sc.nextLine(); //reads string.
    }

    private Player getNextPlayerUp() {
        if (this.getPlayerOne().getTurn()) {
            return this.getPlayerOne();
        } else if (this.getPlayerTwo().getTurn()) {
            return this.getPlayerTwo();
        } else {
            return null;
        }
    }
}
