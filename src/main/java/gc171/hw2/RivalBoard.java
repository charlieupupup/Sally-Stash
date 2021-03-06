package gc171.hw2;

import java.util.HashMap;

/*
    layer 3

    rival board contains player guess on rival's board

 */

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
        for (int r = 0; r < rowNum; r++) {
            for (int c = 0; c < colNum; c++) {
                Integer pos = r * colNum + c;
                board.put(pos, " ");
            }
        }
    }

    //boundary check
    public Boolean boundCheck(Integer bRow, Integer bCol) {
        if (bRow < 0 || bCol < 0 || bRow >= this.getRowNum() || bCol >= this.getColNum()) {
            System.out.println("invalid input");
            return false;
        }
        return true;
    }
    /*
        setter & getter

     */

    public Integer getColNum() {
        return colNum;
    }

    public Integer getRowNum() {
        return rowNum;
    }

    public void setBoard(Integer row, Integer col, String status) {
        Integer pos = row * colNum + col;
        board.put(pos, status);

    }

    public HashMap<Integer, String> getBoard() {
        return this.board;
    }


}
