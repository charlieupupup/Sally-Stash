package gc171.hw2;

import org.checkerframework.common.reflection.qual.NewInstance;
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


    @Test
    void setStack() {
        Stack s0 = new Stack("G0", "G", "A0V", 3);
        s0.setStack(5, 5, "H");
        s0.setElements();
        Stack s1 = new Stack("G0", "G", "A0H", 3);
        s1.setStack(5, 5, "V");
        s1.setElements();

        //blue
        BlueStack bU = new BlueStack("BU", "B", "A0U", 6);
        BlueStack bD = new BlueStack("BD", "B", "A0D", 6);
        BlueStack bL = new BlueStack("BL", "B", "A0L", 6);
        BlueStack bR = new BlueStack("BR", "B", "A0R", 6);

        bU.setStack(5,5, "U");
        bU.setElements();

        bD.setStack(5,5, "D");
        bD.setElements();

        bL.setStack(5,5, "L");
        bL.setElements();

        bR.setStack(5,5, "R");
        bR.setElements();



        //red

        RedStack RU = new RedStack("RU", "R", "A0U", 4);
        RedStack RD = new RedStack("RD", "R", "A0D", 4);
        RedStack RL = new RedStack("RL", "R", "A0L", 4);
        RedStack RR = new RedStack("RR", "R", "A0R", 4);

        RD.setStack(5, 5,"D");
        RD.setElements();

        RU.setStack(5, 5,"U");
        RU.setElements();

        RL.setStack(5, 5,"L");
        RL.setElements();


        RR.setStack(5, 5,"R");
        RR.setElements();

    }


}