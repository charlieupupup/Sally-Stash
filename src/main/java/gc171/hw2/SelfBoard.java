package gc171.hw2;

import java.util.HashMap;
/*
    layer 3

    self board is based on stack

    the collection of all player stack

 */

public class SelfBoard {
    //data for row & col
    private Integer rowNum;
    private Integer colNum;

    //map to store stack data
    private HashMap<String, Stack> stackList = new HashMap<>();

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

    public HashMap<String, Stack> getStackList() {
        return stackList;
    }

    //generate output board
    public HashMap<Integer, String> genBoard() {
        HashMap<Integer, String> b = new HashMap<>();
        //init map first
        Integer curr = 0;
        for (Integer r = 0; r < this.getRowNum(); r++) {
            for (Integer c = 0; c < this.getColNum(); c++) {
                curr = r * this.getColNum() + c;
                b.put(curr, " ");
            }
        }
        //loop through HashMap
        for (String k : this.getStackList().keySet()) {
            Stack stack = this.getStackList().get(k);

            //get element
            HashMap<Integer, Block> eLists = stack.getElements();
            for (Integer i : eLists.keySet()) {
                Block tmp = eLists.get(i);
                Integer bRow = tmp.getRow();
                Integer bCol = tmp.getCol();
                curr = bRow * this.getColNum() + bCol;
                if (tmp.getHit()) {
                    b.put(curr, "*");
                } else {
                    b.put(curr, tmp.getColor());
                }
            }
        }
        return b;
    }

    public String getColor(Integer row, Integer col) {
        String color = new String();
        for (String k : this.getStackList().keySet()) {
            Stack stack = this.getStackList().get(k);
            if (stack.hasBlock(row, col)) {
                color = stack.getColor();
            }
        }

        return color;
    }

    //boundary check
    public Boolean boundCheck(Stack stack) {

        HashMap<Integer, Block> blockLists = stack.getElements();
        for (Integer k : blockLists.keySet()) {
            Integer bRow = blockLists.get(k).getRow();
            Integer bCol = blockLists.get(k).getCol();

            if (bRow < 0 || bCol < 0 || bRow >= this.getRowNum() || bCol >= this.getColNum()) {
                return false;
            }
        }

        return true;
    }

    //conflict check
    public Boolean conflictCheck(Stack stack) {
        //init board for conflict detect
        HashMap<Integer, String> b = genBoard();

        //get stack elements
        HashMap<Integer, Block> elements = stack.getElements();

        for (Integer key : elements.keySet()) {
            Block tmp = elements.get(key);

            //check conflict with existing stack
            Integer bRow = tmp.getRow();
            Integer bCol = tmp.getCol();

            Integer curr = bRow * this.getColNum() + bCol;
            if (!b.get(curr).equals(" ")) {
                return false;
            }
        }
        return true;
    }

    //stack Check
    public Boolean stackCheck(Stack stack) {
        if (boundCheck(stack) && conflictCheck(stack)) {

            return true;

        }

        return false;
    }

    //add stack
    public void addStack(Stack stack) {
        stackList.put(stack.getName(), stack);
    }

    //dig check
    public Boolean digCheck(Integer bRow, Integer bCol) {
        //should check coordinate format somewhere else
        //input coordinate is correct
        //loop through stack
        HashMap<String, Stack> stacks = getStackList();

        for (String k : stacks.keySet()) {
            Stack currStack = stacks.get(k);
            if (currStack.hasBlock(bRow, bCol)) {
                return true;
            }
        }

        return false;
    }

    //dig block
    public void digBlock(Integer row, Integer col) {
        HashMap<String, Stack> stacks = getStackList();

        for (String k : stacks.keySet()) {
            Stack currStack = stacks.get(k);
            currStack.digBlock(row, col);
        }

    }


    //check if you loose or not
    public Boolean loose() {
        Boolean res = true;

        for (String k : this.getStackList().keySet()) {
            res = res & this.getStackList().get(k).getHit();
        }

        return res;
    }


}
