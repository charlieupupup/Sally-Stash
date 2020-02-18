package gc171.hw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JudgeTest {

    Player player = new Player(20, 10, "A", "B");
    Instruction ins = new Instruction();
    Display display = new Display();
    Judge judge = new Judge();

    @Test
    void preFormat() {
        System.out.println(judge.preFormat(player, "A3h"));
    }

    @Test
    void gameFormat() {
    }
}