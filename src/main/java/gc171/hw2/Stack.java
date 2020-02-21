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

        //if vertical, then row++
        if (state.equals("V")) {
            for (Integer i = 0; i < this.blockNum; i++) {
                Integer eleRow = this.getRow() + i;
                Integer eleCol = this.getCol();
                Block tmp = new Block(this.getColor(), eleRow, eleCol);
                setElements(i, tmp);
            }
        }

        //if horizontal, col++
        if (state.equals("H")) {
            for (int i = 0; i < this.blockNum; i++) {
                Integer eleRow = this.getRow();
                Integer eleCol = this.getCol() + i;
                Block tmp = new Block(this.getColor(), eleRow, eleCol);
                setElements(i, tmp);
            }
        }
    }


    //refresh block location
    public void setElements() {
        String state = this.getState();

        //if vertical, then row++
        if (state.equals("V")) {
            for (Integer i = 0; i < this.blockNum; i++) {
                Integer eleRow = this.getRow() + i;
                Integer eleCol = this.getCol();

                //recalculate
                Block curr = elements.get(i);
                curr.setRow(eleRow);
                curr.setCol(eleCol);
            }
        }

        //if horizontal, col++
        if (state.equals("H")) {
            for (int i = 0; i < this.blockNum; i++) {
                Integer eleRow = this.getRow();
                Integer eleCol = this.getCol() + i;

                //recalculate
                Block curr = elements.get(i);
                curr.setRow(eleRow);
                curr.setCol(eleCol);

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

    //check if input coordinate match a block
    public Boolean hasBlock(Integer row, Integer col) {
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
        //loop through elements
        for (Integer e : elements.keySet()) {
            Block curr = elements.get(e);
            Integer blockRow = curr.getRow();
            Integer blockCol = curr.getCol();

            //find it, then set hit
            if (row.equals(blockRow) && col.equals(blockCol)) {
                curr.setHit(true);
            }
        }

    }

    /*

        setter & getter


     */

    public HashMap<Integer, Block> getElements() {
        return elements;
    }

    public void setElements(Integer blockNum, Block block) {
        elements.put(blockNum, block);
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

    public void setRow(Integer row) {
        this.row = row;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setStack(Integer row, Integer col, String state) {
        this.row = row;
        this.col = col;
        this.state = state;
        setElements();
    }

}

/*

    super stack extend from stack

    override the init method


 */

class RedStack extends Stack {

    public RedStack(String stackName, String stackColor, String insn, Integer blockNum) {
        super(stackName, stackColor, insn, blockNum);
    }

    @Override
    public void setElements() {
        //if up
        if (getState().equals("U")) {
            //get block0
            Block b0 = getElements().get(0);
            b0.setRow(getRow());
            b0.setCol(getCol());


            for (Integer i = 1; i < 4; i++) {

                Integer eleRow = this.getRow() + 1;
                Integer eleCol = this.getCol() + i - 2;

                //refresh block coordinate
                Block tmp = getElements().get(i);
                tmp.setRow(eleRow);
                tmp.setCol(eleCol);
            }
        }

        //if right
        if (getState().equals("R")) {

            //get block3
            Block b3 = getElements().get(3);
            b3.setRow(getRow() + 1);
            b3.setCol(getCol() + 1);

            for (Integer i = 0; i < 3; i++) {
                Integer eleRow = this.getRow() + i;
                Integer eleCol = this.getCol();

                //refresh block coordinate
                Block tmp = getElements().get(i);
                tmp.setRow(eleRow);
                tmp.setCol(eleCol);
            }
        }

        //if down
        if (getState().equals("D")) {
            //get block3
            Block b3 = getElements().get(3);
            b3.setRow(getRow() + 1);
            b3.setCol(getCol() + 1);


            for (Integer i = 0; i < 3; i++) {
                Integer eleRow = this.getRow();
                Integer eleCol = this.getCol() + i;

                //refresh block coordinate
                Block tmp = getElements().get(i);
                tmp.setRow(eleRow);
                tmp.setCol(eleCol);
            }
        }

        //if left
        if (getState().equals("L")) {
            //get block3
            Block b3 = getElements().get(3);
            b3.setRow(getRow() + 1);
            b3.setCol(getCol() - 1);


            for (Integer i = 0; i < 3; i++) {
                Integer eleRow = this.getRow() + i;
                Integer eleCol = this.getCol();
                //refresh block coordinate
                Block tmp = getElements().get(i);
                tmp.setRow(eleRow);
                tmp.setCol(eleCol);
            }
        }
    }


    @Override
    public void initElements() {
        //if up
        if (getState().equals("U")) {
            Block base = new Block(this.getColor(), getRow(), getCol());
            setElements(0, base);

            for (Integer i = 1; i < 4; i++) {
                Integer eleRow = this.getRow() + 1;
                Integer eleCol = this.getCol() + i - 2;
                Block tmp = new Block(this.getColor(), eleRow, eleCol);
                setElements(i, tmp);
            }
        }

        //if right
        if (getState().equals("R")) {
            Block b3 = new Block(this.getColor(), getRow() + 1, getCol() + 1);
            setElements(3, b3);

            for (Integer i = 0; i < 3; i++) {
                Integer eleRow = this.getRow() + i;
                Integer eleCol = this.getCol();
                Block tmp = new Block(this.getColor(), eleRow, eleCol);
                setElements(i, tmp);
            }
        }

        if (getState().equals("D")) {
            Block b3 = new Block(this.getColor(), getRow() + 1, getCol() + 1);
            setElements(3, b3);

            for (Integer i = 0; i < 3; i++) {
                Integer eleRow = this.getRow();
                Integer eleCol = this.getCol() + i;
                Block tmp = new Block(this.getColor(), eleRow, eleCol);
                setElements(i, tmp);
            }
        }

        if (getState().equals("L")) {
            Block b3 = new Block(this.getColor(), getRow() + 1, getCol() - 1);
            setElements(3, b3);

            for (Integer i = 0; i < 3; i++) {
                Integer eleRow = this.getRow() + i;
                Integer eleCol = this.getCol();
                Block tmp = new Block(this.getColor(), eleRow, eleCol);
                setElements(i, tmp);
            }
        }
    }
}

/*

    Blue crazy stacks, extend from stack

    override the init method


 */

class BlueStack extends Stack {

    public BlueStack(String stackName, String stackColor, String insn, Integer blockNum) {
        super(stackName, stackColor, insn, blockNum);
    }

    @Override
    public void setElements() {
        //if up
        if (getState().equals("U")) {
            for (Integer i = 0; i < 3; i++) {
                Integer eleRow = this.getRow() + i;
                Integer eleCol = this.getCol();

                //refresh block
                Block tmp = getElements().get(i);
                tmp.setRow(eleRow);
                tmp.setCol(eleCol);

            }
            for (Integer i = 3; i < 6; i++) {
                Integer eleRow = this.getRow() + i - 1;
                Integer eleCol = this.getCol() + 1;

                //refresh block
                Block tmp = getElements().get(i);
                tmp.setRow(eleRow);
                tmp.setCol(eleCol);
            }
        }

        //if right
        if (getState().equals("R")) {
            for (Integer i = 0; i < 3; i++) {
                Integer eleRow = this.getRow();
                Integer eleCol = this.getCol() + i;

                //refresh block
                Block tmp = getElements().get(i);
                tmp.setRow(eleRow);
                tmp.setCol(eleCol);
            }
            for (Integer i = 3; i < 6; i++) {
                Integer eleRow = this.getRow() - 1;
                Integer eleCol = this.getCol() + i - 1;

                //refresh block
                Block tmp = getElements().get(i);
                tmp.setRow(eleRow);
                tmp.setCol(eleCol);
            }
        }

        if (getState().equals("D")) {
            for (Integer i = 0; i < 3; i++) {
                Integer eleRow = this.getRow() + i;
                Integer eleCol = this.getCol();

                //refresh block
                Block tmp = getElements().get(i);
                tmp.setRow(eleRow);
                tmp.setCol(eleCol);
            }
            for (Integer i = 3; i < 6; i++) {
                Integer eleRow = this.getRow() + i - 1;
                Integer eleCol = this.getCol() - 1;

                //refresh block
                Block tmp = getElements().get(i);
                tmp.setRow(eleRow);
                tmp.setCol(eleCol);
            }
        }

        if (getState().equals("L")) {
            for (Integer i = 0; i < 3; i++) {
                Integer eleRow = this.getRow();
                Integer eleCol = this.getCol() + i;

                //refresh block
                Block tmp = getElements().get(i);
                tmp.setRow(eleRow);
                tmp.setCol(eleCol);
            }
            for (Integer i = 3; i < 6; i++) {
                Integer eleRow = this.getRow() + 1;
                Integer eleCol = this.getCol() + i - 1;

                //refresh block
                Block tmp = getElements().get(i);
                tmp.setRow(eleRow);
                tmp.setCol(eleCol);
            }
        }


    }

    @Override
    public void initElements() {
        //if up
        if (getState().equals("U")) {
            for (Integer i = 0; i < 3; i++) {
                Integer eleRow = this.getRow() + i;
                Integer eleCol = this.getCol();
                Block tmp = new Block(this.getColor(), eleRow, eleCol);
                setElements(i, tmp);
            }
            for (Integer i = 3; i < 6; i++) {
                Integer eleRow = this.getRow() + i - 1;
                Integer eleCol = this.getCol() + 1;
                Block tmp = new Block(this.getColor(), eleRow, eleCol);
                setElements(i, tmp);
            }
        }

        //if right
        if (getState().equals("R")) {
            for (Integer i = 0; i < 3; i++) {
                Integer eleRow = this.getRow();
                Integer eleCol = this.getCol() + i;
                Block tmp = new Block(this.getColor(), eleRow, eleCol);
                setElements(i, tmp);
            }
            for (Integer i = 3; i < 6; i++) {
                Integer eleRow = this.getRow() - 1;
                Integer eleCol = this.getCol() + i - 1;
                Block tmp = new Block(this.getColor(), eleRow, eleCol);
                setElements(i, tmp);
            }
        }

        if (getState().equals("D")) {
            for (Integer i = 0; i < 3; i++) {
                Integer eleRow = this.getRow() + i;
                Integer eleCol = this.getCol();
                Block tmp = new Block(this.getColor(), eleRow, eleCol);
                setElements(i, tmp);
            }
            for (Integer i = 3; i < 6; i++) {
                Integer eleRow = this.getRow() + i - 1;
                Integer eleCol = this.getCol() - 1;
                Block tmp = new Block(this.getColor(), eleRow, eleCol);
                setElements(i, tmp);
            }
        }

        if (getState().equals("L")) {
            for (Integer i = 0; i < 3; i++) {
                Integer eleRow = this.getRow();
                Integer eleCol = this.getCol() + i;
                Block tmp = new Block(this.getColor(), eleRow, eleCol);
                setElements(i, tmp);
            }
            for (Integer i = 3; i < 6; i++) {
                Integer eleRow = this.getRow() + 1;
                Integer eleCol = this.getCol() + i - 1;
                Block tmp = new Block(this.getColor(), eleRow, eleCol);
                setElements(i, tmp);
            }
        }
    }
}