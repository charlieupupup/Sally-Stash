package gc171.hw2;

import java.util.HashMap;

/*
    the display for all screen
 */

public class Display {
    /*

     pre display


     */
    public void pre(Player player) {
        preScreen(player);
    }


    public void preCol(Player player) {
        printColNum(player.getSelfBoard().getColNum());
        System.out.println();
    }

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
        for (int i = 0; i < 3 * player.getSelfBoard().getColNum(); i++) {
            System.out.println("-");
        }

        Instruction tmp = new Instruction();
        tmp.gameHead(player.getPlayerName(), player.getRivalName());

        gameScreen(player);

        for (int i = 0; i < 3 * player.getSelfBoard().getColNum(); i++) {
            System.out.println("-");
        }


    }

    public void gameCol(Player player) {
        printColNum(player.getSelfBoard().getColNum());
        for (int i = 0; i < player.getSelfBoard().getRowNum(); i++) {
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


}
