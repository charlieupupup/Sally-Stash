package gc171.hw2;

import java.util.HashMap;

public class RivalBoard {
    //data for row & col
    private Integer rowNum;
    private Integer colNum;
    private HashMap<Integer, String> board = new HashMap<>();

    //init
    public RivalBoard(int rowIn, int colIn) {
        rowNum = rowIn;
        colNum= colIn;
    }

    public void setBoard(HashMap<Integer, String> board) {
        this.board = board;
        Judge res = new Judge();
        Integer pos = 0;
        if (res.dig()) {
            board.put(pos, "*");
        }
        else {
            board.put(pos, "x");
        }
    }

    public HashMap<Integer, String> getBoard() {
        return board;
    }


}
