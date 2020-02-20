package gc171.hw2;

import java.util.ArrayList;
import java.util.HashMap;

/*

    deal with scan & results


 */

public class Scanner {
    //HashMap to store the scan results
    private HashMap<String, Integer> scanResults;

    //HashMap to store scan coordinate
    private ArrayList<ScanBlock> scanBlocksList;

    //central coordinate
    private Integer cenRow;
    private Integer cenCol;

    //constructor
    public Scanner(Integer cenRow, Integer cenCol) {
        scanResults = new HashMap<>();
        scanResults.put("G", 0);
        scanResults.put("P", 0);
        scanResults.put("R", 0);
        scanResults.put("B", 0);
        scanBlocksList = new ArrayList<>();
        this.cenRow = cenRow;
        this.cenCol = cenCol;
    }

    //boolean method to check is valid or not
    public Boolean checkBound(Player rival, Integer row, Integer col) {
        return row >= 0 && col >= 0 && row < rival.getRow() && col < rival.getCol();
    }

    //whole scan process
    public void scan(Player rival) {
        extendCoordinate(rival);
        findColors(rival);
        printResult(rival);

    }

    //method extend input coordinate
    public void extendCoordinate(Player rival) {
        //loop to extend
        for (Integer r = -3; r <= 3; r++) {
            for (Integer c = -3; c <= 3; c++) {
                Integer curr = Math.abs(r) + Math.abs(c);

                if (curr > 3) {
                    continue;
                }

                Integer tmpRow = cenRow + r;
                Integer tmpCol = cenCol + c;
                //bound check
                if (checkBound(rival, tmpRow, tmpCol)) {
                    ScanBlock tmp = new ScanBlock(tmpRow, tmpCol);
                    scanBlocksList.add(tmp);
                }
            }
        }

    }

    //loop through each block to find color
    private void findColors(Player rival) {
        for (ScanBlock b : this.scanBlocksList) {
            Integer row = b.getRow();
            Integer col = b.getCol();
            if (rival.digCheck(row, col)) {
                String color = rival.getColor(row, col);
                Integer num = scanResults.get(color);
                scanResults.put(color, ++num);
            }
        }
    }




    //print the scan results
    public void printResult(Player rival) {
        for (int i = 0; i < 10 * rival.getCol(); i++) {
            System.out.print("-");
        }
        System.out.println();

        for (String k : scanResults.keySet()) {
            Instruction ins = new Instruction();
            String color = ins.getColors(k);
            Integer num = scanResults.get(k);
            printLine(color, num);
        }

        for (int i = 0; i < 10 * rival.getCol(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    //print out each line
    public void printLine(String color, Integer number) {
        System.out.println(color + " stacks occupy " + number +" squares");
    }

}
