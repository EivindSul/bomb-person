package inf112.bomberperson.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class SpeedBoost extends Powerup{

    private String texture = "doc/assets/speedboost.png";


    public SpeedBoost(Vector2 position){
        super(position);
        
    };

    public void pickup(Player player){
        super.pickup(player);

        // player.speedBoost();
    }


}
