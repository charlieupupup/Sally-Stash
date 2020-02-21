package gc171.hw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player = new Player(20, 10, "A", "B");
    Instruction ins = new Instruction();
    Display display = new Display();
    Judge judge = new Judge();

    @Test
    void checkStack() {
        Stack s0 = new Stack("g0", "G", "M0V", 3);
        System.out.println(judge.stackCheck(player, s0));
        player.addStack(s0);
        display.preScreen(player);

        Stack s1 = new Stack("g1", "G", "M3V", 3);
        System.out.println(judge.stackCheck(player, s1));
        player.addStack(s1);
        display.preScreen(player);

        Stack s2 = new Stack("g2", "G", "A0H", 3);
        System.out.println(judge.stackCheck(player, s2));
        player.addStack(s2);
        display.preScreen(player);

        Stack s3 = new Stack("g3", "G", "T7H", 3);
        System.out.println(judge.stackCheck(player, s3));
        player.addStack(s3);
        display.preScreen(player);

        //invalid
        Stack s4 = new Stack("g4", "G", "T8H", 3);
        System.out.println(judge.stackCheck(player, s4));

        Stack s5 = new Stack("g5", "G", "S0V", 3);
        System.out.println(judge.stackCheck(player, s5));


        Stack s6 = new Stack("g5", "G", "A7H", 3);
        System.out.println(judge.stackCheck(player, s6));

        Stack s7 = new Stack("g5", "G", "A8H", 3);
        System.out.println(judge.stackCheck(player, s7));


        Stack s8 = new Stack("g5", "G", "R9V", 3);
        System.out.println(judge.stackCheck(player, s8));

    }

    @Test
    void addStack() {
        Stack stack = new Stack("G0", "G", "A0V", 2);
        player.checkStack(stack);
        if(player.checkStack(stack)) {
            player.addStack(stack);
        }
    }

    @Test
    void getPlayerName() {
        Player tmp = new Player(20, 10, "A", "B");
        System.out.println(player.getPlayerName());
    }

    @Test
    void getRivalBoard() {
        System.out.println(player.getRivalName());
        player.getSelfBoard();
        player.getRivalBoard();

        player.getColor(0, 0);
    }


    @Test
    void loose() {
        System.out.println(player.loose());

        Stack stack = new Stack("G0", "G", "A0V", 2);
        if(player.checkStack(stack)) {
            player.addStack(stack);
        }
        System.out.println(player.loose());
    }


    @Test
    void digBlock() {
        Stack stack = new Stack("G0", "G", "A0V", 2);
        player.checkStack(stack);
        if(player.checkStack(stack)) {
            player.addStack(stack);
        }
        if(player.digCheck(0, 0)) {
            player.digBlock(0, 0);
        }

        System.out.println(player.digCheck(3,3));

    }

    @Test
    void setRivalBoard() {
        player.setRivalBoard(0, 0 , "X");
    }


    @Test
    void checkBound() {
        player.checkBound(0, 0);
        player.getStack(0, 0);
        player.getMvNum();
        player.getSonarNum();
        player.setMvNum(0);
        player.setSonarNum(0);

    }
}