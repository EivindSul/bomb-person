package inf112.bomberperson.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import inf112.bomberperson.model.Player;
import inf112.bomberperson.screens.animations.PlayerAnimations;

public class PlayerRenderer {


    private float time;
    public Player player;
    public Player player2;


    public PlayerAnimations animations;


    public PlayerRenderer(Player player){
        this.player = player;
        this.animations = new PlayerAnimations(player);
    }

    /**
     *
     * @param spriteBatch
     */
    public void draw(Batch spriteBatch){
        time += Gdx.graphics.getDeltaTime();

        spriteBatch.draw(animations.getActiveAnimation().getKeyFrame(time, true), player.getX(), player.getY());


    }

}
