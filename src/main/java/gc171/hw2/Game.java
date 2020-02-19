package gc171.hw2;

import java.io.IOException;

/*

    the class control the main game logic


 */
public class Game {
    Instruction instruction = new Instruction();
    Display display = new Display();
    Judge judge = new Judge();

    //game
    public void exeGame(Player self, Player rival) throws IOException {
        instruction.dig();
        String input;

        //check input format
        while (true) {
            display.game(self);
            input = instruction.prompt(System.in);
            if (judge.gameFormat(self, input) && judge.checkGame(self, input)) {
                break;
            }
        }

        //check if hit or not
        judge.digBlock(self, rival, input);

    }
}
