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
        initStack(self, "B", 6, 3);
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
                input = input.toUpperCase();

                //check the format
                if (judge.preFormat(self, input) && format(self, input, color, i, blockNum)) {
                    break;
                } else {
                    System.out.println("invalid input");
                }

            }

            //the format is valid
            //init correspond stack according to colors
            if (color.equals("G") || color.equals("P")) {
                String stackName = color + i;
                Stack tmp = new Stack(stackName, color, input, blockNum);
                self.addStack(tmp);
            }

            //if red
            if (color.equals("R")) {
                String stackName = color + i;
                RedStack tmp = new RedStack(stackName, color, input, blockNum);
                self.addStack(tmp);
            }

            //if blue
            if (color.equals("B")) {
                String stackName = color + i;
                BlueStack tmp = new BlueStack(stackName, color, input, blockNum);
                self.addStack(tmp);
            }

        }

    }

    //check pre game input
    public Boolean format(Player self, String input, String color, Integer i, Integer blockNum) {
        if (judge.preFormat(self, input)) {
            switch (color) {
                case "G":
                case "P":
                    return normalStack(self, color, i, input, blockNum);
                case "R":
                    return redStack(self, color, i, input, blockNum);
                case "B":
                    return blueStack(self, color, i, input, blockNum);
            }
        }

        return false;
    }

    //init red stack
    private Boolean redStack(Player self, String color, Integer i, String input, Integer blockNum) {
        if (!judge.crazyStackStateCheck(input.charAt(2))) {
            return false;
        }
        //check the stack fit or not
        String stackName = color + i;
        RedStack tmp = new RedStack(stackName, color, input, blockNum);
        return judge.stackCheck(self, tmp);
    }

    //init blue stack
    private Boolean blueStack(Player self, String color, Integer i, String input, Integer blockNum) {
        if (!judge.crazyStackStateCheck(input.charAt(2))) {
            return false;
        }
        //check the stack fit or not
        String stackName = color + i;
        BlueStack tmp = new BlueStack(stackName, color, input, blockNum);
        return judge.stackCheck(self, tmp);
    }

    //init normal stack
    private Boolean normalStack(Player self, String color, Integer i, String input, Integer blockNum) {
        if (!judge.normalStackStateCheck(input.charAt(2))) {
            return false;
        }
        //check the stack fit or not
        String stackName = color + i;
        Stack tmp = new Stack(stackName, color, input, blockNum);
        return judge.stackCheck(self, tmp);
    }


}
