package spillet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameObjectTest {
    @Test
    void getX() {
        GameObject test1 = new GameObject(50, 50);
        assertEquals(50, test1.getX());
    }

    @Test
    void getY() {
        GameObject test2 = new GameObject(50, 50);
        assertEquals(50, test2.getY());
    }

}