package gc171.hw2;

public class Player {
    private String playerName;
    //board
    private SelfBoard playerBoard;
    //tree
    private RivalBoard rivalBoard;

    //guess inform

    //display line

    void line() {
        System.out.println("curr line");
    }
    //display
    void screen() {
        //start
        System.out.println("Player " + playerName + "'s turn");

        //each line

        //end
    }

    //win
    public Boolean win() {
        return true;
    }
}
