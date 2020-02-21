package gc171.hw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScannerTest {
    Scanner tmp = new Scanner(0, 0);

    @Test
    void checkBound() {
        Player rival = new Player(20, 10, "A", "B");
        Stack s0 = new Stack("G", "G", "A0H", 3);
        rival.addStack(s0);
        tmp.checkBound(rival, 10, 10);
        tmp.scan(rival);
    }

}