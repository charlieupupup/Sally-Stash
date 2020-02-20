package gc171.hw2;

import java.util.HashMap;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;

/*
    judge system for the app

    check if movement valid or not

 */

public class Judge {
    public Instruction instruction = new Instruction();

    /*
        check input format

     */

    //check pre game input format
    public Boolean preFormat(Player player, String input) {
        if (input.length() != 3) {
            return false;
        }

        char c0 = input.charAt(0);
        char c1 = input.charAt(1);
        char c2 = input.charAt(2);

        return isLetter(c0) && isDigit(c1) && isLetter(c2);
    }

    //position check
    public Boolean normalStackStateCheck(char c) {
        return c == 'V' || c == 'H';
    }

    public Boolean crazyStackStateCheck(char c) {
        return c == 'U' || c == 'D' || c == 'L' || c == 'R';
    }

    //check game input format
    public Boolean gameFormat(String input) {
        //input only 1 letter
        if (input.length() != 1 || !isLetter(input.charAt(0))) {
            return false;
        }
        char c = input.charAt(0);
        return c == 'D' || c == 'M' || c == 'S';

    }

    public Boolean coordinateFormat(Player player, String input) {
        if (input.length() != 2) {
            return false;
        }

        char c0 = input.charAt(0);
        char c1 = input.charAt(1);

        return isLetter(c0) && isDigit(c1);
    }

    /*
        check gaming logic

     */
    //place stack
    public Boolean stackCheck(Player player, Stack stack) {
        return player.checkStack(stack);
    }

    //judge whether player dig a block
    public Boolean digCheck(Player player, Integer row, Integer col) {
        return player.digCheck(row, col);
    }

    //dig process
    public void digBlock(Player self, Player rival, String input) {
        //change input to upper case
        input = input.toUpperCase();
        //convert input to coordinate
        int stackRow = input.charAt(0) - 'A';
        int stackCol = Character.getNumericValue(input.charAt(1));

        //check if dig correct
        //update self board & rival board

        //hit update rival.selfBoard && self.onwBoard
        if (digCheck(rival, stackRow, stackCol)) {
            instruction.find();
            rival.digBlock(stackRow, stackCol);
            self.setRivalBoard(stackRow, stackCol, rival.getColor(stackRow, stackCol));
        }

        //only update self.rivalBoard
        else {
            instruction.miss();
            self.setRivalBoard(stackRow, stackCol, "x");
        }
    }

    //judge whether one player has win
    public Boolean win(Player rival) {
        return rival.loose();
    }

    //check game border
    public Boolean checkGame(Player player, String input) {
        input = input.toUpperCase();
        Integer row = input.charAt(0) - 'A';
        Integer col = Character.getNumericValue(input.charAt(1));
        return player.checkBound(row, col);
    }

}
