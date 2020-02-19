package gc171.hw2;

public class Movement {
    private Integer currRow;
    private Integer currCol;
    private Integer targetRow;
    private Integer targetCol;
    private Stack stack;

    public Movement(Integer currRow, Integer currCol) {
        this.currRow = currRow;
        this.currCol = currCol;
    }

    public void setTarget(Integer targetRow, Integer targetCol) {
        this.targetRow = targetRow;
        this.targetCol = targetCol;
    }

    /*

        boolean check of move


     */

    //validate the source coordinate
    public Boolean validateSrc(Player self) {
        if(checkBound(self) && checkStack(self)) {
            findStack(self);
            return true;
        }
        else {
            return false;
        }
    }


    //valid target coordinate
    public Boolean validateTar(Player self) {
        return conflictCheck(self);
    }

    //boolean method to check input coordinate is valid or not
    public Boolean checkBound(Player self) {
        if (currRow < 0 || currCol < 0 || currRow >= self.getRow() || currCol >= self.getCol()) {
            return false;
        }
        return true;
    }

    //boolean method to check if input location has a stack or not
    public Boolean checkStack(Player self) {
        return self.digCheck(currRow, currCol);
    }

    //find stack
    private void findStack(Player self) {
        stack = self.getStack(currRow, currCol);
    }

    //conflict check, check new place conflict or not bound check
    public Boolean conflictCheck(Player self) {
        Boolean res = false;
        //record stack curr location
        Integer currRow = stack.getRow();
        Integer currCol = stack.getCol();

        //set stack location
        stack.setRow(targetRow);
        stack.setCol(targetCol);

        //call self board conflict check
        SelfBoard curr = self.getSelfBoard();
        curr.rmStack(stack);

        res = curr.conflictCheck(stack);

        //restore the stack
        stack.setRow(currRow);
        stack.setCol(currCol);
        curr.addStack(stack);

        return res;
    }

    /*

        move stack


     */

    //move stack
    public void mvStack(Player self) {
        //get self board
        SelfBoard curr = self.getSelfBoard();
        curr.rmStack(stack);


        //set stack location
        stack.setRow(targetRow);
        stack.setCol(targetCol);


        curr.addStack(stack);

    }
}
