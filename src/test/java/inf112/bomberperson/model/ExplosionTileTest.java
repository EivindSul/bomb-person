package inf112.bomberperson.model;

import com.badlogic.gdx.math.Vector2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExplosionTileTest {
    ExplosionTile explosionTile;
    @BeforeEach
    void setUp() {
        explosionTile = new ExplosionTile(new Vector2(1,1));
    }

    @Test
    void getDirection() {
        explosionTile.setDirection(1);
        assert (1 == explosionTile.getDirection());
        explosionTile.setDirection(2);
        assert (2 == explosionTile.getDirection());

    }

    @Test
    void getPower() {
        explosionTile.setPower(1);
        assert (1 == explosionTile.getPower());
        explosionTile.setPower(2);
        assert (2 == explosionTile.getPower());

    }
}