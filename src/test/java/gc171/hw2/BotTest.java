package gc171.hw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BotTest {

    @Test
    void initBotStack() {
        Bot tmp = new Bot(20, 10, "A", "B");
        tmp.initBotStack();

        Display dis = new Display();
        dis.game(tmp);

    }

    @Test
    void dig() {
        Bot botA = new Bot(20, 10, "A", "B");
        Bot botB = new Bot(20, 10, "B", "A");
        Display dis = new Display();

        for (Integer i = 0; i < 400; i++) {
            dis.game(botA);
            botA.dig(botA, botB);

            dis.game(botB);
            botB.dig(botB, botA);
        }

    }
}