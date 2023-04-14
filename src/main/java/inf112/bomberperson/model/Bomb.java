package inf112.bomberperson.model;

import com.badlogic.gdx.math.Vector2;


public class Bomb extends TileObject{
    
    private int range;
    private int power;
    
    public Bomb(Vector2 position, int bombRange, int bombPower){
        super(position);

        this.range = bombRange;
        this.power = bombPower;
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


