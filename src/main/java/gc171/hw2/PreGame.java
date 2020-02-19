package gc171.hw2;

import java.io.IOException;

/*

    the class control game preparation process


 */

public class PreGame {
    Instruction instruction = new Instruction();
    Display display = new Display();
    Judge judge = new Judge();

    //game pre
    public void prepareGame(Player self) throws IOException {
        instruction.start(self.getPlayerName(), self.getRivalName());
        //green stack
        initStack(self, "G", 2, 2);
        //purple
        initStack(self, "P", 3, 3);
        //red
        initStack(self, "R", 4, 3);
        //blue
        initStack(self, "B", 6, 2);
    }

    //init stack
    public void initStack(Player self, String color, Integer blockNum, Integer stackNum) throws IOException {
        for (int i = 0; i < stackNum; i++) {
            //display
            display.pre(self);

            //read from input
            String input;
            while (true) {
                instruction.place(self.getPlayerName(), instruction.getOrders(i), instruction.getColors(color));
                input = instruction.prompt(System.in);

                //check the format
                if (judge.preFormat(self, input)) {
                    //check the stack fit or not
                    String stackName = color + i;
                    Stack tmp = new Stack(stackName, color, input, blockNum);
                    if (judge.stackCheck(self, tmp)) {
                        self.addStack(tmp);
                        break;
                    } else {
                        System.out.println("Invalid input");
                    }

                }
            }

        }

    }

}
