package spillet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpillObjektTest {
    @Test
    void getX() {
        SpillObjekt test1 = new SpillObjekt(50, 50);
        assertEquals(50, test1.getX());
    }

    @Test
    void getY() {
        SpillObjekt test2 = new SpillObjekt(50, 50);
        assertEquals(50, test2.getY());
    }

}