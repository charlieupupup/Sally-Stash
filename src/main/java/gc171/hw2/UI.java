package gc171.hw2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public interface UI {

    /*

        GAME SCREEN


     */

    public void pre(Player player);


    public void preCol(Player player);

    public void preScreen(Player player);

    /*

    game display

     */
    public void game(Player player);

    public void gameCol(Player player);


    //play line
    public void gameLine(Player player, Integer currRow);

    //play screen
    public void gameScreen(Player player);
    /*

     display basic elements

     */

    //print col num
    public void printColNum(Integer colNum);

    //print board line
    public void printLine(HashMap<Integer, String> boardInfo, Integer currRow, Integer colNum);

    /*

        INSTRUCTION


     */

    public String getOrders(Integer num);

    public String getColors(String c) ;
    void start(String self, String rival) ;

    //ask for input
    public void place(String name, String order, String color) ;

    //game header
    public void gameHead(String self, String rival) ;
    //ask for dig
    public void dig() ;

    //read from input
    public String prompt(InputStream is) throws IOException ;

    //hyphenation
    public void hyphen();


    //find stack
    public void find() ;
    //win
    public void win(String player) ;

    //miss
    public void miss() ;
}
