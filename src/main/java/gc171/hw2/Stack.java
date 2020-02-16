package gc171.hw2;

import java.util.ArrayList;

public class Stack {
    private String name;
    private Integer row;
    private Integer col;
    private String color;
    private String state;


    public Stack(String stackName, String stackColor, Integer stackRow, Integer stackCol, String state) {
        name = stackName;
        color = stackColor;
        row = stackRow;
        col = stackCol;
        this.state = state;
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
    public ArrayList<Integer> getPos(Integer rowNum, Integer colNum) {
        ArrayList<Integer> pos = new ArrayList<>();
        return pos;
    }
}

class GreenStack extends Stack {

    public GreenStack(String stackName, String stackColor, Integer stackRow, Integer stackCol, String state) {
        super(stackName, stackColor, stackRow, stackCol, state);
    }

    public ArrayList<Integer> getPos(Integer rowNum, Integer colNum) {
        ArrayList<Integer> pos = new ArrayList<>();
        String state = this.getState();

        if (state.equals("V")) {
            for (int i = this.getRow(); i < 2; i++) {
                 Integer tmp = this.getRow() * colNum + this.getCol() + i;
                 pos.add(tmp);
            }
        }

        if (state.equals("H")) {
            for (int i = this.getRow(); i < 2; i++) {
                Integer tmp = (this.getRow() + i) * colNum + this.getCol();
                pos.add(tmp);
            }
        }

        return pos;

    }
}