package inf112.bomberperson.model;

import com.badlogic.gdx.math.Vector2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class BombTest {

    Bomb bomb;

    @BeforeEach
    void setUp() {
        bomb = new Bomb(new Vector2(),1, 1);

    }

    @Test
    public void testGetRange() {
        int expected = 1;
        int actual = bomb.getRange();
        assertEquals(expected, actual, 0);
    }
    @Test
    public void testGetPower() {
        int expected = 1;
        int actual = bomb.getPower();
        assertEquals(expected, actual, 0);
    }
}