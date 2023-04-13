package inf112.bomberperson.model;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.event.MouseInputListener;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

import inf112.bomberperson.model.Player;
import inf112.bomberperson.model.Model;

/**
 * Controller
 */
public class Controller {
    Model model;
    public Controller(Model model){
        this.model = model;
    }
    public void registerInput(){
        //TODO :
        // check collision before moving player, helper method found in model called checkCollision()
        if (Gdx.input.isKeyJustPressed(Keys.W)) { // up

            System.out.println("W");
        }
        if (Gdx.input.isKeyJustPressed(Keys.A)) { // left

            System.out.println("A");
        }
        if (Gdx.input.isKeyJustPressed(Keys.S)) { // down

            System.out.println("S");
        }
        if (Gdx.input.isKeyJustPressed(Keys.D)) { // right

            System.out.println("D");
        }
        if (Gdx.input.isKeyJustPressed(Keys.SPACE)) {
            model.player1.dropBomb(); // bomb is a TileType and has collision
            model.player1.dropBomb();
        }


    }

}

