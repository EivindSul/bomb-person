package inf112.bomberperson.model;

import com.badlogic.gdx.math.Vector2;


public class Bomb {
    private float x;
    private float y;
    private int range;
    private int power;
    
    public Bomb(Vector2 position, int bombRange, int bombPower){

        this.setX(position.x);
        this.setY(position.y);

        position = (new Vector2(this.getX(), this.getY()));

        this.range = bombRange;
        this.power = bombPower;
    }

    public float getX(){
        return this.x;
    }

    public float getY(){
        return this.y;
    }

    public void setX(float x){
        this.x = x;
    }

    public void setY(float y){
        this.y = y;
    }

    public Vector2 getPosition(){
        return new Vector2(getX(), getY());
    }

    public int getRange(){
        return this.range;
    }


    public Explosion explodeBomb(){
        Explosion explosion = new Explosion(this.getPosition(), this.getRange(), this.getPower());
        return explosion;
    }
    private int getPower() {
        return this.power;
    }

}


