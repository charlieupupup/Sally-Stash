package gc171.hw2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;

/*
    for all instruction input & output

 */

public class Instruction implements UI{
    private HashMap<Integer, String> orders;
    private HashMap<String, String> colors;
    private Integer row = 20;
    private Integer col = 10;

    public Instruction() {
        orders = new HashMap<>();
        orders.put(0, "first");
        orders.put(1, "second");
        orders.put(2, "third");
        orders.put(3, "forth");
        orders.put(4, "fifth");

        colors = new HashMap<>();
        colors.put("G", "Green");
        colors.put("P", "Purple");
        colors.put("R", "Red");
        colors.put("B", "Blue");
    }

    @Override
    public void pre(Player player) {

    }

    @Override
    public void preCol(Player player) {

    }

    @Override
    public void preScreen(Player player) {

    }

    @Override
    public void game(Player player) {

    }

    @Override
    public void gameCol(Player player) {

    }

    @Override
    public void gameLine(Player player, Integer currRow) {

    }

    @Override
    public void gameScreen(Player player) {

    }

    @Override
    public void printColNum(Integer colNum) {

    }

    @Override
    public void printLine(HashMap<Integer, String> boardInfo, Integer currRow, Integer colNum) {

    }

    public String getOrders(Integer num) {
        return orders.get(num);
    }

    public String getColors(String c) {
        return colors.get(c);
    }

    public void start(String self, String rival) {
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
        System.out.println("Player " + name + ", where do you want to place the "
                + order + " "
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
        for (int i = 0; i < 23; i++) {
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

    //hyphenation
    public void hyphen() {
        for (int i = 0; i < 10 * col; i++) {
            System.out.print("-");
        }
        System.out.println();
    }


    //find stack
    public void find() {
        hyphen();
        System.out.println("You found a stack!");
        hyphen();
    }

    //win
    public void win(String player) {
        hyphen();
        System.out.println(player + " win");
        hyphen();
    }

    //miss
    public void miss() {
        hyphen();
        System.out.println("You missed!");
        hyphen();
    }
}

