package gc171.hw2;

public class Bot extends Player {
    //index that store the bot dig movement
    Integer currDigRow = 0;
    Integer currDigCol = 0;

    public Bot(Integer row, Integer col, String playerName, String rivalName) {
        super(row, col, playerName, rivalName);
        initBotStack();
    }


    //method that init all stack
    public void initBotStack() {
        //2 GREEN
        Stack G0 = new Stack("G0", "G", "A0H", 2);
        Stack G1 = new Stack("G1", "G", "B0H", 2);

        addStack(G0);
        addStack(G1);

        //3 PURPLE
        Stack P0 = new Stack("P0", "P", "C0H", 3);
        Stack P1 = new Stack("P1", "P", "D0H", 3);
        Stack P2 = new Stack("P2", "P", "E0H", 3);

        addStack(P0);
        addStack(P1);
        addStack(P2);

        //3 RED
        RedStack R0 = new RedStack("R0", "R", "F0R", 4);
        RedStack R1 = new RedStack("R1", "R", "I0R", 4);
        RedStack R2 = new RedStack("R2", "R", "L0R", 4);

        addStack(R0);
        addStack(R1);
        addStack(R2);

        //3 BLUE
        BlueStack B0 = new BlueStack("B0", "B", "B5R", 6);
        BlueStack B1 = new BlueStack("B1", "B", "D5R", 6);
        BlueStack B2 = new BlueStack("B2", "B", "F5R", 6);

        addStack(B0);
        addStack(B1);
        addStack(B2);


    }

    //method that dig
    public void dig(Player self, Player rival) {
        //hit update rival.selfBoard && self.onwBoard
        if (rival.digCheck(currDigRow, currDigCol)) {
            System.out.println("Player " + self.getPlayerName() + " find a stack");
            rival.digBlock(currDigRow, currDigCol);
            self.setRivalBoard(currDigRow, currDigCol, rival.getColor(currDigRow, currDigCol));
        }

        //only update self.rivalBoard
        else {
            System.out.println("Player " + self.getPlayerName() + " missed ");
            self.setRivalBoard(currDigRow, currDigCol, "x");
        }

        //update coordinate
        currDigCol++;

        if (currDigCol == self.getCol()) {
            currDigCol = 0;
            currDigRow++;
        }

        if (currDigRow == self.getRow()) {
            currDigRow = 0;
        }
    }

}

