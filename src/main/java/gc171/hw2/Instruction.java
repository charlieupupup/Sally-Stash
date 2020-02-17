package gc171.hw2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;

/*
    for all instruction input & output

 */

public class Instruction {
    void start(String self, String rival) {
        System.out.println(
                "Player " + self + ", you are going place Sally’s stash on the board. Make sure Player " + rival + " isn’t\n" +
                        "looking! For each stack, type the coordinate of the upper left side of the stash,\n" +
                        "followed by either H (for horizontal) or V (for vertical). For example, M4H would \n" +
                        "place a stack horizontally starting at M4 and going to the right. You have\n" +
                        "2 Green stacks that are 1x2\n" +
                        "3 Purple stacks that are 1x3\n" +
                        "3 Red stacks that are 1x4\n" +
                        "2 Blue stacks that are 1x6");
    }

    //ask for input
    public void place(String name, String order, String color) {
        System.out.println("Player" + name + ", where do you want to place the "
                + order
                + color
                + " stack?");
    }

    //game header
    public void gameHead(String self, String rival) {
        System.out.println("Player " + self + "'s turn");
        for (int i = 0; i < 5; i++) {
            System.out.print(" ");
        }
        System.out.print("Your tree");
        for (int i = 0; i < 15; i++) {
            System.out.print(" ");
        }
        System.out.println("Player " + rival + "'s tree");

    }

    //ask for dig
    public void dig() {
        System.out.println("Input your dig");
    }

    //read from input
    public String prompt(InputStream is) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        String insn = in.readLine();
        insn = insn.toUpperCase();
        return insn;
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

    //miss
    public void miss() {
        System.out.println("You missed!");
    }
}

