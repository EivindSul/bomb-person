package inf112.bomberperson.model;
import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

import inf112.bomberperson.model.animations.Animated;
import inf112.bomberperson.model.animations.PlayerAnimations;

public class Player extends Sprite implements Animated, Collidable {
    public enum Direction{
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }
    public enum State {
        IDLE,
        WALKING;
    }
    private Direction currentDirection;
    private State currentState;
    //animations
    PlayerAnimations animations;
    float time;
    //the movement velocity
    public Vector2 velocity = new Vector2();
    private float speed = 50 * 2, gravity = 60 *1.8f;
    private TiledMapTileLayer wallLayer;
    private  TiledMapTileLayer explodableWallLayer;
    private String blockedKey = "blocked";
    

    public Player(Sprite sprite, TiledMapTileLayer wallLayer, TiledMapTileLayer explodableWallLayer){
        super(sprite);
        animations = new PlayerAnimations(this);
        this.wallLayer = wallLayer;
        this.explodableWallLayer = explodableWallLayer;
        setSize(1,1);
        this.time = 0;
        
        //initializing player direction and state
        this.currentDirection = Direction.UP;
        this.currentState = State.WALKING;
    }
    public void draw(Batch spriteBatch){
        update(Gdx.graphics.getDeltaTime());
        time += Gdx.graphics.getDeltaTime();
        spriteBatch.draw(animations.getActiveAnimation().getKeyFrame(time,true), getX(), getY());
    }
    public Direction getCurrentDirection() {
        updateDirectionAndState();
        return currentDirection;
    }
    public State getCurrentState() {
        updateDirectionAndState();
        return currentState;
    }
    private void updateDirectionAndState() {
        if (velocity.x < 0) { // going left
            currentDirection = Direction.LEFT;
            currentState = State.WALKING;
        } else if (velocity.x > 0) { // going right
            currentDirection = Direction.RIGHT;
            currentState = State.WALKING;
        } else if (velocity.y < 0) { // going down
            currentDirection = Direction.DOWN;
            currentState = State.WALKING;
        } else if (velocity.y > 0) { // going up
            currentDirection = Direction.UP;
            currentState = State.WALKING;
        }
        /*
        if ( (velocity.x == 0)||(velocity.y == 0) ) {
            currentState = State.IDLE;
        }
        */
    }
    public void update(float delta){
        //save old position
        //move on x
        setX(getX() + velocity.x * delta);
        //react to x collision
        //move on y
        setY(getY() + velocity.y *delta);
        //react to y collision
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






    public boolean dropBomb(){
        return addBomb();
    }

    private boolean addBomb() {
        // TODO: make bomb go to tile and not just position, to avoid bombs being off-grid. Players move gradually, but bombs need to snap to grid.
        if (bombList.size() <= getNumberOfBombs()){
            Bomb bomb = new Bomb(this.getPosition(), this.getBombRange(), this.getBombPower());
            bombList.add(bomb);
            return true;
        }
        return false;
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
    // ---------------EIVIND KODE-----------------
        private LinkedList<Bomb> bombList = new LinkedList<Bomb>();
        private int numberOfBombs = 1;
        private int bombRange = 1;
        private int bombPower = 1;

        private int movementSpeed = 3;
        /*------------------- DROP BOMBS -------------------*/
        /*------------------- GET BOMB LIST -------------------*/

        public LinkedList<Bomb> getBombList(){
            return this.bombList;
        }
        public Bomb popBombList(){
            return this.bombList.pop();
        }

        /*------------------- NUMBER OF BOMBS -------------------*/
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
        @Override
        public Animation<TextureRegion> getActiveAnimation() {
            // TODO Auto-generated method stub
            return null;
        }
}
