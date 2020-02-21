package gc171.hw2;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PreGameTest {
    PreGame test = new PreGame();

    @Test
    void prepareGame() throws IOException {
        Bot botA = new Bot(20, 10, "A", "B");
        test.prepareGame(botA);
    }

    @Test
    void format() {
        Player player = new Player(20, 10, "A", "B");
        test.format(player, "A0H", "G", 0, 2);
        test.format(player, "A0V", "G", 0, 2);
        test.format(player, "A0C", "G", 0, 2);


        test.format(player, "A0H", "P", 0, 2);
        test.format(player, "A0V", "P", 0, 2);
        test.format(player, "A0M", "P", 0, 2);


        test.format(player, "A0U", "R", 0, 2);
        test.format(player, "A0D", "R", 0, 2);
        test.format(player, "A0L", "R", 0, 2);
        test.format(player, "A0R", "R", 0, 2);
        test.format(player, "A0H", "R", 0, 2);

        test.format(player, "A0U", "B", 0, 2);
        test.format(player, "A0D", "B", 0, 2);
        test.format(player, "A0R", "B", 0, 2);
        test.format(player, "A0L", "B", 0, 2);
        test.format(player, "A0H", "B", 0, 2);

        test.format(player, "A0H", "T", 0, 2);

    }
}