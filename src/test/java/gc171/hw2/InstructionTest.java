package gc171.hw2;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class InstructionTest {

    Instruction insn = new Instruction();

    @Test
    void start() {


    }

    @Test
    void testStart() {
    }

    @Test
    void ask() {
    }

    @Test
    void check() throws IOException {
        String s = new String("123456");

        InputStream targetStream = new ByteArrayInputStream(s.getBytes());


    }

    @Test
    void check1() throws IOException {
        String s = new String("a33");

        InputStream targetStream = new ByteArrayInputStream(s.getBytes());

    }

    @Test
    void check2() throws IOException {
        String s = new String("t2t");

        InputStream targetStream = new ByteArrayInputStream(s.getBytes());


    }

    @Test
    void boardCheck() {
    }

    @Test
    void testStart1() {
    }

    @Test
    void testAsk() {
    }

    @Test
    void testCheck() {
    }

    @Test
    void testBoardCheck() {
    }

    @Test
    void testCheck1() {
    }
}