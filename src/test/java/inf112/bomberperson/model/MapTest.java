package inf112.bomberperson.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import org.junit.jupiter.api.*;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
/*
public class MapTest extends Map{
    private static final int TILE_SIZE = 32;
    static final int MAP_WIDTH = 27;
    static final int MAP_HEIGHT = 27;
    static final float WALL_DENSITY = 0.2f;
    private static final Random random = new Random();
    static final int GRASS_TILE_ID=  484;
    static final int WALL_TILE_ID=  386;
    static final int BRICK_TILE_ID=  106;
    private TiledMap map;

    enum TileType {
        GRASS,
        BRICK,
        WALL
    }

    private OrthogonalTiledMapRenderer mapRenderer;
    TiledMapTileLayer groundLayer;
    static TiledMapTileLayer wallLayer;
    static TiledMapTileLayer explodableWallLayer;
    TiledMapTile[] wallTiles;
    private TiledMapTile[] brickTiles;
    private Viewport viewport;


    @Override
    public void create() {

        // Load the map from Tiled
        map = new TmxMapLoader().load("doc/assets/tiles2.tmx");

        // Create the map renderer
        mapRenderer = new OrthogonalTiledMapRenderer(map);

        // Get the layers from the map
        groundLayer = (TiledMapTileLayer)map.getLayers().get("Ground");
        wallLayer = (TiledMapTileLayer)map.getLayers().get("Wall");
        explodableWallLayer = (TiledMapTileLayer)map.getLayers().get("ExplodableWall");

        // Get the wall tiles from the tileset
        TiledMapTileSet tileset = map.getTileSets().getTileSet("tiles");
        TiledMapTile wallTile1 = tileset.getTile(WALL_TILE_ID);
        wallTiles = new TiledMapTile[]{wallTile1};

        // Get the brick tiles from the tileset
        TiledMapTile brickTile1 = tileset.getTile(BRICK_TILE_ID);
        brickTiles = new TiledMapTile[]{brickTile1};



        // Randomly generate the map
        generateMap();
    }


    @BeforeEach
    void setUp() {
        create();

    }

    @AfterEach
    void tearDown() {


    }

    @Test
    void numLayers() {
        assertEquals(3, map.getLayers());
    }

    @Test
    void correctCellType() {
        Boolean test = true;
        for (int x = 0; x < Map.MAP_WIDTH; x++) {
            for (int y = 0; y < Map.MAP_HEIGHT; y++) {
                if (!groundLayer.getCell(x, y).equals( TileType.GRASS)){
                    test = false;
                    break;
                }
                if (wallLayer.getCell(x, y) != null  || !wallLayer.getCell(x, y).equals( TileType.WALL)){
                    test = false;
                    break;
                }
                if (explodableWallLayer.getCell(x, y) != null  || !explodableWallLayer.getCell(x, y).equals( TileType.BRICK)){
                    test = false;
                    break;
                }
            }
        }
        assertTrue(test);
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
        generateMap();
        int finalBrickCount = getTileCount(Map.TileType.BRICK);
        int finalWallCount = getTileCount(Map.TileType.WALL);
        assertTrue(finalBrickCount > initialBrickCount);
        assertTrue(finalWallCount > initialWallCount);
    }

    private int getTileCount(Map.TileType tileType) {
        int count = 0;
        TiledMapTileLayer layer;
        for (int x = 0; x < Map.MAP_WIDTH; x++) {
            for (int y = 0; y < Map.MAP_HEIGHT; y++) {
                System.out.println("hi");
                if (tileType.equals( TileType.GRASS)) {
                    layer = groundLayer;
                }
                else if (tileType.equals( TileType.WALL)) {
                    layer = wallLayer;
                }
                else if (tileType.equals( TileType.BRICK)) {
                    layer = explodableWallLayer;
                }
                else
                    continue;
                TiledMapTileLayer.Cell cell = layer.getCell(x, y);;
                if (cell != null) {
                    count++;
                }
            }
        }
        return count;
    }
    private TiledMapTileLayer.Cell getCell(int x, int y, Map.TileType tileType) {
        TiledMapTileLayer layer;
        System.out.println("Hi");
        switch (tileType) {
            case GRASS:
                layer = groundLayer;
                break;
            case WALL:
                layer = wallLayer;
                break;
            case BRICK:
                layer = explodableWallLayer;
                break;
            default:
                layer = null;
                break;
        }
        return layer.getCell(x, y);
    }
}
*/
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MapTest {

    private Map map;

    @Mock
    private TiledMapTileLayer explodableWallLayer;
    @Mock
    private TiledMapTileLayer groundLayer;
    @Mock
    private TiledMapTileLayer wallLayer;
    @Mock
    private TiledMapTileSet tileSet;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        map = spy(new Map());
        map.explodableWallLayer = explodableWallLayer;
    }

    @Test
    public void testTileType() {
        Map.TileType tileType = Map.TileType.GRASS;
        assertEquals("GRASS", tileType.name());
    }

    @Test
    public void testGetWidth() {
        float expected = 27f;
        float actual = map.getWidth();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testGetHeight() {
        float expected = 27f;
        float actual = map.getHeight();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testGenerateMap() {
        // Call the method to generate the map
        map.generateMap();

        // Check that the wall layer and explodable wall layer are not null
        assertNotNull(map.wallLayer);
        assertNotNull(map.explodableWallLayer);

        // Check that the wall layer and explodable wall layer have the correct number of tiles
        assertEquals(27, map.wallLayer.getWidth());
        assertEquals(27, map.wallLayer.getHeight());
        assertEquals(27, map.explodableWallLayer.getWidth());
        assertEquals(27, map.explodableWallLayer.getHeight());

        // Check that the ground layer has the correct number of tiles
        assertEquals(27, map.groundLayer.getWidth());
        assertEquals(27, map.groundLayer.getHeight());

        // Check that each tile on the wall layer and explodable wall layer is either a wall or grass tile
        for (int x = 0; x < map.wallLayer.getWidth(); x++) {
            for (int y = 0; y < map.wallLayer.getHeight(); y++) {
                TiledMapTileLayer.Cell cell = map.wallLayer.getCell(x, y);
                if (cell != null) {
                    TiledMapTile tile = cell.getTile();
                    assertTrue(tile.getId() == Map.WALL_TILE_ID || tile.getId() == Map.GRASS_TILE_ID);
                }

                cell = map.explodableWallLayer.getCell(x, y);
                if (cell != null) {
                    TiledMapTile tile = cell.getTile();
                    assertTrue(tile.getId() == Map.WALL_TILE_ID || tile.getId() == Map.GRASS_TILE_ID);
                }
            }
        }

        // Check that each tile on the ground layer is a grass tile
        for (int x = 0; x < map.groundLayer.getWidth(); x++) {
            for (int y = 0; y < map.groundLayer.getHeight(); y++) {
                TiledMapTileLayer.Cell cell = map.groundLayer.getCell(x, y);
                if (cell != null) {
                    TiledMapTile tile = cell.getTile();
                    assertEquals(Map.GRASS_TILE_ID, tile.getId());
                }
            }
        }
    }

}





