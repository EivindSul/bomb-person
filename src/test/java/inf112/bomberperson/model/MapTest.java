package inf112.bomberperson.model;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.bomberperson.model.map.Map;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

public class MapTest {
    @Mock
    private Map map;

    @Before
    public void setUp() {
        map = new Map();
    }

    @Test
    public void testGetWidth() {
        float width = map.getWidth();
        assertEquals(27.0f, width, 0.1f);
    }

    @Test
    public void testGetHeight() {
        float height = map.getHeight();
        assertEquals(27.0f, height, 0.1f);
    }

    @Test
    public void testGetTileSize() {
        float tileSize = map.getTileSize();
        assertEquals(16.0f, tileSize, 0.1f);
    }
}
