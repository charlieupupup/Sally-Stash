package gc171.hw2;

/*
    layer 4

    player contains all information:
        self board
        dig on rival board

 */

public class Player {
    private String playerName;
    private String rivalName;
    //board
    private SelfBoard selfBoard;
    //tree
    private RivalBoard rivalBoard;

    //guess inform
    public Player(Integer row, Integer col, String playerName, String rivalName) {
        this.selfBoard = new SelfBoard(row, col);
        this.rivalBoard = new RivalBoard(row, col);
        this.playerName = playerName;
        this.rivalName = rivalName;
    }


    public String getPlayerName() {
        return playerName;
    }

    public String getRivalName() {
        return rivalName;
    }

    public RivalBoard getRivalBoard() {
        return rivalBoard;
    }

    public SelfBoard getSelfBoard() {
        return selfBoard;
    }

    //win
    public Boolean win() {
        return this.selfBoard.loose();
    }

    //place stack
    public Boolean checkStack(Stack stack) {
        return this.selfBoard.stackCheck(stack);
    }

    public void addStack(Stack stack) {
        this.selfBoard.addStack(stack);
    }
}
