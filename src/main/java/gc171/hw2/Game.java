package gc171.hw2;

import java.io.IOException;

/*

    the class control the main game logic


 */
public class Game {
    Instruction instruction = new Instruction();
    Display display = new Display();
    Judge judge = new Judge();

    //game
    public void exeGame(Player self, Player rival) throws IOException {
        if (self instanceof Bot) {
            ((Bot) self).dig(self, rival);
        }

        else {
            exeHumanGame(self, rival);
        }
    }

    //human gaming process
    public void exeHumanGame(Player self, Player rival) throws IOException {

        String input;
        //check input format
        while (true) {
            display.game(self);
            instruction.gameInfo(self.getPlayerName(), self.getMvNum(), self.getSonarNum());
            input = instruction.prompt(System.in);
            input = input.toUpperCase();

            if (!judge.gameFormat(input)) {
                System.out.println("invalid input");
                continue;
            }

            //normal dig
            if (input.equals("D")) {
                System.out.println("input dig location");
                if (dig(self, rival)) {
                    break;
                } else {
                    System.out.println("invalid input");
                }

            }
            //special moves
            //sonar scan
            if (input.equals("S")) {
                System.out.println("input sonar location");
                if (son(self, rival)) {
                    break;
                } else {
                    System.out.println("invalid input");
                }

            }

            //move stack
            if (input.equals("M")) {
                System.out.println("please select stack");
                if (mov(self)) {
                    break;
                }
                else {
                    System.out.println("invalid input");
                }

            }

        }


    }

    //dig
    private Boolean dig(Player self, Player rival) throws IOException {
        String location = instruction.prompt(System.in);

        if (judge.coordinateFormat(self, location)) {
            //check if hit or not
            judge.digBlock(self, rival, location);
            return true;
        }
        return false;
    }

    //sonar
    private Boolean son(Player self, Player rival) throws IOException {
        //check user have son num or not
        if (self.getSonarNum() <= 0) {
            return false;
        }

        String location = instruction.prompt(System.in);

        //first check input format
        if (judge.coordinateFormat(self, location)) {
            char c0 = location.charAt(0);
            char c1 = location.charAt(1);

            Integer cenRow = c0 - 'A';
            Integer cenCol = Character.getNumericValue(c1);
            Scanner scanner = new Scanner(cenRow, cenCol);

            //validate the input coordinate
            if (scanner.checkBound(rival, cenRow, cenCol)) {
                scanner.scan(rival);

                //reduce player scan num
                Integer tmp = self.getSonarNum();
                --tmp;
                self.setSonarNum(tmp);
                return true;
            }

        }
        return false;
    }

    //check user can mov
    //mov if can
    private Boolean mov(Player self) throws IOException {
        //check user have mov num or not
        if (self.getMvNum() <= 0) {
            return false;
        }
        //read the stack location
        String src = instruction.prompt(System.in);

        //check the coordinate format
        if (judge.coordinateFormat(self, src)) {
            //check if there is a stack
            char c0 = src.charAt(0);
            char c1 = src.charAt(1);

            Integer srcRow = c0 - 'A';
            Integer srcCol = Character.getNumericValue(c1);

            Movement movement = new Movement(srcRow, srcCol);
            //check bound
            if (movement.validateSrc(self)) {
                //read the target location
                System.out.println("input target location & orientation");
                String tar = instruction.prompt(System.in);

                //check the input format
                if (!judge.preFormat(self, tar)) {
                    return false;
                }


                //get state
                c0 = tar.charAt(0);
                c1 = tar.charAt(1);
                char c2 = tar.charAt(2);
                //set target
                Integer tarRow = c0 - 'A';
                Integer tarCol = Character.getNumericValue(c1);
                String tarState = String.valueOf(c2);
                movement.setTarget(tarRow, tarCol, tarState);

                //validate the target
                if (movement.validateTar(self)) {
                    movement.mvStack(self);

                    //minus special move
                    Integer tmp = self.getMvNum();
                    tmp--;
                    self.setMvNum(tmp);
                    return true;
                }
            }
        }

        return false;
    }

}


