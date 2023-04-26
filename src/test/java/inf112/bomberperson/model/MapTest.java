// // package inf112.bomberperson.model;

// <<<<<<< HEAD
// // import com.badlogic.gdx.Game;
// // import com.badlogic.gdx.backends.headless.HeadlessApplication;
// // import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
// // import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
// // import inf112.bomberperson.game.BombermanGame;
// // import org.junit.Before;
// // import org.junit.Test;
// // import org.junit.jupiter.api.BeforeAll;
// // import org.junit.jupiter.api.extension.ExtendWith;
// // import org.mockito.Mock;
// =======
// import com.badlogic.gdx.Game;
// import com.badlogic.gdx.backends.headless.HeadlessApplication;
// import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
// import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
// import inf112.bomberperson.game.BombermanGame;
// import inf112.bomberperson.model.map.Map;

// import org.junit.Before;
// import org.junit.Test;
// import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.Mock;
// >>>>>>> main

// import org.mockito.MockitoAnnotations;
// import com.badlogic.gdx.maps.tiled.*;
// import org.mockito.exceptions.base.MockitoException;

// import static org.junit.jupiter.api.Assertions.*;

// import static org.junit.Assert.assertEquals;
// import static org.mockito.Mockito.*;


// public class MapTest {


//     private Map map;
//     @Mock
//     private TiledMapTileLayer explodableWallLayer;
//     @Mock
//     private TiledMapTileLayer groundLayer;
//     @Mock
//     private TiledMapTileLayer wallLayer;
//     @Mock
//     private TiledMapTileSet tileSet;

//     @Before
//     public void setUp() {
//         HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
//         new HeadlessApplication(new Map(), config);

//         map = spy(new Map());

//         map.explodableWallLayer = explodableWallLayer;
//     }


//     @Test
//     public void testTileType() {
//         System.out.println(map);
//         Map.TileType tileType = Map.TileType.GRASS;
//         assertEquals("GRASS", tileType.name());
//     }

//     @Test
//     public void testGetWidth() {
//         float expected = 27f;
//         float actual = map.getWidth();
//         assertEquals(expected, actual, 0);
//     }

//     @Test
//     public void testGetHeight() {
//         float expected = 27f;
//         float actual = map.getHeight();
//         assertEquals(expected, actual, 0);
//     }

//     @Test
//     public void testGenerateMap() {
//         // Call the method to generate the map


//         // Check that the wall layer and explodable wall layer are not null
//         assertNotNull(map.getMap().getLayers().get("Wall"));
//         assertNotNull(map.getMap().getLayers().get("Explodable"));

//         // Check that the wall layer and explodable wall layer have the correct number of tiles
//         assertEquals(27, map.wallLayer.getWidth());
//         assertEquals(27, map.wallLayer.getHeight());
//         assertEquals(27, map.explodableWallLayer.getWidth());
//         assertEquals(27, map.explodableWallLayer.getHeight());

//         // Check that the ground layer has the correct number of tiles
//         assertEquals(27, map.groundLayer.getWidth());
//         assertEquals(27, map.groundLayer.getHeight());

//         // Check that each tile on the wall layer and explodable wall layer is either a wall or grass tile
//         for (int x = 0; x < map.wallLayer.getWidth(); x++) {
//             for (int y = 0; y < map.wallLayer.getHeight(); y++) {
//                 TiledMapTileLayer.Cell cell = map.wallLayer.getCell(x, y);
//                 if (cell != null) {
//                     TiledMapTile tile = cell.getTile();
//                     assertTrue(tile.getId() == Map.WALL_TILE_ID );
//                 }

//                 cell = map.explodableWallLayer.getCell(x, y);
//                 if (cell != null) {
//                     TiledMapTile tile = cell.getTile();
//                     assertTrue(tile.getId() == Map.BRICK_TILE_ID );
//                 }
//                 cell = map.groundLayer.getCell(x, y);
//                 if (cell != null) {
//                     TiledMapTile tile = cell.getTile();
//                     assertTrue(tile.getId() == Map.GRASS_TILE_ID );
//                 }
//             }
//         }

//         // Check that each tile on the ground layer is a grass tile
//         for (int x = 0; x < map.groundLayer.getWidth(); x++) {
//             for (int y = 0; y < map.groundLayer.getHeight(); y++) {
//                 TiledMapTileLayer.Cell cell = map.groundLayer.getCell(x, y);
//                 if (cell != null) {
//                     TiledMapTile tile = cell.getTile();
//                     assertEquals(Map.GRASS_TILE_ID, tile.getId());
//                 }
//             }
//         }
//     }

// }





