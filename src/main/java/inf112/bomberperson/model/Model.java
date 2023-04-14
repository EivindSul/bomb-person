package inf112.bomberperson.model;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.IntStream;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.utils.viewport.FitViewport;

import inf112.bomberperson.controller.MyInputProcessor;
import inf112.bomberperson.game.BombermanGame;
import inf112.bomberperson.model.Map.TileType;
import inf112.bomberperson.screens.GameOverScreen;


public class Model implements ApplicationListener {
    OrthographicCamera camera;
    private BombermanGame game;
    Map map;
    public Player player;
    public MyInputProcessor controller;
    // Maybe edit to an enum since we will have more than two screens.
    public Boolean gameState; // GAME OVER == FALSE

    public float time = 0;

    private ArrayList<TimedEntity<Bomb>> timedBombList = new ArrayList<TimedEntity<Bomb>>();
    private ArrayList<TimedEntity<Explosion>> explosionList = new ArrayList<TimedEntity<Explosion>>();

    private Collision collision = new Collision(player);

    public Model(BombermanGame game, OrthographicCamera camera){
        this.game = game;
        this.camera = camera;

        this.controller = new MyInputProcessor(this);

        this.map = new Map();
        map.create();

        this.player = new Player(new Sprite(new Texture("doc/assets/player.png")), map.wallLayer, map.explodableWallLayer);
        //Map unit translation AKA the magic number
        player.setPosition(1 * player.getWallLayer().getTileWidth(), (player.getWallLayer().getHeight() - 26) *player.getWallLayer().getTileHeight());
        controller = new MyInputProcessor(this);
        this.create();
    }
    /*
     * Initializer method:
     * All pre-generated objects and method has to be initialized here
     */
    public void create(){
        this.gameState = true;

        Gdx.input.setInputProcessor(controller);        

    }

    @Override
    public void resize(int i, int i1) {

    }

    /*
     * updates the model without rendering it
     */
    public void update(){

        /*-------------------Player Input-------------------*/
        /*-------------------Player Input-------------------*/

        /*------------------- Game Logic -------------------*/

        time += Gdx.graphics.getDeltaTime();
        gameStateDetection(); // checks if game is over


        ArrayList<TimedEntity<Bomb>> bombsToExplode = explosionDetection(); // checks if bomb should explode now

        explodeBombs(bombsToExplode); // runs an algorithm for exploding bomb. 
        // explosionAlgorithm(bombsToExplode);

        ArrayList<TimedEntity<Explosion>> decayedExplosions = explosionDecay();
        
        cleanExplodeTimeList(bombsToExplode);
        cleanBombList(decayedExplosions);


        if(checkIfPlayerExplodes(player)){
            killPlayer();

            gameState = false;
        }

        /*------------------- Game Logic -------------------*/

        /*------------------- Update Map -------------------*/
        /*------------------- Update Map -------------------*/
    }
    /*
     * Renderer updates the model and then renders objects
     */
    public void render(){
        /*------------------- Render Map -------------------*/
        map.render();
        /*------------------- Render Map -------------------*/

        map.getMapRenderer().getBatch().begin(); // Begin drawing

        /*------------------- Render Player -------------------*/

        player.draw(map.getMapRenderer().getBatch());

        /*------------------- Render Player -------------------*/
        
        /*------------------- Render Bomb -------------------*/

        LinkedList<Bomb> bombsToDraw = player.getBombList();
        

        map.getMapRenderer().getBatch().end(); // End drawing

        /*------------------- Render Bomb -------------------*/
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        player.getTexture().dispose();

    }

    /*------------------- Model Functionallity -------------------*/

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
     * Checks if any bombs explode. if a bomb explodes, it removes this bomb from the respective player's bomb list.
     * @return bombsToExplode
    */
    private ArrayList<TimedEntity<Bomb>> explosionDetection() {
        ArrayList<TimedEntity<Bomb>> bombsToExplode = new ArrayList<TimedEntity<Bomb>>();

        for (TimedEntity<Bomb> timedBomb : timedBombList) {
            float explosionTime = timedBomb.getTime();

            if (time >= explosionTime){
                bombsToExplode.add(timedBomb);
                player.popBombList(); 
                map.removeBombFromMap(timedBomb.getEntity().getPosition());
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
            TimedEntity<Bomb> newBomb= new TimedEntity<Bomb>(player.getBombList().getLast(), time + 2, 1);
            timedBombList.add(newBomb);
            map.addBombToMap(player.getPosition());
        }
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

        ArrayList<ExplosionTile> border = explosion.getBorder();

        ArrayList<Integer> nodeIndexes = new ArrayList<Integer>();
        nodeIndexes.add(0);
        nodeIndexes.add(1);
        nodeIndexes.add(2);
        nodeIndexes.add(3);
        
        // Expands nodes, one node at a time.
        for (Integer i : nodeIndexes) {
            ExplosionTile node = border.get(i);
            int range = explosion.getRange();

            while (range > 0){
                if (node.getDirection() == 0){ // Direction 0 means node has stopped.
                    range = 0;
                    continue;
                }
    
                ExplosionTile nextNode = explosion.expandNode(node);

                switch(checkIfSolid(nextNode.getPosition())){
                    case 2:
                        nextNode.hitSolid();
    
                        range = 0;
                        continue;
                    case 1:
                        nextNode.hitBreakable();
                        map.breakWall(nextNode.getPosition());
                    case 0:
                }
    
                explosion.addExplosionTile(nextNode);
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
        if(map.containsBreakableWall(position)){
            return 1;
        }
        return 0;
    }

    private void killPlayer(){
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

