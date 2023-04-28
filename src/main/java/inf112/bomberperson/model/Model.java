package inf112.bomberperson.model;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
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
    // Maybe edit to an enum since we will have more than two screens.
    public Boolean gameState; // GAME OVER == FALSE
    Sound killSound;
    Sound powerUpSound;
    Sound dropBombsound;
    Sound bombSound;

    public float time = 0;

    private ArrayList<TimedEntity<Bomb>> timedBombList = new ArrayList<TimedEntity<Bomb>>();
    private ArrayList<TimedEntity<Explosion>> explosionList = new ArrayList<TimedEntity<Explosion>>();

    private Collision collision;

    public Model(BombermanGame game){
        this.game = game;

        this.map = new Map();

        killSound = Gdx.audio.newSound(Gdx.files.internal("doc/assets/Sounds/zapsplat_horror_monster_small_dying_screech_003_72195.mp3"));
        powerUpSound = Gdx.audio.newSound(Gdx.files.internal("doc/assets/Sounds/zapsplat_bell_small_hand_short_ring_003_84222.mp3"));
        this.dropBombsound = Gdx.audio.newSound(Gdx.files.internal("doc/assets/Sounds/zapsplat_foley_footstep_single_boys_sneaker_on_concrete_002_50912.mp3"));
        this.bombSound = Gdx.audio.newSound(Gdx.files.internal("doc/assets/Sounds/zapsplat_explosions_designed_huge_fire_bomb_ball_005_89762.mp3"));

        this.player1 = new Player();
        this.player2 = new Player();

        player1.setPosition(1 * 16, (map.getHeight() - 26) *16);
        player2.setPosition(25 * 16, (map.getHeight() - 2) *16);
        
        this.controller = new MyInputProcessor(this);
        controller.mapInputs();

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


        ArrayList<TimedEntity<Bomb>> bombsToExplode = explosionDetection(); // checks if bomb should explode now

        explodeBombs(bombsToExplode); // runs an algorithm for exploding bomb. 

        ArrayList<TimedEntity<Explosion>> decayedExplosions = explosionDecay();
        
        cleanExplodeTimeList(bombsToExplode);
        cleanBombList(decayedExplosions);


        if(checkIfPlayerExplodes(player1)){
            killPlayer(player1);

            gameState = false;
        }
        if(checkIfPlayerExplodes(player2)){
            killPlayer(player2);

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

    /*
     * Checks if any bombs explode. if a bomb explodes, it removes this bomb from the respective player's bomb list.
     * @return bombsToExplode
    */
    private ArrayList<TimedEntity<Bomb>> explosionDetection() {
        ArrayList<TimedEntity<Bomb>> bombsToExplode = new ArrayList<TimedEntity<Bomb>>();

        for (TimedEntity<Bomb> timedBomb : timedBombList) {
            float explosionTime = timedBomb.getTime();

            if (time >= explosionTime){
                bombsToExplode.add(timedBomb);
                map.removeBombFromMap(timedBomb.getEntity().getPosition());
                if (timedBomb.getOwner() == 1) {
                    player1.popBombList();
                }
                else {
                    player2.popBombList();
                }
            }
        }
        return bombsToExplode;
    }

    /**
     * removes argument list of bombs from timedBombList
     * @param bombsToRemove - ArrayList of TimedBombs to be cleaned up from list.
     */
    private void cleanExplodeTimeList(ArrayList<TimedEntity<Bomb>> bombsToRemove){
        for (TimedEntity<Bomb> timedBomb : bombsToRemove) {
            timedBombList.remove(timedBomb);
        }
    }

    /**
     * removes argument list of explosions from explosionList
     * @param decayedExplosions - ArrayList of TimedExplosions to be cleaned up from list.
     */
    private void cleanBombList(ArrayList<TimedEntity<Explosion>> decayedExplosions){
        for (TimedEntity<Explosion> timedExplosion : decayedExplosions) {
            explosionList.remove(timedExplosion);
        }
    }

    /**
     * Checks if current explosions should be removed from map.
     */
    private ArrayList<TimedEntity<Explosion>> explosionDecay(){
        ArrayList<TimedEntity<Explosion>> decayedExplosions = new ArrayList<TimedEntity<Explosion>>();

        for (TimedEntity<Explosion> timedExplosion : explosionList) {
            float decayTime = timedExplosion.getTime();

            if (time >= decayTime){
                decayedExplosions.add(timedExplosion);
                map.removeExplosionFromMap(timedExplosion.getEntity());;
            }
        }
        return decayedExplosions;
    }


    /**
     * Player drops a bomb at their current location. 
     * Checks that the player is allowed to drop a bomb (i.e they dont have too many bombs dropped at once)
     * Adds timer to the bomb. (It explodes in 2 seconds)
     * Adds this bomb to timedBombList, which is the list of current bombs on the map.
     * @param player The player that drops the bomb
     */
    public void addBomb(Player player){
        if (player.dropBomb()){
            if (player == player1) {
                TimedEntity<Bomb> newBomb = new TimedEntity<Bomb>(player.getBombList().getLast(), time + 2, 1);
                timedBombList.add(newBomb);
            }
            if (player == player2) {
                TimedEntity<Bomb> newBomb = new TimedEntity<Bomb>(player.getBombList().getLast(), time + 2, 2);
                timedBombList.add(newBomb);
            }
            map.addBombToMap(player.getPosition());
            playBombSound();
        }
    }
    void playBombSound(){
        dropBombsound.play();
        long id = bombSound.play();
        bombSound.setVolume(id, 0.6f);

    }

    /**
     * Explodes bombs, and turns them into explosions.
     * Draws the explosions on the map in the explosionLayer.
     * Adds the explosions to explosionList, which is the list of currently active explosions. 
     * @param bombsToExplode list of bombs to explode in current game loop.
     */
    private void explodeBombs(ArrayList<TimedEntity<Bomb>> bombsToExplode) {
        // The bombs in bombsToExplode should already be removed in the explosionDetection method.

        for (TimedEntity<Bomb> timedBomb : bombsToExplode) {
            Bomb bomb = timedBomb.getEntity();
            Explosion explosion = bomb.explodeBomb();

            
            explosion = explosionAlgorithm(explosion);
            
            explosionList.add(new TimedEntity<Explosion>(explosion, time + (float)0.5, 1));
            map.addExplosionToMap(explosion);

        }

    }
    
    
    /**
     * Calculates how an explosion is shaped.
     * Takes a fresh explosion as argument, expands this as far as it should go. Checks if it hits walls, and reacts correspondingly.
     * @param explosion Newly initialized explosion.
     * @return Fully expanded explosion. The explosion variable within contains explosiontiles.
     */
    private Explosion explosionAlgorithm(Explosion explosion){

        ArrayList<Integer> nodeIndexes = new ArrayList<Integer>();
        nodeIndexes.add(0);
        nodeIndexes.add(1);
        nodeIndexes.add(2);
        nodeIndexes.add(3);
        
        // Expands nodes, one node at a time.
        for (Integer i : nodeIndexes) {
            int range = explosion.getRange();
            
            while (range > 0){
                ExplosionTile node = explosion.getBorder().get(i);
                
                if (node.getDirection() == 0){ // Direction 0 means node has stopped.
                    range = 0;
                    break;
                }

                ExplosionTile nextNode = explosion.expandNode(node);

                
                int solid = checkIfSolid(nextNode.getPosition());

                if (solid == 2){
                    nextNode.hitSolid();
                    range = 0;
                    break;
                }
                
                if (solid == 1){
                    nextNode.hitBreakable();
                }

                map.breakWall(nextNode.getPosition());

                explosion.addExplosionTile(nextNode);
                explosion.setBorder(i, nextNode);
                range -= 1;
            }
        }
        return explosion;
    }
    
    
    
    /**
     * check if this tile contains a wall, and if the wall is breakable
     *
     * @param position the position that gets checked
     * @return 0 if clear, 1 if wall breaks, 2 if wall is solid
     */
    private int checkIfSolid(Vector2 position) {
        
        if(map.containsSolidWall(position)){
            return 2;
        }
        if(map.containsBrickWall(position)){
            return 1;
        }
        return 0;
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

