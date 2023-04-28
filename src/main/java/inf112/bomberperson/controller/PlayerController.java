package inf112.bomberperson.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
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
    private Sound sound= Gdx.audio.newSound(Gdx.files.internal("doc/assets/Sounds/zapsplat_foley_footstep_single_on_dirty_stone_step_flip_flop_004_30440.mp3"));

    public PlayerController(final Player player, Model model) {


        // Player moves up
        playerUp = new ICallable<Void>(){
            public Void call(){
                playSound();
                velocityPlayer = player.getVelocity(); // Get current velocity
                velocityPlayer.y += player.getSpeed(); // Add speed to velocity
                player.setVelocity(velocityPlayer); // Set new velocity
                return null;
            }
        };

        // Player moves down
        playerDown = new ICallable<Void>(){
            public Void call(){
                playSound();
                velocityPlayer = player.getVelocity();
                velocityPlayer.y -= player.getSpeed();
                player.setVelocity(velocityPlayer);
                return null;
            }
        };

        // Player moves right
        playerRight = new ICallable<Void>(){
            public Void call(){
                playSound();
                velocityPlayer = player.getVelocity();
                velocityPlayer.x += player.getSpeed();
                player.setVelocity(velocityPlayer);
                return null;
            }
        };

        // Player moves left
        playerLeft = new ICallable<Void>(){
            public Void call(){
                playSound();
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
                stopSound();
                player.setVelocity(new Vector2((player.velocity.x = player.getVelocity().x), player.velocity.y = 0));
                return null;
            }
        };
        
        // Player stops moving horizontally
        playerStopHori = new ICallable<Void>(){
            public Void call(){
                stopSound();
                player.setVelocity(new Vector2((player.velocity.x = 0), player.velocity.y = player.getVelocity().y));
                return null;
            }
        };
    }

    void stopSound(){
        sound.stop();
    }

    void playSound(){
        long id = sound.loop();
        sound.setVolume(id, 0.6f );
    }
}

