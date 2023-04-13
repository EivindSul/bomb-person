package inf112.bomberperson.model;

import com.badlogic.gdx.math.Vector2;

// ExplosionTile is the tile that looks like an explosion. It will have a collision and kills any players, powerups and breakables it hits.

public class ExplosionTile {
    private float x;
    private float y;
    
    public ExplosionTile(Vector2 position){
        this.setX(position.x);
        this.setY(position.y);
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
        return new Vector2(this.getX(), this.getY());
    }
}
