package inf112.bomberperson.model;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
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
    static final int GRASS_TILE_ID=  484;
    static final int WALL_TILE_ID=  386;
    static final int BRICK_TILE_ID=  106;



    public float getWidth() {
        return MAP_WIDTH;
    }
    public float getHeight() {
        return MAP_HEIGHT;
    }

    public OrthogonalTiledMapRenderer getMapRenderer() {
        return mapRenderer;
    }


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
    static TiledMapTileLayer wallLayer;
    static TiledMapTileLayer explodableWallLayer;
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
        map = new TmxMapLoader().load("doc/assets/tiles2.tmx");

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
        mapRenderer.dispose();
    }

    public void generateMap() {
        TiledMapTileSet tileset = map.getTileSets().getTileSet("tiles");
        TiledMapTile brickTile = tileset.getTile(BRICK_TILE_ID);
        TiledMapTile grassTile = tileset.getTile(GRASS_TILE_ID);

        // Set the corner cells and their immediate neighbors to grass
        TiledMapTileLayer.Cell grassCell = new TiledMapTileLayer.Cell();
        grassCell.setTile(grassTile);


        // Randomly place grass on the brick cells
        for (int x = 0; x < MAP_WIDTH -2; x++) {
            for (int y = 0; y < MAP_HEIGHT -2; y++) {
                TiledMapTileLayer.Cell cell = explodableWallLayer.getCell(x, y);
                if (cell == null) {
                    continue;
                }
                TiledMapTile tile = cell.getTile();
                if (tile == null) {
                    continue;
                }

                if (tile.getId() == BRICK_TILE_ID) {
                    if (Math.random() < WALL_DENSITY) {
                        explodableWallLayer.setCell(x, y, null);
                    }
                }
            }

        }


        // Randomly place bricks on the remaining cells
        for (int x = 0; x < MAP_WIDTH -2; x++) {
            for (int y = 0; y < MAP_HEIGHT -2; y++) {
                TiledMapTileLayer.Cell cell = groundLayer.getCell(x, y);

                if (cell == null) {
                    continue;
                }
                TiledMapTile tile = cell.getTile();
                if (tile == null) {
                    continue;
                }
                if (tile.getId() == GRASS_TILE_ID && wallLayer.getCell(x,y)==null) {
                    if (Math.random() < WALL_DENSITY) {
                        TiledMapTileLayer.Cell brickCell = new TiledMapTileLayer.Cell();
                        brickCell.setTile(brickTile);
                        explodableWallLayer.setCell(x, y, brickCell);
                    }
                }
            }

        }






        explodableWallLayer.setCell(1, 1, null);
        explodableWallLayer.setCell(2, 1, null);
        explodableWallLayer.setCell(1, 2, null);

        explodableWallLayer.setCell(24, 1, null);
        explodableWallLayer.setCell(25, 1, null);
        explodableWallLayer.setCell(25, 2, null);

        explodableWallLayer.setCell(24, 25, null);
        explodableWallLayer.setCell(25, 24,null);
        explodableWallLayer.setCell(25, 25, null);

        explodableWallLayer.setCell(1, 25, null);
        explodableWallLayer.setCell(2, 25, null);
        explodableWallLayer.setCell(1, 24, null);
    }
    public TileType getTileTypeByCoordinate(int layer, int col, int row) {
        TiledMapTileLayer.Cell cell = null;
        if (layer == 0) {
            cell = groundLayer.getCell(col, row);
        } else if (layer == 1) {
            cell = wallLayer.getCell(col, row);
        } else if (layer == 2) {
            cell = explodableWallLayer.getCell(col, row);
        }
        if (cell != null) {
            int id = cell.getTile().getId();
            if (id == GRASS_TILE_ID) {
                return TileType.GRASS;
            } else if (id == WALL_TILE_ID) {
                return TileType.WALL;
            } else if (id == BRICK_TILE_ID) {
                return TileType.BRICK;
            }
        }
        return TileType.GRASS;
    }


}

