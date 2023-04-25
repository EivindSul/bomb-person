package inf112.bomberperson.model.map;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import inf112.bomberperson.model.tiles.Explosion;
import inf112.bomberperson.model.tiles.ExplosionTile;

import java.util.concurrent.ThreadLocalRandom;

public class Map extends ApplicationAdapter {
    public static final int TILE_SIZE = 16;
    static final int MAP_WIDTH = 27;
    static final int MAP_HEIGHT = 27;
    static final float WALL_DENSITY = 0.2f;
    static final int POWERUP_SPAWN_CHANCE = 4; // One in 4 walls broken spawns a powerup.
    private TiledMapTileSet tileset;
    static final int GRASS_TILE_ID=  484;
    static final int WALL_TILE_ID=  386;
    static final int BRICK_TILE_ID=  106;
    static final int BOMB_TILE_ID=  174;
    static final int EXPLOSION_TILE_ID=  176;
    enum TileType {
        GRASS,
        BRICK,
        WALL,
        EXPLOSION
    }

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private TiledMap map;
    private OrthogonalTiledMapRenderer mapRenderer;
    
    TiledMapTile[] wallTiles;
    private TiledMapTile[] brickTiles;
    private Viewport viewport;

    public Map(){
        this.create();
    }


    public TiledMap getMap() {
        return map;
    }

    public TiledMapTileLayer getGroundLayer() {
        return getLayerByName("Ground");
    }

    public TiledMapTileLayer getStaticLayer() {
        return getLayerByName("Static");
    }

    public TiledMapTileLayer getDynamicLayer() {
        return getLayerByName("Dynamic");
    }

    public TiledMapTileLayer getPowerupLayer() {
        return getLayerByName("Powerup");
    }
    
    public TiledMapTileLayer getLayerByName(String layer) {
        return (TiledMapTileLayer)getMap().getLayers().get(layer);
    }
    
    public TiledMapTile[] getWallTiles() {
        return wallTiles;
    }



    public float getWidth() {
        return MAP_WIDTH;
    }
    public float getHeight() {
        return MAP_HEIGHT;
    }

    public OrthogonalTiledMapRenderer getMapRenderer() {
        return mapRenderer;
    }


// <<<<<<< HEAD:src/main/java/inf112/bomberperson/model/Map.java
// =======
//     public enum TileType {
//         GRASS,
//         BRICK,
//         WALL,
//         EXPLOSION
//     }

//     private OrthographicCamera camera;
//     private SpriteBatch batch;
//     private TiledMap map;
//     private OrthogonalTiledMapRenderer mapRenderer;

//     public TiledMapTileLayer groundLayer;
//     public static TiledMapTileLayer wallLayer;
//     public static TiledMapTileLayer explodableWallLayer;
//     public static TiledMapTileLayer powerupLayer;
//     static TiledMapTileLayer explosionLayer;
//     public static TiledMapTileLayer bombLayer;
    
//     TiledMapTile[] wallTiles;
//     private TiledMapTile[] brickTiles;
//     private Viewport viewport;
// >>>>>>> main:src/main/java/inf112/bomberperson/model/map/Map.java


    @Override
    public void create() {
        int mapWidth = MAP_WIDTH * TILE_SIZE * 2;
        int mapHeight = MAP_HEIGHT * TILE_SIZE * 2;

        camera = new OrthographicCamera();
        viewport = new FitViewport(mapWidth, mapHeight, camera);
        viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());



        camera.zoom = .74f; // or any other value
        camera.position.set(mapWidth / 3.33f, mapHeight / 3.33f, 0);
        viewport.update(mapWidth, mapHeight);



        batch = new SpriteBatch();

        // Load the map from Tiled
        map = new TmxMapLoader().load("doc/assets/tiles2.tmx");
        tileset = map.getTileSets().getTileSet("tiles");

        // Create the map renderer
        mapRenderer = new OrthogonalTiledMapRenderer(map);
        mapRenderer.setView(camera);

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
        TiledMapTile brickTile = tileset.getTile(BRICK_TILE_ID);
        TiledMapTile grassTile = tileset.getTile(GRASS_TILE_ID);

        // Set the corner cells and their immediate neighbors to grass
        TiledMapTileLayer.Cell grassCell = new TiledMapTileLayer.Cell();
        grassCell.setTile(grassTile);


        // Randomly place grass on the brick cells
        for (int x = 0; x < MAP_WIDTH -2; x++) {
            for (int y = 0; y < MAP_HEIGHT -2; y++) {
                TiledMapTileLayer.Cell cell = getDynamicLayer().getCell(x, y);
                if (cell == null) {
                    continue;
                }
                TiledMapTile tile = cell.getTile();
                if (tile == null) {
                    continue;
                }

                if (tile.getId() == BRICK_TILE_ID) {
                    if (Math.random() < WALL_DENSITY) {
                        getDynamicLayer().setCell(x, y, null);
                    }
                }
            }

        }


        // Randomly place bricks on the remaining cells
        for (int x = 0; x < MAP_WIDTH -2; x++) {
            for (int y = 0; y < MAP_HEIGHT -2; y++) {
                TiledMapTileLayer.Cell cell = getGroundLayer().getCell(x, y);

                if (cell == null) {
                    continue;
                }
                TiledMapTile tile = cell.getTile();
                if (tile == null) {
                    continue;
                }
                if (tile.getId() == GRASS_TILE_ID && getStaticLayer().getCell(x,y)==null) {
                    if (Math.random() < WALL_DENSITY) {
                        TiledMapTileLayer.Cell brickCell = new TiledMapTileLayer.Cell();
                        brickCell.setTile(brickTile);
                        getDynamicLayer().setCell(x, y, brickCell);
                    }
                }
            }

        }


        
        getDynamicLayer().setCell(1, 1, null);
        getDynamicLayer().setCell(2, 1, null);
        getDynamicLayer().setCell(1, 2, null);
        
        getDynamicLayer().setCell(24, 1, null);
        getDynamicLayer().setCell(25, 1, null);
        getDynamicLayer().setCell(25, 2, null);
        
        getDynamicLayer().setCell(24, 25, null);
        getDynamicLayer().setCell(25, 24,null);
        getDynamicLayer().setCell(25, 25, null);
        
        getDynamicLayer().setCell(1, 25, null);
        getDynamicLayer().setCell(2, 25, null);
        getDynamicLayer().setCell(1, 24, null);
    }


    /*
    * 
    */
    public void addBombToMap(Vector2 position){

        int col = (Math.round(position.x / TILE_SIZE));
        int row = (Math.round(position.y / TILE_SIZE));
        
        TiledMapTileSet tileset = map.getTileSets().getTileSet("tiles");
        TiledMapTileLayer.Cell bombCell = new TiledMapTileLayer.Cell();
        bombCell.setTile(tileset.getTile(TextureID.BOMB.id));
        getDynamicLayer().setCell(col, row, bombCell);
        
    }

    /*
    * 
    */
    public void removeBombFromMap(Vector2 position){

        int col = (Math.round(position.x / TILE_SIZE));
        int row = (Math.round(position.y / TILE_SIZE));
        
        getDynamicLayer().setCell(col, row, null);
    }
    public void addExplosionToMap(Explosion explosion){

        for (ExplosionTile tile : explosion.getExplosion()) {
            Vector2 position = tile.getPosition();
            
            int col = (Math.round(position.x / TILE_SIZE));
            int row = (Math.round(position.y / TILE_SIZE));
            
            TiledMapTileSet tileset = map.getTileSets().getTileSet("tiles");
            TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();
            cell.setTile(tileset.getTile(EXPLOSION_TILE_ID));
            getDynamicLayer().setCell(col, row, cell);
        }
    }

    /*
    * 
    */
    public void removeExplosionFromMap(Explosion explosion){

        for (ExplosionTile tile : explosion.getExplosion()) {
            Vector2 position = tile.getPosition();

            int col = (Math.round(position.x / TILE_SIZE));
            int row = (Math.round(position.y / TILE_SIZE));
            
            getDynamicLayer().setCell(col, row, null);
        }
    }
    
    
    /**
     * Removes walls and powerups in this position. 
     * 1/4 chance of spawning a powerup in its place.
     * @param position
     */
    public void breakWall(Vector2 position){
        int col = (Math.round(position.x / TILE_SIZE));
        int row = (Math.round(position.y / TILE_SIZE));
        
        TiledMapTileLayer.Cell nullCell = null;
        
        // Kill powerups that are in the cell already.
        
        getPowerupLayer().setCell(col, row, nullCell);
        
        
        if(containsBrickWall(position)){
            int spawn = ThreadLocalRandom.current().nextInt(0, POWERUP_SPAWN_CHANCE);
            if (spawn == 0){
                getPowerupLayer().setCell(col, row, getPowerup());
            }
            getDynamicLayer().setCell(col, row, nullCell);
        }
    }
    
    /**
     * Gets a random powerup to put in a cell.
     * @return Cell with a powerup.
     */
    private TiledMapTileLayer.Cell getPowerup(){
        

        TiledMapTileSet tileset = map.getTileSets().getTileSet("tiles");
        TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();
        cell.setTile(tileset.getTile(TextureID.getRandomPowerup()));
        return cell;
    }
    public void removePowerupFromMap(Vector2 position){
        
        int col = (Math.round(position.x / TILE_SIZE));
        int row = (Math.round(position.y / TILE_SIZE));

        getPowerupLayer().setCell(col, row, null);
    }
    
    /**
     * checks if a vector position overlaps with a solid wall.
     * @param position
     * @return if there is solid wall here
     */
    public boolean containsSolidWall(Vector2 position){
        
        int col = (Math.round(position.x / TILE_SIZE));
        int row = (Math.round(position.y / TILE_SIZE));
        
        if(getStaticLayer().getCell(col, row) == null){
            return false;
        }
        
        return true;
    }
    
    /**
     * checks if a vector position overlaps with a breakable wall.
     * @param position
     * @return if there is breakable wall here
     */
    public boolean containsBrickWall(Vector2 position){

        TiledMapTileLayer.Cell cell = getCellFromVector("Dynamic", position);
        
        if(cell == null){
            return false;
        }
        if(cell.getTile() == tileset.getTile(BRICK_TILE_ID)){
            return false;
        }
        
        return true;
    }
    
    /**
     * checks if a vector position overlaps with an explosion.
     * @param position
     * @return if there is explosion here
     */
    public boolean containsExplosion(Vector2 position){

        int col = (Math.round(position.x / TILE_SIZE));
        int row = (Math.round(position.y / TILE_SIZE));

        if(getDynamicLayer().getCell(col, row) == null){
            return false;
        }

        return true;
    }
    
    

    public void setCellFromVector(String layerName, Vector2 position, int id){

        int col = (Math.round(position.x / TILE_SIZE));
        int row = (Math.round(position.y / TILE_SIZE));

        TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();
        TiledMapTileLayer layer = getLayerByName(layerName);

        layer.setCell(col, row, cell);
    }
    
    public com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell getCellFromVector(String layerName, Vector2 position){

        int col = (Math.round(position.x / TILE_SIZE));
        int row = (Math.round(position.y / TILE_SIZE));

        TiledMapTileLayer layer = getLayerByName(layerName);

        return layer.getCell(col, row);
    }
}

