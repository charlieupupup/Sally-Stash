package gc171.hw2;

import java.util.HashMap;

public class Board {
    //data for row & col
    private Integer row;
    private Integer col;

    //map to store board data
    private HashMap<Integer, String> board = new HashMap<Integer, String>();

    //init
    public Board(int rowIn, int colIn) {
        row = rowIn;
        col = colIn;

        //init map
        //pair location with string empty
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                Integer curr = r * col + c;
                board.put(curr, "empty");
            }
        }
    }


    //check


    //print
    public void display() {
        //first line
        System.out.print("  ");
        for (int c = 0; c < col - 1; c++) {
            System.out.print(c + "|");
        }
        System.out.println(col - 1 + "  ");

        //now board information
        for (int r = 0; r < row; r++) {
            char currRow = (char) (65 + r);
            System.out.print(currRow + " ");

            //print the element
            for (int c = 0; c < col - 1; c++) {
                Integer k = r * col + c;
                String s = board.get(k);
                if (s == "empty") {
                    System.out.print(" |");
                } else {
                    System.out.print(s + "|");
                }
            }

            //print the last element
            Integer k = r * col + col - 1;
            String s = board.get(k);
            if (s == "empty") {
                System.out.println("  " + currRow);
            } else {
                System.out.println(s + " " + currRow);
            }

        }


    }


}
