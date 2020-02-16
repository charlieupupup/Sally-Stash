package gc171.hw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    Stack s = new Stack("green", "a3" , "g");
    @Test
    void getName() {
        System.out.println(s.getName());
    }

    @Test
    void getColor() {
        System.out.println(s.getColor());
    }
}