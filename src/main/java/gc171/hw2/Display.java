package gc171.hw2;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/*
    the display for all screen
 */

class Display implements UI{
    /*

     pre display


     */
    public void pre(Player player) {
        preScreen(player);
    }


    //pre game col num
    public void preCol(Player player) {
        printColNum(player.getSelfBoard().getColNum());
        System.out.println();
    }

    //pre game screen
    public void preScreen(Player player) {
        preCol(player);

        for (int r = 0; r < player.getSelfBoard().getRowNum(); r++) {
            //print the element
            printLine(player.getSelfBoard().genBoard(), r, player.getSelfBoard().getColNum());
            System.out.println();
        }

        preCol(player);
    }

    /*

    game display

     */
    public void game(Player player) {
        for (int i = 0; i < 10 * player.getSelfBoard().getColNum(); i++) {
            System.out.print("-");
        }
        System.out.println();

        Instruction tmp = new Instruction();
        tmp.gameHead(player.getPlayerName(), player.getRivalName());

        gameScreen(player);

        for (int i = 0; i < 10 * player.getSelfBoard().getColNum(); i++) {
            System.out.print("-");
        }

        System.out.println();


    }

    //game num col
    public void gameCol(Player player) {
        printColNum(player.getSelfBoard().getColNum());
        for (int i = 0; i < player.getSelfBoard().getColNum(); i++) {
            System.out.print(" ");
        }
        printColNum(player.getRivalBoard().getColNum());
        System.out.println();
    }


    //play line
    public void gameLine(Player player, Integer currRow) {
        Integer colNum = player.getSelfBoard().getColNum();
        HashMap<Integer, String> board = player.getSelfBoard().genBoard();

        //print self board
        HashMap<Integer, String> self = player.getSelfBoard().genBoard();
        printLine(self, currRow, colNum);

        //space
        for (int i = 0; i < colNum; i++) {
            System.out.print(" ");
        }
        //print rival board
        HashMap<Integer, String> rival = player.getRivalBoard().getBoard();
        printLine(rival, currRow, colNum);

        System.out.println();

    }

    //play screen
    public void gameScreen(Player player) {

        gameCol(player);

        for (int r = 0; r < player.getSelfBoard().getRowNum(); r++) {
            gameLine(player, r);
        }

        gameCol(player);

    }

    /*

     display basic elements

     */

    //print col num
    public void printColNum(Integer colNum) {

        System.out.print("  ");
        for (int c = 0; c < colNum - 1; c++) {
            System.out.print(c + "|");
        }
        System.out.print(colNum - 1 + "  ");
    }

    //print board line
    public void printLine(HashMap<Integer, String> boardInfo, Integer currRow, Integer colNum) {

        //row name
        char rowName = (char) (65 + currRow);
        System.out.print(rowName + " ");

        for (int c = 0; c < colNum - 1; c++) {
            Integer k = currRow * colNum + c;
            String s = boardInfo.get(k);
            System.out.print(s + "|");
        }

        //print the last element
        Integer k = currRow * colNum + colNum - 1;
        String s = boardInfo.get(k);
        System.out.print(s + " " + rowName);

    }

    @Override
    public String getOrders(Integer num) {
        return null;
    }

    @Override
    public String getColors(String c) {
        return null;
    }

    @Override
    public void start(String self, String rival) {

    }

    @Override
    public void place(String name, String order, String color) {

    }

    @Override
    public void gameHead(String self, String rival) {

    }

    @Override
    public void dig() {

    }

    @Override
    public String prompt(InputStream is) throws IOException {
        return null;
    }

    @Override
    public void hyphen() {

    }

    @Override
    public void find() {

    }

    @Override
    public void win(String player) {

    }

    @Override
    public void miss() {

    }


}
