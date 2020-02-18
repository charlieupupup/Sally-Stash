package gc171.hw2;

import java.util.HashMap;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;

/*
    judge system for the app

    check if movement valid or not

 */

public class Judge {
    private Instruction instruction = new Instruction();
    /*
        check input format

     */
    //check pre game input
    public Boolean preFormat(Player player, String input) {
        if (input.length() != 3) {
            System.out.println("Invalid input");
            return false;
        }

        input = input.toUpperCase();

        char c0 = input.charAt(0);
        char c1 = input.charAt(1);
        char c2 = input.charAt(2);

        if (!isLetter(c0) || !isDigit(c1) || !isLetter(c2) || (c2 != 'V' && c2 != 'H')) {
            System.out.println(("Invalid input"));
            return false;
        }

        return true;
    }

    //check game input format
    public Boolean gameFormat(Player player, String input) {
        if (input.length() != 2) {
            System.out.println("Invalid input");
            return false;
        }

        char c0 = input.charAt(0);
        char c1 = input.charAt(1);

        if (!isLetter(c0) || !isDigit(c1)) {
            System.out.println(("Invalid input"));
            return false;
        }

        return true;
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
        return player.getSelfBoard().digCheck(row, col);
    }

    //dig process
    public void digBlock(Player self, Player rival, String input) {
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


}
