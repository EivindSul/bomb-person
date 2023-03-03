package inf112.bomberperson.model;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Arrays;
import java.util.Random;

public class Map extends ApplicationAdapter {
    private static final int TILE_SIZE = 32;
    static final int MAP_WIDTH = 27;
    static final int MAP_HEIGHT = 27;
    static final float WALL_DENSITY = 0.2f;
    private static final Random random = new Random();
    static final int GRASS_TILE_ID=  483;
    static final int WALL_TILE_ID=  385;
    static final int BRICK_TILE_ID=  105;



    enum TileType {
        GRASS,
        BRICK,
        WALL
    }

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private TiledMap map;
    private OrthogonalTiledMapRenderer mapRenderer;
    TiledMapTileLayer groundLayer;
    TiledMapTileLayer wallLayer;
    TiledMapTileLayer explodableWallLayer;
    TiledMapTile[] wallTiles;
    private TiledMapTile[] brickTiles;
    private Viewport viewport;


    @Override
    public void create() {
        int mapWidth = MAP_WIDTH * TILE_SIZE;
        int mapHeight = MAP_HEIGHT * TILE_SIZE;

        camera = new OrthographicCamera();
        viewport = new FitViewport(mapWidth, mapHeight, camera);
        viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        camera.zoom = .74f; // or any other value
        camera.position.set(mapWidth / 3.33f, mapHeight / 3.33f, 0);
        viewport.update(mapWidth, mapHeight);



        batch = new SpriteBatch();

        // Load the map from Tiled
        map = new TmxMapLoader().load("doc/assets/tiles.tmx");

        // Create the map renderer
        mapRenderer = new OrthogonalTiledMapRenderer(map);
        mapRenderer.setView(camera);

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



    @Override
    public void render() {
        // Clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Update the camera
        camera.update();

        // Render the map
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        mapRenderer.render();
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        map.dispose();
    }

    public void generateMap() {
        TiledMapTileSet tileset = map.getTileSets().getTileSet("tiles");
        TiledMapTile brickTile = tileset.getTile(BRICK_TILE_ID);
        TiledMapTile grassTile = tileset.getTile(GRASS_TILE_ID);

        for (int x = 0; x < MAP_WIDTH; x++) {
            for (int y = 0; y < MAP_HEIGHT; y++) {
                TiledMapTileLayer.Cell cell = groundLayer.getCell(x, y);
                if (cell == null) {
                    continue;
                }
                TiledMapTile tile = cell.getTile();
                if (tile == null) {
                    continue;
                }

                // Randomly place GRASS on BRICK
                if (tile.getId() == BRICK_TILE_ID) {
                    if (Math.random() < (1 - WALL_DENSITY)) {
                        TiledMapTileLayer.Cell grassCell = new TiledMapTileLayer.Cell();
                        grassCell.setTile(grassTile);
                        explodableWallLayer.setCell(x, y, grassCell);
                    }
                }

                // Randomly place BRICK on GRASS
                if (tile.getId() == GRASS_TILE_ID) {
                    if (Math.random() < WALL_DENSITY) {
                        TiledMapTileLayer.Cell brickCell = new TiledMapTileLayer.Cell();
                        brickCell.setTile(brickTile);
                        groundLayer.setCell(x, y, brickCell);
                    }
                }
            }
        }
    }













    private void setTile(int x, int y, TileType type) {
        TiledMapTileLayer layer;
        switch (type) {
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
                return;
        }

        // Get the tile properties
        MapProperties properties = layer.getProperties();

        // Check if the tile is a collidable tile
        if (properties.containsKey("collidable") && (Boolean)properties.get("collidable")) {
            return;
        }

        // Create the cell
        TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();

        // Set the tile based on the type
        TiledMapTile tile;
        TiledMapTileSet tileset = map.getTileSets().getTileSet("tiles");
        switch (type) {
            case GRASS:
                tile = tileset.getTile(GRASS_TILE_ID);
                break;
            case WALL:
                tile = wallTiles[random.nextInt(wallTiles.length)];
                break;
            case BRICK:
                tile = brickTiles[random.nextInt(brickTiles.length)];
                break;
            default:
                return;
        }
        cell.setTile(tile);

        // Set the cell on the layer
        layer.setCell(x, y, cell);
    }


    private TileType getTile(int x, int y) {
        TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(0);
        TiledMapTileLayer.Cell cell = layer.getCell(x, y);
        if (cell == null) {
            return TileType.GRASS;
        }
        TiledMapTile tile = cell.getTile();
        if (tile == wallTiles[0]) {
            return TileType.WALL;
        } else if (Arrays.asList(brickTiles).contains(tile)) {
            return TileType.BRICK;
        } else {
            return TileType.GRASS;
        }
    }

}
