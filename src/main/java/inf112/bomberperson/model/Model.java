package inf112.bomberperson.model;

import java.nio.channels.NetworkChannel;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

import inf112.bomberperson.controller.MyInputProcessor;
import inf112.bomberperson.game.BombermanGame;
import inf112.bomberperson.model.collision.Collision;
import inf112.bomberperson.model.map.Map;
import inf112.bomberperson.model.tiles.Bomb;
import inf112.bomberperson.model.tiles.Explosion;
import inf112.bomberperson.model.tiles.ExplosionTile;
import inf112.bomberperson.screens.GameOverScreen;


public class Model {
    private BombermanGame game;
    public Map map;
    public Player player1;
    public Player player2;
    public MyInputProcessor controller;
    private TileFactory tileFactory;
    // Maybe edit to an enum since we will have more than two screens.
    public Boolean gameState; // GAME OVER == FALSE
    Sound killSound;
    Sound powerUpSound;
    Sound dropBombsound;
    Sound bombSound;

    public float time = 0;

    private Collision collision;

    public Model(BombermanGame game){
        this.game = game;

        this.map = new Map();

        killSound = Gdx.audio.newSound(Gdx.files.internal("doc/assets/Sounds/zapsplat_horror_monster_small_dying_screech_003_72195.mp3"));
        powerUpSound = Gdx.audio.newSound(Gdx.files.internal("doc/assets/Sounds/zapsplat_bell_small_hand_short_ring_003_84222.mp3"));
        this.dropBombsound = Gdx.audio.newSound(Gdx.files.internal("doc/assets/Sounds/zapsplat_foley_footstep_single_boys_sneaker_on_concrete_002_50912.mp3"));
        this.bombSound = Gdx.audio.newSound(Gdx.files.internal("doc/assets/Sounds/zapsplat_explosions_designed_huge_fire_bomb_ball_005_89762.mp3"));

        this.player1 = new Player(1);
        this.player2 = new Player(2);

        player1.setPosition(1 * 16, (map.getHeight() - 26) *16);
        player2.setPosition(25 * 16, (map.getHeight() - 2) *16);
        
        this.controller = new MyInputProcessor(this);
        controller.mapInputs();

        this.tileFactory = new TileFactory(this.map);

        ArrayList<TiledMapTileLayer> collisionList = new ArrayList<TiledMapTileLayer>();
        TiledMapTileLayer powerupLayer = map.getPowerupLayer();
        collisionList.add(map.getStaticLayer());
        collisionList.add(map.getDynamicLayer());
        this.collision = new Collision(collisionList);
        this.collision.setPowerupLayer(powerupLayer);
        
        this.gameState = true;
        Gdx.input.setInputProcessor(controller);        
    }
    public void update(){
        /*------------------- Game Logic -------------------*/
        checkPlayerCollision(player1);
        checkPlayerCollision(player2);

        time += Gdx.graphics.getDeltaTime();
        gameStateDetection(); // checks if game is over

        tileFactory.update(time);

        if(checkIfPlayerExplodes(player1) && checkIfPlayerExplodes(player2)){
            killPlayer(player1);
            killPlayer(player2);
            game.setWinner(1);

            gameState = false;
        }
        else if(checkIfPlayerExplodes(player1)){
            killPlayer(player1);
            game.setWinner(3);

            gameState = false;
        }
        else if(checkIfPlayerExplodes(player2)){
            killPlayer(player2);
            game.setWinner(2);

            gameState = false;
        }
    }
    /*------------------- Model Functionallity -------------------*/
    public void checkPlayerCollision(Player player) {
        float oldX = player.getX();
        float oldY = player.getY();
        player.update(Gdx.graphics.getDeltaTime());
        if (collision.checkCollisionOfCollidable(player)) {
            player.setVelocity(new Vector2(0f,0f));
            player.setX(oldX);
            player.setY(oldY);
        }

        String powerup = collision.containsPowerup(player.getPosition());
        if (!powerup.equals("none")){
            map.removePowerupFromMap(player.getPosition());
            player.applyPowerup(powerup);
            long id =powerUpSound.play();
            powerUpSound.setVolume(id, 0.6f);

        }
    }

    /*
     * Checks if game is over and calls a game over screen
     */
    private void gameStateDetection(){
        // Pause screen?
        if (!(gameState)) {
            game.setScreen(new GameOverScreen(game));
        }
    }

    /**
     * Player drops a bomb at their current location. 
     * Checks that the player is allowed to drop a bomb (i.e they dont have too many bombs dropped at once)
     * Adds timer to the bomb. (It explodes in 2 seconds)
     * Adds this bomb to timedBombList, which is the list of current bombs on the map.
     * @param player The player that drops the bomb
     */
    public void addBomb(Player player){
        int playerNumber = player.getNumber();
        if (tileFactory.legalBombDrop(playerNumber, player.getBombLimit(), player.getPosition())){
            Bomb bomb = new Bomb(player.getPosition(), player.getBombRange(), player.getBombPower());
            TimedEntity<Bomb> newBomb = new TimedEntity<Bomb>(bomb, time + 2, player.getNumber());
            tileFactory.addBomb(newBomb);
            playBombSound();
        }
    }


    void playBombSound(){
        dropBombsound.play();
        long id = bombSound.play();
        bombSound.setVolume(id, 0.6f);
    }


    private void killPlayer(Player player){
        killSound.play();
        player.killPlayer();
    }

    private boolean checkIfPlayerExplodes(Player player){
        if (map.containsExplosion(player.getPosition())){
            return true;
        }
        return false;
    }

    /*------------------- Model Functionallity -------------------*/
}

