package gc171.hw2;

import java.io.IOException;

public class PlayerRole {

    public Boolean isHuman(String player) throws IOException {

        Instruction instruction = new Instruction();
        instruction.role(player);
        String input;
        while (true) {
            input = instruction.prompt(System.in);
            if (input.equals("0")) {
                return true;
            } else if (input.equals("1")) {
                return false;
            } else {
                System.out.println("invalid input");
            }

        }
    }
}
