package gc171.hw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovementTest {
    Movement mov = new Movement(0, 0);

    @Test
    void getTargetRow() {
        mov.setTarget(0, 0, "H");
        mov.getTargetRow();
        mov.getTargetCol();
        mov.getTargetState();

    }

    @Test
    void validateSrc() {
        Player player = new Player(20, 10, "A", "B");
        Stack s0 = new Stack("G", "G", "A0H", 3);
        player.addStack(s0);

        mov.setTarget(3, 3, "H");

        mov.setTarget(0, 0, "H");
        mov.validateSrc(player);
        mov.checkStack(player);
        mov.conflictCheck(player);
        mov.mvStack(player);

    }

    @Test
    void validateTar() {
    }

    @Test
    void checkBound() {
    }

    @Test
    void checkStack() {
    }

    @Test
    void conflictCheck() {
    }

    @Test
    void mvStack() {
    }
}