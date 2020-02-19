package gc171.hw2;

/*

    basic scan block


 */
public class ScanBlock {
    private Integer row;
    private Integer col;

    //constructor
    public ScanBlock(Integer row, Integer col) {
        this.row = row;
        this.col = col;
    }

    /*

        setter & getter


     */

    public void setRow(Integer row) {
        this.row = row;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public Integer getCol() {
        return col;
    }

    public Integer getRow() {
        return row;
    }


}
