package inf112.bomberperson.model;

import com.badlogic.gdx.math.Vector2;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

import static org.mockito.Mockito.*;

public class PlayerTest {

    @Mock
    private Batch batch;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Files files = mock(Files.class);
        Gdx.files = files;
        FileHandle handle = mock(FileHandle.class);
        when(files.internal(anyString())).thenReturn(handle);
    }

    @Test
    public void testGetCurrentDirection() {
        Sprite sprite = mock(Sprite.class);
        Player player = new Player(sprite);
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
        Sprite sprite = mock(Sprite.class);
        Player player = new Player(sprite);
        player.setVelocity(new Vector2(1, 0));
        assert(player.getCurrentState() == Player.State.WALKING);
        player.setVelocity(new Vector2(0, 0));
        assert(Player.State.IDLE== player.getCurrentState());

    }


    // Add more tests here

}
