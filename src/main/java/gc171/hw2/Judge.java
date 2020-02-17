package gc171.hw2;

import java.util.HashMap;

public class Judge {

    //place stack
    public Boolean place(SelfBoard board, Stack stack) {
        Boolean res = true;
        res = board.checkStack(stack);
        return res;
    }

    //judge whether player dig a block
    public Boolean dig(SelfBoard selfBoard, Integer row, Integer col) {

        Boolean res = false;

        HashMap<Integer, String> tmp = selfBoard.genBoard();

        Integer pos = row * selfBoard.getColNum() + col;
        if (selfBoard.getBoard().get(pos).equals(" ")) {
            res = false;
        } else {
            res = true;
        }
        return res;
    }

    //judge whether one player has win
    public Boolean win(SelfBoard selfBoard) {
        Boolean res = false;
        res = selfBoard.win();
        return res;
    }

    //

}
