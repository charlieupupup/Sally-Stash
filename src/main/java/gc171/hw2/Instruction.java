package gc171.hw2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;


public class Instruction {
    void start(String player) {
        System.out.println(
                "Player " + player + ", you are going place Sally’s stash on the board. Make sure Player B isn’t\n" +
                "looking! For each stack, type the coordinate of the upper left side of the stash,\n" +
                "followed by either H (for horizontal) or V (for vertical). For example, M4H would \n" +
                "place a stack horizontally starting at M4 and going to the right. You have\n" +
                "2 Green stacks that are 1x2\n" +
                "3 Purple stacks that are 1x3\n" +
                "3 Red stacks that are 1x4\n" +
                "2 Blue stacks that are 1x6");
    }

    //ask for input
    void ask(String name) {
        System.out.println("Player" + name + ", where do you want to place the first Green stack?");
    }

    //check input
    Boolean check(InputStream is) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        String insn = in.readLine();

        insn = insn.toUpperCase();

        //check the input format
        if (insn.length() != 3) {
            System.out.println("Invalid input");
            return false;
        }

        char c0 = insn.charAt(0);
        char c1 = insn.charAt(1);
        char c2 = insn.charAt(2);

        if (!isLetter(c0) || !isDigit(c1) || !isLetter(c2)) {
            System.out.println(("Invalid input"));
            return false;
        }

        return true;

    }

    //check insn
    Boolean boardCheck(Board b, String insn) {
        if(!b.check(insn)) {
            return false;
        }
        return true;
    }

    //place stack
    public void place(String name) {
        System.out.println("Player " + name +
                ", where do you want to place the first Green stack?");
    }

    //find stack
    public void find() {
        System.out.println("You found a stack!");
    }

    //win
    public void win(String player) {
        System.out.println(player + "win");
    }
}

