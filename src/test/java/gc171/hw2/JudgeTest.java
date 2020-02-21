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
        System.out.println(judge.preFormat(player, "0"));
        System.out.println(judge.preFormat(player, "333"));
    }

    @Test
    void gameFormat() {
        judge.gameFormat("0");
        judge.gameFormat("Aa");
        judge.gameFormat("d");
        judge.coordinateFormat(player, "a");
        judge.coordinateFormat(player, "a0");
        Judge tmp = new Judge();


    }

    @Test
    void stackCheck() {
        Stack s0 = new Stack("s0", "G", "A3H", 2);
        System.out.println(judge.stackCheck(player, s0));

        player.addStack(s0);
        System.out.println(judge.stackCheck(player, s0));
    }

    @Test
    void digCheck() {
        System.out.println(judge.digCheck(player, 0, 0));
        Stack s0 = new Stack("s0", "G", "A0H", 2);
        player.addStack(s0);
        System.out.println(judge.digCheck(player, 0, 0));

    }

    @Test
    void digBlock() {
        Player rival = new Player(20, 20, "B", "A");
        judge.digBlock(player, rival, "a0");
        Stack s = new Stack("g0", "G", "A0H", 3);
        rival.addStack(s);
        judge.digBlock(player, rival, "a0");
    }

    @Test
    void win() {
        System.out.println(judge.win(player));
        Stack s = new Stack("g0", "G", "A0H", 3);
        player.addStack(s);
        System.out.println(judge.win(player));
    }

    @Test
    void checkGame() {
        judge.checkGame(player, "a0");
    }
}