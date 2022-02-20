package TicTacToe;

public class Space {
    private int team;

    public Space() {
        this.team = -1;
    }

    public static String getSymbol(Space space) {
        switch (space.getTeam()) {
            case 0:
                return "X";
            case 1:
                return "0";
            case -1:
                return " ";
        }
        return " ";

    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }



}
