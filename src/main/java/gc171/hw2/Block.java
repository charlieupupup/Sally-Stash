package gc171.hw2;

public class Block {
    private Boolean hit;
    private String color;
    private Integer row;
    private Integer col;

    public Block(String color, Integer row, Integer col) {
        this.color = color;
        this.row = row;
        this.col = col;
        this.hit = false;
    }

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
