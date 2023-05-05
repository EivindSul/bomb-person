package inf112.bomberperson.model;
import java.util.LinkedList;
import com.badlogic.gdx.math.Vector2;
import inf112.bomberperson.model.collision.Collidable;
import inf112.bomberperson.model.tiles.Bomb;

public class Player implements Collidable {
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

    private float x;
    private float y;
    private float width;
    private float height;
    private Direction currentDirection;
    private State currentState;

    //the movement velocity
    public Vector2 velocity = new Vector2();

    private boolean alive = true;
    private int bombLimit = 1;
    private int bombRange = 1;
    private int bombPower = 1;

    private int speed = 100;
    private int number;

    private float powerupDelay = 0;
    
    public Player(int number){
        this.height = 10;
        this.width = 10;
        this.number = number;
        //initializing player direction and state
        this.currentDirection = Direction.UP;
        this.currentState = State.WALKING;
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

    }
    public void update(float delta){
        setX(getX() + velocity.x * delta);
        setY(getY() + velocity.y * delta);
    }

    public void killPlayer(){
        alive = false;
    }
    public boolean getAlive(){
        return this.alive;
    }
    public Vector2 getVelocity() {
        return velocity;
    }
    public void setVelocity(Vector2 velocity) {
        float velX = velocity.x; // * speed;
        float velY = velocity.y; // * speed;
        
        this.velocity = new Vector2(velX, velY);
    }
    public Vector2 getPosition(){
        return new Vector2(getX(), getY());
    }
    public void setPosition(float x, float y) {
        this.setX(x);
        this.setY(y);
    }
    public int getSpeed(){
        return this.speed;
    }
    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }
    @Override
    public float getX() {
        return this.x;
    }
    @Override
    public float getY() {
        return this.y;
    }
    @Override
    public float getWidth() {
        return this.width;
    }

    @Override
    public float getHeight() {
        return this.height;
    }
    
    /*------------------- NUMBER OF BOMBS -------------------*/
    
    public int getBombLimit() {
        return bombLimit;
    }
    
    public void incrementBombLimit() {
        this.bombLimit += 1;
    }
    public void allowInfiniteBombs() {
        this.bombLimit += 1000;
    }
    public void disallowInfiniteBombs() {
        this.bombLimit -= 1000;
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
    
    public int getBombRange() {
        return this.bombRange;
    }

    public void incrementBombRange() {
        this.bombRange += 1;
    }

    public void increaseSpeed() {
        this.speed += 10;
    }
    
    public void applyPowerup(String powerup){
        if (powerup.equals("speedboost")){
            increaseSpeed();
        }
        if (powerup.equals("morebombs")){
            incrementBombLimit();
        }
        if (powerup.equals("morerange")){
            incrementBombRange();
        }
        if (powerup.equals("morepower")){
            incrementBombPower();
        }
    }

    public int getNumber() {
        return this.number;
    }

    public void setPowerupDelay(float time){
        this.powerupDelay = time;
    }
    public float getPowerupDelay(){
        return this.powerupDelay;
    }

}
