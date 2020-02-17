package gc171.hw2;

import java.util.HashMap;

/*
    layer 2

    Stack is based on block
    1 stack is the collection of all blocks it contains

 */

public class Stack {
    private String name;
    private Integer row;
    private Integer col;
    private Integer blockNum;
    private Boolean hit;
    private String color;
    private String state;
    private HashMap<Integer, Block> elements = new HashMap<>();


    /*
        constructor

     */

    public Stack(String stackName, String stackColor, String insn, Integer blockNum) {
        char r = insn.charAt(0);
        char state = insn.charAt(2);

        int stackRow = r - 'A';
        int stackCol = Character.getNumericValue(insn.charAt(1));

        name = stackName;
        color = stackColor;
        this.row = stackRow;
        this.col = stackCol;
        this.state = String.valueOf(state);
        this.blockNum = blockNum;
        initElements();
    }


    //according to the state & block num
    //it through to init blocks
    public void initElements() {
        String state = this.getState();
        if (state.equals("V")) {
            for (Integer i = this.getRow(); i < this.blockNum; i++) {
                Integer eleRow = this.getRow();
                Integer eleCol = this.getCol() + i;
                Block tmp = new Block(this.getColor(), eleRow, eleCol);
                this.setElements(i, tmp);
            }
        }

        if (state.equals("H")) {
            for (int i = this.getRow(); i < this.blockNum; i++) {
                Integer eleRow = this.getRow() + i;
                Integer eleCol = this.getCol();
                Block tmp = new Block(this.getColor(), eleRow, eleCol);
                this.setElements(i, tmp);
            }
        }
    }

    //check if whole stack hit or not
    public Boolean getHit() {
        Boolean tmp = true;

        //loop through to see if all blocks hit or not
        for (Integer key : elements.keySet()) {

            tmp = tmp && elements.get(key).getHit();
        }
        //update the information
        this.hit = tmp;
        return this.hit;
    }

    //check dig
    public Boolean digCheck(Integer row, Integer col) {
        //loop through all blocks
        for (Integer e : elements.keySet()) {
            Block curr = elements.get(e);
            Integer blockRow = curr.getRow();
            Integer blockCol = curr.getCol();

            //if match return true
            if (row.equals(blockRow) && col.equals(blockCol)) {
                return true;
            }
        }

        //if no match return false
        return false;
    }

    //dig block
    public void digBlock(Integer row, Integer col) {
        for (Integer e : elements.keySet()) {
            Block curr = elements.get(e);
            Integer blockRow = curr.getRow();
            Integer blockCol = curr.getCol();

            if (row.equals(blockRow) && col.equals(blockCol)) {
                curr.setHit(true);
            }
        }

    }

    public HashMap<Integer, Block> getElements() {
        return elements;
    }

    public void setElements(Integer blockNum, Block block) {
        this.elements.put(blockNum, block);
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public Integer getCol() {
        return col;
    }

    public Integer getRow() {
        return row;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setBlockNum(Integer blockNum) {
        this.blockNum = blockNum;
    }
}

