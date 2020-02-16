package gc171.hw2;

import java.util.ArrayList;
import java.util.HashMap;

public class SelfBoard {
    //data for row & col
    private Integer rowNum;
    private Integer colNum;

    //map to store stack data
    private HashMap<String, Stack> board = new HashMap<>();

    //init
    public SelfBoard(int rowIn, int colIn) {
        rowNum = rowIn;
        colNum= colIn;
    }


    //take down parameters
    Boolean addStack(String insn, Stack stack) {
        char r = insn.charAt(0);
        char p = insn.charAt(2);

        int row = r - 'A';
        int col = Character.getNumericValue(insn.charAt(1));

        stack.setRow(row);
        stack.setCol(col);

        //check
        if(checkStack(stack)) {
            board.put(stack.getName(), stack);
            return true;
        }

        else {
            return false;
        }
    }
    //generate output board
    HashMap<Integer, String> genBoard(HashMap<String, Stack> currMap) {
        HashMap<Integer, String> curr = new HashMap<>();

        //loop through HashMap
        for (String k : currMap.keySet()) {
            Stack currStack = currMap.get(k);
            ArrayList<Integer> pos = currStack.getPos(rowNum, colNum);

            //put all the element in pos into curr map;
            for (Integer i : pos) {
                if(curr.containsKey(i)) {
                    curr.put(0, "wrong");
                    return curr;
                }

                else {
                    curr.put(i, currStack.getColor());
                }
            }
        }

        return curr;
    }
    //check
    Boolean checkStack(Stack stack) {
        board.put(stack.getName(), stack);
        HashMap<Integer, String> tmp = genBoard(board);
        if (tmp.containsKey(0)) {
            String res = tmp.get(0);
            if(res.equals("wrong")) {
                board.remove(stack.getName());
                return false;
            }
        }
        return true;
    }

    //print col num
    public void printColNum() {

        System.out.print("  ");
        for (int c = 0; c < colNum - 1; c++) {
            System.out.print(c + "|");
        }
        System.out.println(colNum - 1 + "  ");
    }

    public void printLine(HashMap<Integer, String> boardInfo, Integer currRow) {
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

    //print
    public void printBoard() {
        printColNum();

        //gen board
        HashMap<Integer, String> boardInfo = genBoard(board);

        //now board information
        for (int r = 0; r < rowNum; r++) {
            char currRow = (char) (65 + r);
            System.out.print(currRow + " ");

            //print the element
            printLine(boardInfo, r);

        }

        printColNum();


    }


}
