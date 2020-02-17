package gc171.hw2;

public class Player {
    private String playerName;
    //board
    private SelfBoard selfBoard;
    //tree
    private RivalBoard rivalBoard;

    //guess inform
    public Player(Integer row, Integer col, String playerName) {
        this.selfBoard = new SelfBoard(row, col);
        this.rivalBoard = new RivalBoard(row, col);
        this.playerName = playerName;
    }


    public String getPlayerName() {
        return playerName;
    }


    public RivalBoard getRivalBoard() {
        return rivalBoard;
    }

    public SelfBoard getSelfBoard() {
        return selfBoard;
    }

    //win
    public Boolean win() {
        return this.selfBoard.win();
    }

    //place stack
    public Boolean checkStack(Stack stack) {
        return this.selfBoard.checkStack(stack);
    }

    public void placeStack(Stack stack) {
        this.selfBoard.addStack(stack);
    }
}
