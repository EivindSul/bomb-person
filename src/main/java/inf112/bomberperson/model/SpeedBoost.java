package inf112.bomberperson.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class SpeedBoost extends Powerup{

    private String texture = "doc/assets/speedboost.png";


    public SpeedBoost(Vector2 position){
        super(position, "doc/assets/speedboost.png");
        
    };
    public void draw(SpriteBatch spriteBatch){
        super.draw(spriteBatch);
    }
    public SpriteBatch getBatch(){
        return super.getBatch();
    }

    public void pickup(Player player){
        super.pickup(player);

        // player.speedBoost();
    }


}
