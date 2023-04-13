package inf112.bomberperson.model;

import java.util.ArrayList;
import java.util.LinkedList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import inf112.bomberperson.controller.MyInputProcessor;
import inf112.bomberperson.game.BombermanGame;
import inf112.bomberperson.screens.GameOverScreen;


public class Model implements ApplicationListener {
    OrthographicCamera camera;
    private BombermanGame game;
    Map map;
    public Player player1;
    public Player player2;
    public MyInputProcessor controller;
    // Maybe edit to an enum since we will have more than two screens.
    public Boolean gameState; // GAME OVER == FALSE

    public float time = 0;

    private ArrayList<TimedEntity<Bomb>> timedBombList = new ArrayList<TimedEntity<Bomb>>();
    private ArrayList<TimedEntity<Explosion>> explosionList = new ArrayList<TimedEntity<Explosion>>();

    private Collision collision;

    public Model(BombermanGame game, OrthographicCamera camera){
        this.game = game;
        this.camera = camera;

        this.controller = new MyInputProcessor(this);

        this.map = new Map();
        map.create();

        this.player1 = new Player(new Sprite(new Texture("doc/assets/player.png")));
        this.player2 = new Player(new Sprite(new Texture("doc/assets/player.png")));

        player1.setPosition(1 * 16, (map.getHeight() - 26) *16);
        player2.setPosition(25 * 16, (map.getHeight() - 2) *16);
        controller = new MyInputProcessor(this);

        ArrayList<TiledMapTileLayer> collisionList = new ArrayList<TiledMapTileLayer>();
        collisionList.add(map.wallLayer);
        collisionList.add(map.explodableWallLayer);
        this.collision = new Collision(collisionList);
        
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
        checkPlayerCollision(player1);
        checkPlayerCollision(player2);

        time += Gdx.graphics.getDeltaTime();
        gameStateDetection(); // checks if game is over


        ArrayList<TimedEntity<Bomb>> bombsToExplode = explosionDetection(); // checks if bomb should explode now

        explosionAlgorithm(bombsToExplode); // runs an algorithm for exploding bomb. 

        ArrayList<TimedEntity<Explosion>> decayedExplosions = explosionDecay();
        
        cleanExplodeTimeList(bombsToExplode);
        cleanBombList(decayedExplosions);

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
        player1.draw(map.getMapRenderer().getBatch());
        player2.draw(map.getMapRenderer().getBatch());

        /*------------------- Render Player -------------------*/
        
        /*------------------- Render Bomb -------------------*/

        LinkedList<Bomb> bombsToDraw1 = player1.getBombList();
        LinkedList<Bomb> bombsToDraw2 = player2.getBombList();
        
        
        for (Bomb bomb : bombsToDraw1) {
            bomb.draw(map.getMapRenderer().getBatch());
        }

        for (Bomb bomb : bombsToDraw2) {
            bomb.draw(map.getMapRenderer().getBatch());
        }

        for (TimedEntity<Explosion> timedExplosion : explosionList) {
            Explosion explosion = timedExplosion.getEntity();
            for (ExplosionTile tile : explosion.getExplosion()) {
                if(collision.isCellBlocked(tile.getPositionX(), tile.getPositionY(), map.wallLayer)){
                    continue;
                }
                tile.draw(map.getMapRenderer().getBatch());
            }
        }

        map.getMapRenderer().getBatch().end(); // End drawing

        /*------------------- Render Bomb -------------------*/
    }
    public void checkPlayerCollision(Player player) {
        float oldX = player.getX();
        float oldY = player.getY();
        player.update(Gdx.graphics.getDeltaTime());
        if (collision.checkCollisionOfCollidable(player)) {
            player.setVelocity(new Vector2(0f,0f));
            player.setX(oldX);
            player.setY(oldY);
        }
    }
    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        player1.getTexture().dispose();
        player2.getTexture().dispose();

    }

    /*------------------- Model Functionallity -------------------*/

    /*
     * Checks if game is over and calls a game over screen
     */
    private void gameStateDetection(){
        // Pause screen?
        if (!(gameState)) {
            game.setScreen(new GameOverScreen(game)); //TODO: game over screen
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
            }
        }
        return decayedExplosions;
    }


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
        }
    }

    /**
     * Calculates how far explosions go before they hit an obstacle. 
     * Makes the explosions that big, and stops expanding a node if it hits an obstacle.
     * Adds the explosions to explosionList
     * @param bombsToExplode list of bombs to explode. May be just one
     */
    private void explosionAlgorithm(ArrayList<TimedEntity<Bomb>> bombsToExplode) {
        // The bombs in bombsToExplode should already be removed in the explosionDetection method.
        for (TimedEntity<Bomb> timedBomb : bombsToExplode) {
            Bomb bomb = timedBomb.getEntity();
            Explosion explosion = bomb.explodeBomb();

            for (int i = 0; i < explosion.getRange(); i++) {
                ArrayList<DirectedExplosionTile> border = explosion.getBorder();

                if(border.isEmpty()){
                    break;
                }

                ArrayList<DirectedExplosionTile> newBorder = new ArrayList<DirectedExplosionTile>();
                
                for (DirectedExplosionTile tile : border) {
                    DirectedExplosionTile nextTile = explosion.expandNode(tile);
                    switch(checkIfSolid(nextTile.getPosition())){
                        case 2:  // case 2, wall is solid and stops the explosion
                            nextTile.hitSolid();

                            //explosion.addExplosionTile(tile.getTile());
                        case 1:  // case 1, soft obstruction. Explosion keeps going for one tile.
                            nextTile.hitBreakable();
                            explosion.addExplosionTile(tile.getTile());
                            newBorder.add(nextTile);
                            breakWall(nextTile.getPosition().x,nextTile.getPosition().y);
                        case 0:  // case 0, no obstruction. Explosion keeps going
                            explosion.addExplosionTile(nextTile.getTile());
                            newBorder.add(nextTile);
                    }
                }
                explosion.setBorder(newBorder);
            }
            explosionList.add(new TimedEntity<Explosion>(explosion, time + 1, 1));
            
        }
    }

    /**
     * check if this tile contains a wall, and if the wall is breakable
     *
     * @param position the position that gets checked
     * @return 0 if clear, 1 if wall breaks, 2 if wall is solid
     */
    private int checkIfSolid(Vector2 position) {

        if(collision.isCellBlocked(position.x, position.y, map.explodableWallLayer)){
            return 1;
        }
        if(collision.isCellBlocked(position.x, position.y, map.wallLayer)){
            return 2;
        }

        return 0;
    }

    private void breakWall(float x, float y){
        if(map.explodableWallLayer.getCell((int) (x / map.explodableWallLayer.getTileWidth()), (int) (y/ map.explodableWallLayer.getTileHeight())) != null){
            map.explodableWallLayer.setCell((int) (x / map.explodableWallLayer.getTileWidth()), (int) (y/ map.explodableWallLayer.getTileHeight()), null);
        }

    }


    /*------------------- Model Functionallity -------------------*/
}

