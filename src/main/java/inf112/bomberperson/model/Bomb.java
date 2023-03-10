package inf112.bomberperson.model;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class Bomb extends Sprite {
    private SpriteBatch batch;
    private int width = 16;
    private int height = 16;
    private Texture texture = new Texture("doc/assets/bomb.png"); 
    private int range;
    private int power;
    
    public Bomb(Vector2 position, int bombRange, int bombPower){
        super(new Sprite(new Texture("doc/assets/bomb.png")));

        this.setX(position.x);
        this.setY(position.y);

        position = (new Vector2(this.getX(), this.getY()));

        this.range = bombRange;
        this.power = bombPower;
        batch = new SpriteBatch();
    }
    public void draw(SpriteBatch spriteBatch){
        // update(Gdx.graphics.getDeltaTime());
        super.draw(spriteBatch);
    }
    public SpriteBatch getBatch(){
        return this.batch;
    }

    // TODO: Temporary, copied from player
    public void update(float delta){
        //save old position
        float oldX = getX();
        float oldY = getY();

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


