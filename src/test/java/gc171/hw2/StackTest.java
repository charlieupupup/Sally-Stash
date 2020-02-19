package gc171.hw2;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    public Stack stack = new Stack("G0", "G", "A0V", 3);

    @Test
    void getHit() {

        System.out.println(stack.getState());
        System.out.println(stack.getHit());
    }

    @Test
    void hasBlock() {
        System.out.println(stack.hasBlock(0, 0));
        stack.digBlock(0, 0);
        System.out.println(stack.hasBlock(0, 1));
        System.out.println(stack.hasBlock(1, 0));
        System.out.println(stack.hasBlock(2, 0));
    }

    @Test
    void digBlock() {
        Stack stack = new Stack("R0", "R", "B3H", 4);
        stack.digBlock(0,0);
        System.out.println(stack.getHit());
        stack.digBlock(0, 1);
        System.out.println(stack.getHit());
        stack.digBlock(1,0);
        System.out.println(stack.getHit());
        stack.digBlock(2,0);
        System.out.println(stack.getHit());

    }

    @Test
    void getElements() {
        HashMap<Integer, Block> ele = stack.getElements();
        for (Integer k : ele.keySet()) {
            System.out.println(ele.get(k).getRow());
            System.out.println(ele.get(k).getCol());
            System.out.println(ele.get(k).getRow());
            System.out.println(ele.get(k).getCol());

        }
    }

    @Test
    void setElements() {
        HashMap<Integer, Block> ele = stack.getElements();
        for (Integer k : ele.keySet()) {
            System.out.print(ele.get(k).getRow());
            System.out.print(ele.get(k).getCol());
            System.out.print(ele.get(k).getColor());
            System.out.println(ele.get(k).getHit());

        }

        Block b = new Block("r", 3, 9);
        stack.setElements(4, b);
        ele = stack.getElements();
        for (Integer k : ele.keySet()) {
            System.out.print(ele.get(k).getRow());
            System.out.print(ele.get(k).getCol());
            System.out.print(ele.get(k).getColor());
            System.out.println(ele.get(k).getHit());

        }

    }

    @Test
    void getName() {
        System.out.println(stack.getName());
    }

    @Test
    void getColor() {
        System.out.println(stack.getColor());
    }



    @Test
    void setCol() {
        stack.setRow(3);
    }

    @Test
    void setRow() {
        stack.setCol(3);
    }


}