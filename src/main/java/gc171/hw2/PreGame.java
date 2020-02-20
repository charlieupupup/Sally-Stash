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
                if (judge.preFormat(self, input)) {
                    if (color.equals("G") || color.equals("P")) {
                        if (normalStack(self, color, i, input, blockNum)) {
                            break;
                        } else {
                            System.out.println("Invalid input");
                        }
                    } else if (color.equals("R")) {
                        if (redStack(self, color, i, input, blockNum)) {
                            break;

                        } else {
                            System.out.println("Invalid input");
                        }
                    } else if (color.equals("B")) {

                        if (blueStack(self, color, i, input, blockNum)) {
                            break;
                        } else {
                            System.out.println("Invalid input");
                        }
                    }
                } else {
                    System.out.println("Invalid input");
                }

            }
        }

    }


    //init red stack
    private Boolean redStack(Player self, String color, Integer i, String input, Integer blockNum) {
        if (!judge.crazyStackStateCheck(input.charAt(2))) {
            return false;
        }
        //check the stack fit or not
        String stackName = color + i;
        RedStack tmp = new RedStack(stackName, color, input, blockNum);
        if (judge.stackCheck(self, tmp)) {
            self.addStack(tmp);
            return true;
        }

        return false;
    }

    //init blue stack
    private Boolean blueStack(Player self, String color, Integer i, String input, Integer blockNum) {
        if (!judge.crazyStackStateCheck(input.charAt(2))) {
            return false;
        }
        //check the stack fit or not
        String stackName = color + i;
        BlueStack tmp = new BlueStack(stackName, color, input, blockNum);
        if (judge.stackCheck(self, tmp)) {
            self.addStack(tmp);
            return true;
        }

        return false;
    }

    //init normal stack
    private Boolean normalStack(Player self, String color, Integer i, String input, Integer blockNum) {
        if (!judge.normalStackStateCheck(input.charAt(2))) {
            return false;
        }
        //check the stack fit or not
        String stackName = color + i;
        Stack tmp = new Stack(stackName, color, input, blockNum);
        if (judge.stackCheck(self, tmp)) {
            self.addStack(tmp);
            return true;
        }

        return false;
    }


}
