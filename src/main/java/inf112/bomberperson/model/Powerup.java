package inf112.bomberperson.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class Powerup extends Sprite{
    private SpriteBatch batch;
    private Texture texture = new Texture("doc/assets/bomb.png");

    public Powerup(Vector2 position, String texture){
        super(new Sprite(new Texture(texture)));

        this.setX(position.x);
        this.setY(position.y);

        position = (new Vector2(this.getX(), this.getY()));

        batch = new SpriteBatch();
    }
    public void draw(SpriteBatch spriteBatch){
        // update(Gdx.graphics.getDeltaTime());
        super.draw(spriteBatch);
    }
    public SpriteBatch getBatch(){
        return this.batch;
    }

    public void pickup(Player player){
        
    }


}
