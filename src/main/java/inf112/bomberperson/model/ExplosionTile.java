package inf112.bomberperson.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

// ExplosionTile is the tile that looks like an explosion. It will have a collision and kills any players, powerups and breakables it hits.

public class ExplosionTile extends Sprite {
    private SpriteBatch batch;
    private int width;
    private int height;
    private Texture texture; 
    
    public ExplosionTile(Vector2 position){
        super(new Sprite(new Texture("doc/assets/explosion-middle.png")));
        this.setX(position.x);
        this.setY(position.y);
        batch = new SpriteBatch();
        // TODO: add path to texture
        texture = new Texture("doc/assets/bomb.png");
    }
    public void draw(SpriteBatch batch){
        super.draw(batch);
    }

    public Vector2 getPosition(){
        return new Vector2(this.getX(), this.getY());
    }
    public float getPositionX() {
        return this.getX();
    }
    public float getPositionY() {
        return this.getY();
    }


}


