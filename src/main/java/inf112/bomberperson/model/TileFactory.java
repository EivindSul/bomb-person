
package inf112.bomberperson.model;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;

import inf112.bomberperson.model.map.Map;
import inf112.bomberperson.model.tiles.Bomb;
import inf112.bomberperson.model.tiles.Explosion;
import inf112.bomberperson.model.tiles.ExplosionTile;

/**
 * TileFactory
 */
public class TileFactory {
    
    private ArrayList<TimedEntity<Bomb>> timedBombList = new ArrayList<TimedEntity<Bomb>>();
    private ArrayList<TimedEntity<Explosion>> explosionList = new ArrayList<TimedEntity<Explosion>>();

    public float time = 0;
    private Map map;

    
    public TileFactory(Map map){
        this.map = map;
    }

    public void update(float newTime){
        this.time = newTime;

        ArrayList<TimedEntity<Bomb>> bombsToExplode = explosionDetection(); // checks if bomb should explode now

        explodeBombs(bombsToExplode); // runs an algorithm for exploding bomb. 

        ArrayList<TimedEntity<Explosion>> decayedExplosions = explosionDecay();
        
        cleanExplodeTimeList(bombsToExplode);
        cleanBombList(decayedExplosions);

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

    /**add a bomb to a players position on the map.
     * @param player that drops bomb
     * @param time when bomb should detonate
     */
    public void addBomb(Player player, float time) {
        Bomb bomb = new Bomb(player.getPosition(), player.getBombRange(), player.getBombPower());
        TimedEntity<Bomb> newBomb = new TimedEntity<Bomb>(bomb, time, player.getNumber());
        timedBombList.add(newBomb);
        map.addBombToMap(newBomb.getEntity().getPosition());
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

    /** Checks that a bomb is legal to drop by a player on their position. 
     * @param player
     * @return whether the tile is free and the player does not exceed their maximum amount of dropped bombs
     */
    public boolean legalBombDrop(Player player) {
        int playerNumber = player.getNumber();
        int bombLimit = player.getBombLimit();
        Vector2 position = player.getPosition();

        for (TimedEntity<Bomb> timedBomb : timedBombList) {
            if(timedBomb.getOwner() == playerNumber){
                bombLimit -= 1;
            }
            if (map.containsBomb(position)){
                return false;
            }
            if (bombLimit <= 0) {
                return false;
            }
        }
        return true;
    }
}