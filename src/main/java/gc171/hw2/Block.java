package gc171.hw2;

/*
    layer 1

    the basic elements, block
    each block represents one dot
    this class contains the basie information:
        hit or not
        color
        coordinate in map

 */

public class Block {
    private Boolean hit;
    private String color;
    private Integer row;
    private Integer col;

    /*
        constructor
     */
    public Block(String color, Integer row, Integer col) {
        this.color = color;
        this.row = row;
        this.col = col;
        this.hit = false;
    }

    /*
        setter & getter

     */

    public void setCol(Integer col) {
        this.col = col;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getCol() {
        return col;
    }

    public Boolean getHit() {
        return hit;
    }

    public String getColor() {
        return color;
    }

    public void setHit(Boolean hit) {
        this.hit = hit;
    }

}
