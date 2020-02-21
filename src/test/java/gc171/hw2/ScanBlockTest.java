package gc171.hw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScanBlockTest {

    @Test
    void setRow() {
        ScanBlock tmp = new ScanBlock(0, 0);
        tmp.setRow(2);
        tmp.setCol(2);
    }
}