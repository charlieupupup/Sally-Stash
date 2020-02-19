package gc171.hw2;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class InstructionTest {

    Instruction test = new Instruction();
    Player p = new Player(20, 10, "A", "B");
    @Test
    void pre() {
        test.pre(p);
    }

    @Test
    void preCol() {
        test.preCol(p);
    }

    @Test
    void preScreen() {
        test.preScreen(p);
    }

    @Test
    void game() {
        test.game(p);
    }

    @Test
    void gameCol() {
        test.gameCol(p);
    }

    @Test
    void gameScreen() {
        test.gameScreen(p);
    }

    @Test
    void printColNum() {
        test.printColNum(10);
    }


    @Test
    void getOrders() {
        System.out.println(test.getOrders(0));
    }

    @Test
    void getColors() {
        System.out.println(test.getColors("G"));
    }

    @Test
    void start() {
        test.start("A", "B");
    }

    @Test
    void place() {
        test.place("A", "1", "Green");
    }

    @Test
    void gameHead() {
        test.gameHead("A", "B");
    }

    @Test
    void dig() {
        test.dig();
    }

    @Test
    void prompt() throws IOException {
        String initialString = "123";
        InputStream targetStream = new ByteArrayInputStream(initialString.getBytes());
        test.prompt(targetStream);
    }

    @Test
    void hyphen() {
        test.hyphen();
    }

    @Test
    void find() {
        test.find();
    }

    @Test
    void win() {
        test.win("A");
    }

    @Test
    void miss() {
        test.miss();
    }

    @Test
    void gameLine() {
        test.gameLine(p, 10);
    }

    @Test
    void printLine() {
        HashMap<Integer, String> boardInfo = new HashMap<>();
        Integer currRow = 0;
        Integer colNum = 0;
        test.printLine(boardInfo, currRow, colNum);
    }
}