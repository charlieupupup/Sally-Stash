package gc171.hw2;

import java.util.HashMap;

public class Display {
    public void pre(Player player) {
        SelfBoard selfBoard = player.getSelfBoard();
        HashMap<Integer, String> boardInfo = selfBoard.genBoard();
        Integer col = selfBoard.getColNum();
        Integer row = selfBoard.getRowNum();
        printColNum(col);

        //now board information
        for (int r = 0; r < row; r++) {
            char currRow = (char) (65 + r);
            System.out.print(currRow + " ");

            //print the element
            printLine(player.getSelfBoard().genBoard(), r, player.getSelfBoard().getColNum());
            System.out.println();

        }
        printColNum(col);
    }

    public void game(Player player) {
        System.out.println("Player " + player.getPlayerName() + "'s turn");
        System.out.println("Your tree");

        printColNum(player.getSelfBoard().getColNum());
        printColNum(player.getRivalBoard().getColNum());

        gameScreen(player);


    }


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

        for (int c = 0; c < colNum - 1; c++) {
            Integer k = currRow * colNum + c;
            String s = boardInfo.get(k);
            if (s.equals("empty")) {
                System.out.print(" |");
            } else {
                System.out.print(s + "|");
            }
        }

        //print the last element
        Integer k = currRow * colNum + colNum - 1;
        String s = boardInfo.get(k);
        if (s.equals("empty")) {
            System.out.println("  " + currRow);
        } else {
            System.out.println(s + " " + currRow);
        }

    }

    //play line
    public void gameLine(Player player, Integer currRow) {
        Integer colNum = player.getSelfBoard().getColNum();
        HashMap<Integer, String> board = player.getSelfBoard().genBoard();

        //print self board
        HashMap<Integer, String> self = player.getSelfBoard().genBoard();
        printLine(self, currRow,colNum);


        //print rival board
        HashMap<Integer, String> rival = player.getRivalBoard().getBoard();
        printLine(rival, currRow, colNum);

        System.out.println();

    }

    public void gameNumCol(Integer colNum) {
        printColNum(colNum);
        printColNum(colNum);
        System.out.println();

    }
    //play screen
    public void gameScreen(Player player) {
        SelfBoard selfBoard = player.getSelfBoard();
        RivalBoard rivalBoard = player.getRivalBoard();

        int row = rivalBoard.getRowNum();
        int col = rivalBoard.getColNum();

        gameNumCol(col);

        for (int r = 0; r < row; r++) {
            gameLine(player, r);
        }

        gameNumCol(col);

    }


}
