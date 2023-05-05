package inf112.bomberperson.model;

import com.badlogic.gdx.math.Vector2;
import inf112.bomberperson.model.tiles.Bomb;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class PlayerTest {

    private Player player;

    @Before
    public void setUp() {
        player = new Player(1);
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals(player.getX(), 0.0, 0.001);
        assertEquals(player.getY(), 0.0, 0.001);
        assertEquals(player.getWidth(), 10.0, 0.001);
        assertEquals(player.getHeight(), 10.0, 0.001);
        assertEquals(player.getCurrentDirection(), Player.Direction.UP);
        assertEquals(player.getCurrentState(), Player.State.WALKING);
        assertEquals(player.getVelocity(), new Vector2(0, 0));
        assertTrue(player.getAlive());
        assertEquals(player.getBombLimit(), 1);
        assertEquals(player.getBombRange(), 1);
        assertEquals(player.getBombPower(), 1);
        assertEquals(player.getSpeed(), 100);
    }

    @Test
    public void testSetVelocity() {
        Vector2 velocity = new Vector2(1, 2);
        player.setVelocity(velocity);
        assertEquals(player.getVelocity(), velocity);
    }

    @Test
    public void testGetPosition() {
        float x = 3.5f;
        float y = 7.2f;
        player.setPosition(x, y);
        assertEquals(player.getPosition(), new Vector2(x, y));
    }
    /*
    @Test
    public void testDropBomb() {
        assertTrue(player.noBombs());
        assertTrue(player.dropBomb());
        assertFalse(player.noBombs());
        player.incrementBombLimit();
        assertTrue(player.dropBomb());
        assertFalse(player.noBombs());
        player.allowInfiniteBombs();
        assertTrue(player.dropBomb());
        assertTrue(player.dropBomb());
    }
    */

    @Test
    public void testGetCurrentDirection() {

        player.setVelocity(new Vector2(0, 1));
        assert(player.getCurrentDirection() == Player.Direction.UP);
        player.setVelocity(new Vector2(0, -10));
        assert(player.getCurrentDirection() == Player.Direction.DOWN);
        player.setVelocity(new Vector2(-10, 0));
        assert(player.getCurrentDirection() == Player.Direction.LEFT);
        player.setVelocity(new Vector2(10, 0));
        assert(player.getCurrentDirection() == Player.Direction.RIGHT);

    }

    @Test
    public void testGetCurrentState() {
        player.setVelocity(new Vector2(1, 0));
        assert(player.getCurrentState() == Player.State.WALKING);


    }

    @Test
    public void testAllowInfiniteBombs() {
        player.allowInfiniteBombs();
        int expectedBombLimit = 1001; // initial limit of 1 + 1000 for infinite bombs
        int actualBombLimit = player.getBombLimit();
        assertEquals(expectedBombLimit, actualBombLimit);
    }


    @Test
    public void applyPowerupSpeedBoost() {
        int originalSpeed = player.getSpeed();
        player.applyPowerup("speedboost");
        assertEquals(originalSpeed + 10, player.getSpeed());
    }

    @Test
    public void applyPowerupMoreBombs() {
        int originalBombLimit = player.getBombLimit();
        player.applyPowerup("morebombs");
        assertEquals(originalBombLimit + 1, player.getBombLimit());
    }
    @Test
    public void applyPowerupMoreRange() {
        int originalBombRange = player.getBombRange();
        player.applyPowerup("morerange");
        assertEquals(originalBombRange + 1, player.getBombRange());
    }


    @Test
    public void testUpdate() {

        player.setPosition(0, 0);
        player.setVelocity(new Vector2(1, 1));
        player.update(1f);
        assertEquals(1f, player.getX(), 0f);
        assertEquals(1f, player.getY(), 0f);

        player.setVelocity(new Vector2(-1, -1));
        player.update(1f);
        assertEquals(0f, player.getX(), 0f);
        assertEquals(0f, player.getY(), 0f);
    }

    @Test
    public void testIncreaseSpeed() {
        int initialSpeed = player.getSpeed();
        player.increaseSpeed();
        int newSpeed = player.getSpeed();
        assertEquals(initialSpeed + 10, newSpeed);
    }

    // Removed popbomblisttest, because removed popbomblist
}









