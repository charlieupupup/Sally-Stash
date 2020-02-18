package gc171.hw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    Integer row = 20;
    Integer col = 10;
    private Player playerA = new Player(row, col, "A", "B");;
    private Player playerB = new Player(row, col, "B", "A");;
    private Instruction instruction = new Instruction();
    private Display display = new Display();
    private Judge judge = new Judge();

    @Test
    void main() {
        initStack(this.playerA);
    }

    @Test
    void setPlayer() {

        display.pre(this.playerA);
        display.pre(this.playerA);
        display.game(this.playerA);
        display.game(this.playerB);
    }

    @Test
    void gamePre() {
    }

    @Test
    void initStack(Player player) {

    }

    @Test
    void game() {
    }
}