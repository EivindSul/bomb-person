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

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private TiledMap map;
    private OrthogonalTiledMapRenderer mapRenderer;
    
    TiledMapTile[] wallTiles;
    private Viewport viewport;

    public Map(){
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
        TiledMapTile wallTile1 = tileset.getTile(TextureID.SOLID_WALL.id);
        wallTiles = new TiledMapTile[]{wallTile1};

        // Randomly generate the map
        generateMap();
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


    public float getWidth() {
        return MAP_WIDTH;
    }
    public float getHeight() {
        return MAP_HEIGHT;
    }

    public OrthogonalTiledMapRenderer getMapRenderer() {
        return mapRenderer;
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

    /**
     * Randomize the brick pattern and clear the corners on the map.
     */
    public void generateMap() {
        
        // Randomly remove bricks from pre-determined positions
        for (int x = 0; x < MAP_WIDTH - 2; x++) {
            for (int y = 0; y < MAP_HEIGHT - 2; y++) {
                if (containsBrickWall(x, y)) {
                    if (Math.random() < WALL_DENSITY) {
                        clearCell("Dynamic", x, y);;
                    }
                }
            }
        }

        // Randomly place bricks on the remaining cells
        for (int x = 0; x < MAP_WIDTH - 2; x++) {
            for (int y = 0; y < MAP_HEIGHT - 2; y++) {
                if (!containsSolidWall(x, y)) {
                    if (Math.random() < WALL_DENSITY) {
                        setCell("Dynamic", x, y, TextureID.BRICK_WALL.id);;
                    }
                }
            }
        }

        // Make sure corners are clear, which is where the players spawn.
        clearCell("Dynamic", 1, 1);
        clearCell("Dynamic", 2, 1);
        clearCell("Dynamic", 1, 2);
        
        clearCell("Dynamic", 24, 1);
        clearCell("Dynamic", 25, 1);
        clearCell("Dynamic", 25, 2);
        
        clearCell("Dynamic", 24, 25);
        clearCell("Dynamic", 25, 25);
        clearCell("Dynamic", 25, 24);
        
        clearCell("Dynamic", 2, 25);
        clearCell("Dynamic", 1, 25);
        clearCell("Dynamic", 1, 24);
    }


    public void addBombToMap(Vector2 position){
        setCell("Dynamic", position, TextureID.BOMB.id);
    }

    public void removeBombFromMap(Vector2 position){
        clearCell("Dynamic", position);
    }

    public void addExplosionToMap(Explosion explosion){
        for (ExplosionTile tile : explosion.getExplosion()) {
            Vector2 position = tile.getPosition();
            setCell("Dynamic", position, TextureID.EXPLOSION.id);
        }
    }


    public void removeExplosionFromMap(Explosion explosion){
        for (ExplosionTile tile : explosion.getExplosion()) {
            Vector2 position = tile.getPosition();
            clearCell("Dynamic", position);
        }
    }
    
    /**
     * Removes walls and powerups in this position. 
     * 1/4 chance of spawning a powerup in its place.
     * @param position
     */
    public void breakWall(Vector2 position){
        // Kill powerups that are in the cell already.
        removePowerupFromMap(position);

        if(containsBrickWall(position)){
            trySpawnPowerup(position);
            clearCell("Dynamic", position);
        }
    }
    
    /**
     * Try to spawn a powerup in this location. Chance for powerup is determined by static value POWERUP_SPAWN_CHANCE
     * @param position
     */
    private void trySpawnPowerup(Vector2 position) {
        int spawn = ThreadLocalRandom.current().nextInt(0, POWERUP_SPAWN_CHANCE);
        if (spawn == 0){
            int powerupID = TextureID.getRandomPowerup();
            setCell("Powerup", position, powerupID);
        }
    }

    /**
     * Remove powerup from this location
     * @param position
     */
    public void removePowerupFromMap(Vector2 position){
        int col = (Math.round(position.x / TILE_SIZE));
        int row = (Math.round(position.y / TILE_SIZE));
        this.removePowerupFromMap(col, row);
    }

    /**
     * Remove powerup from this location
     * @param col
     * @param row
     */
    public void removePowerupFromMap(int col, int row){
        clearCell("Powerup", col, row);;
    }
    
    /**
     * checks if a vector position overlaps with a solid wall.
     * @param position
     * @return if there is solid wall here
     */
    public boolean containsSolidWall(Vector2 position){
        int col = (Math.round(position.x / TILE_SIZE));
        int row = (Math.round(position.y / TILE_SIZE));
        return this.containsSolidWall(col, row);
    }

    /**
     * checks if a vector position overlaps with a solid wall.
     * @param position
     * @return if there is solid wall here
     */
    public boolean containsSolidWall(int col, int row){

        TiledMapTileLayer.Cell cell = getCell("Static", col, row);
        
        if(cell == null){
            return false;
        }
        
        return true;
    }
    
    /**
     * checks if a vector position overlaps with a breakable wall.
     * @param position
     * @return if there is brick wall here
     */
    public boolean containsBrickWall(Vector2 position){
        int col = (Math.round(position.x / TILE_SIZE));
        int row = (Math.round(position.y / TILE_SIZE));
        return this.containsBrickWall(col, row);
    }

    /**
     * checks if a vector position overlaps with a breakable wall.
     * @param col
     * @param row
     * @return if there is brick wall here
     */
    public boolean containsBrickWall(int col, int row){
        TiledMapTileLayer.Cell cell = getCell("Dynamic", col, row);
        
        if(cell == null){
            return false;
        }
        if(cell.getTile() == tileset.getTile(TextureID.BRICK_WALL.id)){
            return true;
        }
        
        return false;
    }
    
    /**
     * checks if a vector position overlaps with an explosion.
     * @param position
     * @return if there is explosion here
     */
    public boolean containsExplosion(Vector2 position){
        int col = (Math.round(position.x / TILE_SIZE));
        int row = (Math.round(position.y / TILE_SIZE));
        return this.containsExplosion(col, row);
    }

    /**
     * checks if a vector position overlaps with an explosion.
     * @param col
     * @param row
     * @return if there is explosion here
     */
    public boolean containsExplosion(int col, int row){
        TiledMapTileLayer.Cell cell = getCell("Dynamic", col, row);
        
        if(cell == null){
            return false;
        }
        if(cell.getTile() == tileset.getTile(TextureID.EXPLOSION.id)){
            return true;
        }
        return false;
    }
    
    /**
     * checks if a vector position overlaps with a bomb.
     * @param position
     * @return if there is bomb here
     */
    public boolean containsBomb(Vector2 position){
        int col = (Math.round(position.x / TILE_SIZE));
        int row = (Math.round(position.y / TILE_SIZE));
        return this.containsBomb(col, row);
    }
    
    /**
     * checks if a vector position overlaps with a bomb.
     * @param col
     * @param row
     * @return if there is bomb here
     */
    public boolean containsBomb(int col, int row){
        TiledMapTileLayer.Cell cell = getCell("Dynamic", col, row);
        
        if(cell == null){
            return false;
        }
        if(cell.getTile() == tileset.getTile(TextureID.BOMB.id)){
            return true;
        }
        return false;
    }
    

    /**
     * Set this cell to contain an tile.
     * Layers:
     * "Dynamic" is for bombs, explosions, brick walls. 
     * "Powerup" is for powerups
     * "Static" is for unbreakable walls
     * "Ground" is for the ground
     * @param layerName "Dynamic" is for bombs, explosions, brick walls. "Powerup is for powerups"
     * @param position
     * @param id texture id, some are specified in TextureID.java
     */
    public void setCell(String layerName, Vector2 position, int id){
        int col = (Math.round(position.x / TILE_SIZE));
        int row = (Math.round(position.y / TILE_SIZE));
        this.setCell(layerName, col, row, id);
    }
    
    /**
     * Set this cell to contain an tile.
     * Layers:
     * "Dynamic" is for bombs, explosions, brick walls. 
     * "Powerup" is for powerups
     * "Static" is for unbreakable walls
     * "Ground" is for the ground
     * @param layerName "Dynamic" is for bombs, explosions, brick walls. "Powerup is for powerups"
     * @param col
     * @param row
     * @param id texture id, some are specified in TextureID.java
     */
    public void setCell(String layerName, int col, int row, int id){

        TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();
        cell.setTile(tileset.getTile(id));
        TiledMapTileLayer layer = getLayerByName(layerName);

        layer.setCell(col, row, cell);
    }

    /** Remove tile in this layer on this position
     * Layers:
     * "Dynamic" is for bombs, explosions, brick walls. 
     * "Powerup" is for powerups
     * "Static" is for unbreakable walls
     * "Ground" is for the ground
     * @param layerName
     * @param position
     */
    public void clearCell(String layerName, Vector2 position){
        int col = (Math.round(position.x / TILE_SIZE));
        int row = (Math.round(position.y / TILE_SIZE));
        this.clearCell(layerName, col, row);
    }

    /** Remove tile in this layer on this position
     * Layers:
     * "Dynamic" is for bombs, explosions, brick walls. 
     * "Powerup" is for powerups
     * "Static" is for unbreakable walls
     * "Ground" is for the ground
     * @param layerName
     * @param col
     * @param row
     */
    public void clearCell(String layerName, int col, int row){

        TiledMapTileLayer layer = getLayerByName(layerName);

        layer.setCell(col, row, null);
    }
    
    /**Get the cell content in this layer on this position.
     * Layers:
     * "Dynamic" is for bombs, explosions, brick walls. 
     * "Powerup" is for powerups
     * "Static" is for unbreakable walls
     * "Ground" is for the ground
     * @param layerName
     * @param position
     * @return Cell in this location
     */
    public com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell getCell(String layerName, Vector2 position){
        int col = (Math.round(position.x / TILE_SIZE));
        int row = (Math.round(position.y / TILE_SIZE));

        return this.getCell(layerName, col, row);
    }

    /**Get the cell content in this layer on this position.
     * Layers:
     * "Dynamic" is for bombs, explosions, brick walls. 
     * "Powerup" is for powerups
     * "Static" is for unbreakable walls
     * "Ground" is for the ground
     * @param layerName
     * @param col
     * @param row
     * @return Cell in this location
     */
    public com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell getCell(String layerName, int col, int row){

        TiledMapTileLayer layer = getLayerByName(layerName);

        return layer.getCell(col, row);
    }
}
