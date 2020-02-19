package gc171.hw2;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class RivalBoardTest {

    RivalBoard rivalBoard = new RivalBoard(20, 10);

    @Test
    void getColNum() {
        System.out.println(rivalBoard.getColNum());
    }

    @Test
    void getRowNum() {
        System.out.println(rivalBoard.getRowNum());
    }

    @Test
    void setBoard() {
        rivalBoard.setBoard(0, 0 , "X");
    }

    @Test
    void boundCheck() {
        rivalBoard.boundCheck(0, 0);
        System.out.println(rivalBoard.boundCheck(20, 0));
    }

    @Test
    void getBoard() {
        HashMap<Integer, String> tmp = rivalBoard.getBoard();
    }
}