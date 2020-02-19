package gc171.hw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayTest {
    Player p = new Player(20, 10, "A", "B");

    Display d = new Display();
    @Test
    void pre() {
        d.pre(p);
    }


    @Test
    void game() {
        d.game(p);
    }

    @Test
    void gameCol() {
        d.game(p);
    }


    @Test
    void gameScreen() {
        d.gameScreen(p);
    }


    @Test
    void getOrders() {
        d.getOrders(0);
    }

    @Test
    void getColors() {
        d.getColors("c");
    }

    @Test
    void start() {
        d.start("A", "B");
    }

    @Test
    void place() {
        d.place("A", "B", "C");
    }

    @Test
    void gameHead() {
        d.gameHead("A", "B");
    }

    @Test
    void dig() {
        d.dig();
    }


    @Test
    void hyphen() {
        d.hyphen();
    }

    @Test
    void find() {
        d.find();
    }

    @Test
    void win() {
        d.win("A");
    }

    @Test
    void miss() {
        d.miss();
    }
}