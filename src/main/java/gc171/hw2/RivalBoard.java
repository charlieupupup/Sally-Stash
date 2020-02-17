package gc171.hw2;

import java.util.ArrayList;
import java.util.HashMap;

public class RivalBoard {
    //data for row & col
    private Integer rowNum;
    private Integer colNum;
    private HashMap<Integer, String> board = new HashMap<>();

    //init
    public RivalBoard(int rowIn, int colIn) {
        rowNum = rowIn;
        colNum = colIn;

        //inti board
        for(int r = 0; r < rowNum; r++) {
            for (int c = 0; c < colNum; c++) {
                Integer pos = r * colNum + c;
                board.put(pos, " ");
            }
        }
    }

    public Integer getColNum() {
        return colNum;
    }

    public Integer getRowNum() {
        return rowNum;
    }

    public void setBoard(SelfBoard b, Integer row, Integer col) {
        Judge res = new Judge();
        Integer pos = row * colNum + col;
        board.remove(pos);

        if (res.dig(b, row, col)) {
            board.put(pos, "*");
        } else {
            board.put(pos, "x");
        }
    }

    //boundary check
    public Boolean boundCheck(Integer bRow, Integer bCol) {
        if (bRow < 0 || bCol < 0 || bRow >= this.getRowNum() || bCol >= this.getColNum()) {
            return false;
        }
        return true;
    }

    public HashMap<Integer, String> getBoard() {
        return this.board;
    }


}
