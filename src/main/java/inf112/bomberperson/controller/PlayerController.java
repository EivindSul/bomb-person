package inf112.bomberperson.controller;

import com.badlogic.gdx.math.Vector2;

import inf112.bomberperson.model.Model;
import inf112.bomberperson.model.Player;

/**
 * PlayerController
 */
public class PlayerController {
    public ICallable<Void> playerUp;
    public ICallable<Void> playerRight;
    public ICallable<Void> playerDown;
    public ICallable<Void> playerLeft;
    public ICallable<Void> playerDrop;

    public ICallable<Void> playerStopVert;
    public ICallable<Void> playerStopHori;

    private Vector2 velocityPlayer;

    public PlayerController(final Player player, Model model) {

        // Player moves up
        playerUp = new ICallable<Void>(){
            public Void call(){
                velocityPlayer = player.getVelocity(); // Get current velocity
                velocityPlayer.y += player.getSpeed(); // Add speed to velocity
                player.setVelocity(velocityPlayer); // Set new velocity
                return null;
            }
        };

        // Player moves down
        playerDown = new ICallable<Void>(){
            public Void call(){
                velocityPlayer = player.getVelocity();
                velocityPlayer.y -= player.getSpeed();
                player.setVelocity(velocityPlayer);
                return null;
            }
        };

        // Player moves right
        playerRight = new ICallable<Void>(){
            public Void call(){
                velocityPlayer = player.getVelocity();
                velocityPlayer.x += player.getSpeed();
                player.setVelocity(velocityPlayer);
                return null;
            }
        };

        // Player moves left
        playerLeft = new ICallable<Void>(){
            public Void call(){
                velocityPlayer = player.getVelocity();
                velocityPlayer.x -= player.getSpeed();
                player.setVelocity(velocityPlayer);
                return null;
            }
        };

        // Player drops bomb
        playerDrop = new ICallable<Void>(){
            public Void call(){
                model.addBomb(player);
                return null;
            }
        };

        // Player stops moving vertically
        playerStopVert = new ICallable<Void>(){
            public Void call(){
                player.setVelocity(new Vector2((player.velocity.x = player.getVelocity().x), player.velocity.y = 0));
                return null;
            }
        };
        
        // Player stops moving horizontally
        playerStopHori = new ICallable<Void>(){
            public Void call(){
                player.setVelocity(new Vector2((player.velocity.x = 0), player.velocity.y = player.getVelocity().y));
                return null;
            }
        };
    }
}

