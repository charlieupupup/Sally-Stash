package gc171.hw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlockTest {

    @Test
    void setCol() {
        Block b = new Block("G", 10, 20);
        b.setCol(10);
    }

    @Test
    void getRow() {
        Block b = new Block("G", 10, 20);
        b.getRow();
    }

    @Test
    void setRow() {
        Block b = new Block("G", 10, 20);
        b.setRow(15);
    }

    @Test
    void setColor() {
        Block b = new Block("G", 10, 20);
        b.setCol(10);
        b.setColor("B");
    }

    @Test
    void getCol() {
        Block b = new Block("G", 10, 20);
        b.setCol(10);
        System.out.println(b.getCol());
    }

    @Test
    void getHit() {
        Block b = new Block("G", 10, 20);
        b.setCol(10);
        System.out.println(b.getHit());
    }

    @Test
    void getColor() {
        Block b = new Block("G", 10, 20);
        b.setCol(10);
        System.out.println(b.getColor());
    }

    @Test
    void setHit() {
        Block b = new Block("G", 10, 20);
        System.out.println(b.getHit());

        b.setHit(true);
        System.out.println(b.getHit());
    }
}