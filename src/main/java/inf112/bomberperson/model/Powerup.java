package inf112.bomberperson.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class Powerup extends TileObject{

    public Powerup(Vector2 position){
        super(position);

    }

    public void pickup(Player player){
        
    }


}
