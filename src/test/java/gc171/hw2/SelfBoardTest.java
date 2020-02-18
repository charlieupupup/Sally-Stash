package gc171.hw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelfBoardTest {
    SelfBoard selfBoard = new SelfBoard(20, 10);
    @Test
    void genBoard() {
    }

    @Test
    void getColor() {
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
    void addStack() {
    }

    @Test
    void digCheck() {
    }

    @Test
    void digBlock() {
    }

    @Test
    void loose() {
    }
}