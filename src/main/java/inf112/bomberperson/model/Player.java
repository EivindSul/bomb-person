package inf112.bomberperson.model;

<<<<<<< HEAD

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class Player {
    private Vector2 position;

    public Player(TiledMapTileLayer groundLayer) {
        setPosition(getRandomGrassTile(groundLayer));
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public boolean collideWithTile(Map.TileType tileType) {
        int tileX = (int) (position.x / Map.TILE_SIZE);
        int tileY = (int) (position.y / Map.TILE_SIZE);

        switch (tileType) {
            case GRASS:
                return false;
            case BRICK:
                if (Map.explodableWallLayer.getCell(tileX, tileY) != null) {
                    Map.explodableWallLayer.setCell(tileX, tileY, new TiledMapTileLayer.Cell());
                    return true;
                }
                return false;
            case WALL:
                if (Map.wallLayer.getCell(tileX, tileY) != null) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    private Vector2 getRandomGrassTile(TiledMapTileLayer groundLayer) {
        while (true) {
            int x = Map.random.nextInt(Map.MAP_WIDTH);
            int y = Map.random.nextInt(Map.MAP_HEIGHT);
            if (groundLayer.getCell(x, y).getTile().getId() == Map.GRASS_TILE_ID) {
                return new Vector2(x * Map.TILE_SIZE, y * Map.TILE_SIZE);
            }
        }
    }

    public void update(float deltaTime, Map map) {
        // Move the player according to its velocity
        position.add(velocity.cpy().scl(deltaTime));

        // Check for collisions with walls and bricks
        if (map.isCellBlocked(position.x, position.y)) {
            // Undo the move
            position.sub(velocity.cpy().scl(deltaTime));
            // Stop the player from moving in the blocked direction
            velocity.set(0, 0);
        }
    }
=======
import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;

public class Player extends Sprite implements InputProcessor {

    //the movement velocity
    public Vector2 velocity = new Vector2();
    private float speed = 50 * 2, gravity = 60 *1.8f;
    private TiledMapTileLayer wallLayer;
    private  TiledMapTileLayer explodableWallLayer;
    private String blockedKey = "blocked";

    public Player(Sprite sprite, TiledMapTileLayer wallLayer, TiledMapTileLayer explodableWallLayer){
        super(sprite);
        this.wallLayer = wallLayer;
        this.explodableWallLayer = explodableWallLayer;
        setSize(14, 14);


    }
    public void draw(Batch spriteBatch){
        update(Gdx.graphics.getDeltaTime());
        super.draw(spriteBatch);
    }
    public void update(float delta){


        //save old position
        float oldX = getX();
        float oldY = getY();
        boolean wallCollisionX = false, wallCollisionY = false;
        boolean brickCollisionX = false, brickCollisionY = false;
        //move on x
        setX(getX() + velocity.x * delta);
        if(velocity.x < 0){ //going left
            wallCollisionX = collidesLeft(wallLayer);
            brickCollisionX = collidesLeft(explodableWallLayer);

        }
        else if(velocity.x > 0){//going right
            wallCollisionX = collidesRight(wallLayer);
            brickCollisionX = collidesRight(explodableWallLayer);

        }
        //react to x collision
        if(wallCollisionX || brickCollisionX){
            setX(oldX);
            velocity.x = 0;
        }


        //move on y
        setY(getY() + velocity.y *delta);
        if(velocity.y <0){ //going down
            wallCollisionY = collidesBottom(wallLayer);
            brickCollisionY = collidesBottom(explodableWallLayer);

        }
        else if(velocity.y > 0){ //going up
            wallCollisionY = collidesTop(wallLayer);
            brickCollisionY = collidesTop(explodableWallLayer);

        }
        //react to y collision
        if(wallCollisionY || brickCollisionY){
            setY(oldY);
            velocity.y = 0;
        }
    }

    private boolean isCellBlocked(float x, float y, TiledMapTileLayer layer){

        TiledMapTileLayer.Cell cell = layer.getCell((int) (x / layer.getTileWidth()), (int) (y/ layer.getTileHeight()));
        return cell != null && cell.getTile() != null && cell.getTile().getProperties().containsKey(blockedKey);

    }
    public boolean collidesRight(TiledMapTileLayer layer){
        boolean collides = false;
        for(float step = 0; step < getHeight(); step += layer.getTileHeight()/2){
            try {
            collides = isCellBlocked(getX() + getWidth(), getY() + step, layer);
            if (collides){
                break;
            }
            }
            catch (Exception e){
                continue;
            }
        }

        return collides;
    }
    public boolean collidesLeft(TiledMapTileLayer layer){
        boolean collides = false;
        for(float step = 0; step < getHeight(); step += layer.getTileHeight()/2){
            try {
            collides = isCellBlocked(getX() , getY() + step, layer);
            if (collides){
                break;
            }
            }catch (Exception e){
                continue;
            }
        }

        return collides;
    }

    public boolean collidesTop(TiledMapTileLayer layer){
        boolean collides = false;
        for(float step = 0; step < getWidth(); step += layer.getTileWidth()/2){
            try {
            collides = isCellBlocked(getX() + step, getY() + getHeight(), layer);
            if (collides){
                break;
            }
            }
            catch (Exception e){
                continue;
            }
        }

        return collides;
    }
    public boolean collidesBottom(TiledMapTileLayer layer){
        boolean collides = false;

        for(float step = 0; step < getWidth(); step += layer.getTileWidth()/2){
            try {
            collides = isCellBlocked(getX() + step, getY(), layer);
            if (collides){
                break;
            }
            } catch (Exception e){
                continue;
            }
        }

        return collides;
    }






    public void dropBomb(){
        addBomb();
    }

    private void addBomb() {
        // TODO: make bomb go to tile and not just position, to avoid bombs being off-grid. Players move gradually, but bombs need to snap to grid.
        if (bombList.size() <= getNumberOfBombs()){
            Bomb bomb = new Bomb(this.getPosition(), this.getBombRange(), this.getBombPower());
            bombList.add(bomb);
        }
    }
    public boolean noBombs(){
        return bombList.isEmpty();
    }

    private int getBombRange() {
        return this.bombRange;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getGravity() {
        return gravity;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    public TiledMapTileLayer getWallLayer() {
        return wallLayer;
    }

    public void setWallLayer(TiledMapTileLayer wallLayer) {
        this.wallLayer = wallLayer;
    }

    public TiledMapTileLayer getExplodableWallLayer() {
        return explodableWallLayer;
    }

    public void setExplodableWallLayer(TiledMapTileLayer explodableWallLayer) {
        this.explodableWallLayer = explodableWallLayer;
    }

    public Vector2 getPosition(){
        return new Vector2(getX(), getY());
    }


    public int getNumberOfBombs() {
        return 0;
    }

    @Override
    public boolean keyDown(int i) {
        switch (i){
            case Input.Keys.W:
                velocity.y = speed;
                break;
            case Input.Keys.S:
                velocity.y = -speed;
                break;
            case Input.Keys.A:
                velocity.x = -speed;
                break;
            case Input.Keys.D:
                velocity.x = speed;
        }
        return true;
    }

    @Override
    public boolean keyUp(int i) {
        switch (i){
            case Input.Keys.A:
            case Input.Keys.D:
                velocity.x = 0;
            case Input.Keys.W:
            case Input.Keys.S:
                velocity.y = 0;

        }
        return true;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        return false;
    }


    // ---------------EIVIND KODE-----------------

    // public class Player extends Sprite {
    //     private SpriteBatch batch;
    //     private int width;
    //     private int height;
    //     private Texture texture;
    //     private Vector2 position;

        private LinkedList<Bomb> bombList = new LinkedList<Bomb>();
        private int numberOfBombs = 1;
        private int bombRange = 1;
        private int bombPower = 1;

        private int movementSpeed = 3;

        // public Player(){
        //     batch = new SpriteBatch();
        //     // TODO: add path to texture
        //     texture = new Texture("morendin/sin/mappe");
        // }
        // public void draw(){
        //     batch.draw(this.texture, width, height);
        // }


        /*------------------- DROP BOMBS -------------------*/

        // public void dropBomb(){
        //     addBomb();
        // }

        // private void addBomb() {
        //     // TODO: make bomb go to tile and not just position, to avoid bombs being off-grid. Players move gradually, but bombs need to snap to grid.
        //     if (bombList.size() <= getNumberOfBombs()){
        //         Bomb bomb = new Bomb(this.position, this.bombRange, this.bombPower);
        //         bombList.add(bomb);
        //     }
        // }

        /*------------------- GET BOMB LIST -------------------*/

        public LinkedList<Bomb> getBombList(){
            return this.bombList;
        }
        public Bomb popBombList(){
            return this.bombList.pop();
        }

        /*------------------- NUMBER OF BOMBS -------------------*/

        // public int getNumberOfBombs() {
        //     return this.numberOfBombs;
        // }
        public void incrementNumberOfBombs() {
            this.numberOfBombs += 1;
        }
        public void allowInfiniteBombs() {
            this.numberOfBombs += 1000;
        }
        public void disallowInfiniteBombs() {
            this.numberOfBombs -= 1000;
        }


        /*------------------- POWER OF BOMBS -------------------*/

        public int getBombPower(){
            return this.bombPower;
        }
        public void setBombPower(int bombPower){
            this.bombPower = bombPower;
        }
        public void incrementBombPower(){
            this.bombPower += 1;
        }


        /*------------------- MOVEMENT -------------------*/

        // public void moveUp(){
        //     this.position = getPositionUp();
        // }
        // public void moveRight() {
        //     this.position = getPositionRight();
        // }
        // public void moveDown() {
        //     this.position = getPositionDown();
        // }
        // public void moveLeft() {
        //     this.position = getPositionLeft();
        // }

        // public void invertMovement(){
        //     this.movementSpeed *= -1;
        // }

        // public Vector2 getPositionUp(){
        //     return new Vector2(getPositionX(),getPositionY() + getMovementSpeed());
        // }
        // public Vector2 getPositionRight(){
        //     return new Vector2(getPositionX() + getMovementSpeed(),getPositionY());
        // }
        // public Vector2 getPositionDown(){
        //     return new Vector2(getPositionX(),getPositionY() - getMovementSpeed());
        // }
        // public Vector2 getPositionLeft(){
        //     return new Vector2(getPositionX() - getMovementSpeed(),getPositionY());
        // }

        // public float getMovementSpeed() {
        //     return this.movementSpeed;
        // }

        /*------------------- GET POSITION -------------------*/
        // public float getPositionX(){
        //     return this.position.x;
        // }
        // public float getPositionY(){
        //     return this.position.y;
        // }
        // public Vector2 getPosition(){
        //     return this.position;
        // }





>>>>>>> merger
}
