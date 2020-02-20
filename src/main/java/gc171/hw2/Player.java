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
    private Integer row;
    private Integer col;

    //special moves
    private Integer mvNum;
    private Integer sonarNum;

    //player inform
    public Player(Integer row, Integer col, String playerName, String rivalName) {
        this.selfBoard = new SelfBoard(row, col);
        this.rivalBoard = new RivalBoard(row, col);
        this.playerName = playerName;
        this.rivalName = rivalName;
        this.row = row;
        this.col = col;

        mvNum = 3;
        sonarNum = 3;
    }


    //win
    public Boolean loose() {
        return this.selfBoard.loose();
    }

    //update self board
    public void digBlock(Integer row, Integer col) {
        selfBoard.digBlock(row, col);
    }

    public Boolean digCheck(Integer row, Integer col) {
        return selfBoard.digCheck(row, col);
    }


    //place stack
    public Boolean checkStack(Stack stack) {
        return selfBoard.stackCheck(stack);
    }

    public void addStack(Stack stack) {
        selfBoard.addStack(stack);
    }

    public Boolean checkBound(Integer row, Integer col) {
        return rivalBoard.boundCheck(row, col);
    }

    /*
        setter & getter

     */

    //return certain block color
    public String getColor(Integer row, Integer col) {
        return selfBoard.getColor(row, col);
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

    //update rival board
    public void setRivalBoard(Integer row, Integer col, String status) {
        rivalBoard.setBoard(row, col, status);
    }


    public SelfBoard getSelfBoard() {
        return selfBoard;
    }

    public Integer getRow() {
        return row;
    }

    public Integer getCol() {
        return col;
    }

    //return stack name according to coordinate
    //must have validate coordinate
    public Stack getStack(Integer row, Integer col) {
        return selfBoard.getStack(row, col);
    }

    public Integer getMvNum() {
        return mvNum;
    }

    public Integer getSonarNum() {
        return sonarNum;
    }

    public void setMvNum(Integer mvNum) {
        this.mvNum = mvNum;
    }

    public void setSonarNum(Integer sonarNum) {
        this.sonarNum = sonarNum;
    }
}
