package gc171.hw2;

import java.util.HashMap;

public class SelfBoard {
    //data for row & col
    private Integer rowNum;
    private Integer colNum;

    //map to store stack data
    private HashMap<String, Stack> board = new HashMap<>();

    //init
    public SelfBoard(int rowIn, int colIn) {
        rowNum = rowIn;
        colNum = colIn;
    }

    public Integer getRowNum() {
        return rowNum;
    }

    public Integer getColNum() {
        return colNum;
    }

    public HashMap<String, Stack> getBoard() {
        return board;
    }


    //generate output board
    public HashMap<Integer, String> genBoard() {
        HashMap<Integer, String> b = new HashMap<>();
        Integer curr = 0;
        //init map first
        for (Integer r = 0; r < this.getRowNum(); r++) {
            for (Integer c = 0; c < this.getColNum(); c++) {
                curr = r * this.getColNum() + c;
                b.put(curr, " ");
            }
        }
        //loop through HashMap
        for (String k : this.getBoard().keySet()) {
            Stack stack = this.getBoard().get(k);

            //get element
            HashMap<Integer, Block> eLists = stack.getElements();
            for (Integer i : eLists.keySet()) {
                Block tmp = eLists.get(i);
                Integer bRow = tmp.getRow();
                Integer bCol = tmp.getCol();
                curr = bRow * this.getRowNum() + bCol;
                if (b.get(curr).equals(" ")) {
                    b.put(curr, tmp.getColor());
                } else {
                    b.put(0, "error");
                }
            }
        }


        return b;
    }

    //check win
    public Boolean win() {
        Boolean res = true;

        for (String k : this.getBoard().keySet()) {
            res = res & this.getBoard().get(k).getHit();
        }

        return res;
    }

    //check add new stack
    public Boolean checkStack(Stack stack) {
        Boolean check = true;
        board.put(stack.getName(), stack);
        HashMap<Integer, String> tmp = genBoard();
        if (tmp.containsKey(0)) {
            String res = tmp.get(0);
            if (res.equals("error")) {

                check = false;
            }
        }
        board.remove(stack.getName());
        return check;
    }

    public void addStack(Stack stack) {
        board.put(stack.getName(), stack);
    }

}
