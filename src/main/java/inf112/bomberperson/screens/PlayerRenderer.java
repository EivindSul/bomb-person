package inf112.bomberperson.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import inf112.bomberperson.model.Player;
import inf112.bomberperson.screens.animations.PlayerAnimations;

public class PlayerRenderer {


    private float time;
    public Player player;
    public Player player2;


    public PlayerAnimations animations1;
    public PlayerAnimations animations2;


    public PlayerRenderer(Player player1,Player player2){
        this.player = player1;
        this.player2 = player2;
        this.animations1 = new PlayerAnimations(player1);
        this.animations2 = new PlayerAnimations(player2);
    }

    /**
     *
     * @param spriteBatch
     */
    public void draw(Batch spriteBatch){
        time += Gdx.graphics.getDeltaTime();
        spriteBatch.draw(animations1.getActiveAnimation().getKeyFrame(time, true), player.getX(), player.getY());
        spriteBatch.draw(animations2.getActiveAnimation().getKeyFrame(time, true), player2.getX(), player2.getY());
    }
}
