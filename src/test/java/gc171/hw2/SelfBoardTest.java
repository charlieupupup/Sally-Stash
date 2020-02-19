package gc171.hw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelfBoardTest {
    SelfBoard selfBoard = new SelfBoard(20, 10);

    @Test
    void getColor() {
        Stack stack = new Stack("G0", "G", "A0H", 2);
        selfBoard.addStack(stack);
        System.out.println(selfBoard.getColor(0, 0));
    }

    @Test
    void stackCheck() {
        Stack s0 = new Stack("g0", "G", "M3V", 3);
        System.out.println(selfBoard.stackCheck(s0));
        selfBoard.addStack(s0);

        Stack s1 = new Stack("g1", "G", "M3V", 3);
        System.out.println(selfBoard.stackCheck(s1));
    }

    @Test
    void digCheck() {
        Stack s0 = new Stack("g0", "G", "A0V", 3);
        selfBoard.addStack(s0);
        System.out.println(selfBoard.digCheck(0, 0));
        System.out.println(selfBoard.digCheck(30,0));
        System.out.println(selfBoard.digCheck(3, 0));

        Stack s1 = new Stack("R0", "R", "Z3V", 3);
        System.out.println(selfBoard.boundCheck(s1));
    }

    @Test
    void digBlock() {
        Stack s0 = new Stack("g0", "G", "A0V", 3);
        selfBoard.addStack(s0);
        if (selfBoard.digCheck(0, 0)) {
            selfBoard.digBlock(0, 0);
        }
        selfBoard.genBoard();
    }

    @Test
    void loose() {
        System.out.println(selfBoard.loose());
        Stack s0 = new Stack("g0", "G", "M3V", 3);

        selfBoard.addStack(s0);
        System.out.println(selfBoard.loose());
    }
}