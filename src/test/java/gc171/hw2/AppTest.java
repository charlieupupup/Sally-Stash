package gc171.hw2;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void setPlayer() {

        App test = new App();

        test.setaIsHuman(false);
        test.setbIsHuman(false);

        test.setPlayer();


    }


}