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
    public Boolean loose() {
        return this.selfBoard.loose();
    }

    //return certain block color
    public String getColor(Integer row, Integer col) {
        return selfBoard.getColor(row, col);
    }
    //update self board
    public void digBlock(Integer row, Integer col) {
        selfBoard.digBlock(row,col);
    }

    //update rival board
    public void setRivalBoard(Integer row, Integer col, String status) {
        rivalBoard.setBoard(row, col, status);
    }

    //place stack
    public Boolean checkStack(Stack stack) {
        return this.selfBoard.stackCheck(stack);
    }

    public void addStack(Stack stack) {
        this.selfBoard.addStack(stack);
    }
}
