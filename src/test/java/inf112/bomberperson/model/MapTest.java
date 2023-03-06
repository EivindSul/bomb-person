package inf112.bomberperson.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class MapTest {
    private Map map;

    @BeforeEach
    void setUp() {
        map = new Map();
        map.create();
    }

    @AfterEach
    void tearDown() {
        map.dispose();
    }

    @Test
    void testTileType() {
        Map.TileType tileType = Map.TileType.GRASS;
        assertEquals("GRASS", tileType.name());
    }

    @Test
    void testGenerateMap() {
        int initialBrickCount = getTileCount(Map.TileType.BRICK);
        int initialWallCount = getTileCount(Map.TileType.WALL);
        map.generateMap();
        int finalBrickCount = getTileCount(Map.TileType.BRICK);
        int finalWallCount = getTileCount(Map.TileType.WALL);
        assertTrue(finalBrickCount > initialBrickCount);
        assertTrue(finalWallCount > initialWallCount);
    }

    private int getTileCount(Map.TileType tileType) {
        int count = 0;
        for (int x = 0; x < Map.MAP_WIDTH; x++) {
            for (int y = 0; y < Map.MAP_HEIGHT; y++) {
                TiledMapTileLayer.Cell cell = getCell(x, y, tileType);
                if (cell != null) {
                    count++;
                }
            }
        }
        return count;
    }

    private TiledMapTileLayer.Cell getCell(int x, int y, Map.TileType tileType) {
        TiledMapTileLayer layer;
        switch (tileType) {
            case GRASS:
                layer = map.groundLayer;
                break;
            case WALL:
                layer = map.wallLayer;
                break;
            case BRICK:
                layer = map.explodableWallLayer;
                break;
            default:
                layer = null;
                break;
        }
        return layer.getCell(x, y);
    }
}
