package inf112.bomberperson.model;
import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import inf112.bomberperson.model.animations.PlayerAnimations;

public class Player extends Sprite implements Collidable {
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

    private boolean alive = true;
    private LinkedList<Bomb> bombList = new LinkedList<Bomb>();
    private int bombLimit = 1;
    private int bombRange = 1;
    private int bombPower = 1;

    private int speed = 100;
    
    public Player(Sprite sprite){
        super(sprite);
        animations = new PlayerAnimations(this);
        setSize(10,10);
        this.time = 0;
        
        //initializing player direction and state
        this.currentDirection = Direction.UP;
        this.currentState = State.WALKING;
    }
    public void draw(Batch spriteBatch){
        time += Gdx.graphics.getDeltaTime();
        if(alive) {
            spriteBatch.draw(animations.getActiveAnimation().getKeyFrame(time, true), getX(), getY());
        }
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
    
    
    /*------------------- POSITION -------------------*/
    
    public Vector2 getPosition(){
        return new Vector2(getX(), getY());
    }
    public int getSpeed(){
        return this.speed;
    }
    
    /*------------------- DROP BOMBS -------------------*/
    
    public boolean dropBomb() {

        if (bombList.size() >= getBombLimit()){
            return false;
        }
        Bomb bomb = new Bomb(this.getPosition(), this.getBombRange(), this.getBombPower());
        bombList.add(bomb);
        return true;
        
    }
    
    public boolean noBombs(){
        return bombList.isEmpty();
    }
    
    /*------------------- GET BOMB LIST -------------------*/
    
    public LinkedList<Bomb> getBombList(){
        return this.bombList;
    }
    
    public Bomb popBombList(){
        return this.bombList.pop();
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
    
    private int getBombRange() {
        return this.bombRange;
    }

    public void incrementBombRange() {
        this.bombRange += 1;
    }

    public void increaseSpeed() {
        this.speed += 20;
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
}
