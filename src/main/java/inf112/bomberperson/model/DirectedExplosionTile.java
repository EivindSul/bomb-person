package inf112.bomberperson.model;

import com.badlogic.gdx.math.Vector2;

// An explosiontile with a direction and power.
// TODO: make this into the default explosionTile class, which is useless in its current state. 
// It just contains coordinates, which this class does just fine. 
public class DirectedExplosionTile {
    private int direction;
    private int power;
    private ExplosionTile tile;
    
    public DirectedExplosionTile(ExplosionTile tile, int direction, int power){
        this.tile = tile;
        this.direction = direction;
    }

    public ExplosionTile getTile(){
        return this.tile;
    }

    public Vector2 getPosition(){
        return tile.getPosition();
    }
    
    /**
     * 0 is standing still,
     * 1 is up,
     * 2 is right,
     * 3 is down,
     * 4 is left
     * @return int that indicates direction.
     */
    public int getDirection(){
        return this.direction;
    }

    /**
     * Tells the explosion that this node hit a breakable wall.
     * This reduces how powerful it is (its ability to pass through multiple walls)
     * If it is out of power, it will set direction to 0. In which case, the node is done expanding.
     */
    public void hitBreakable(){
        this.power -= 1;
        if (this.power == 0){
            this.direction = 0;
        }
    }

    /**
     * Tells the explosion that this node hit a solid wall.
     * Power is set to 0 and direction is set to 0.
     * The node is done expanding. 
     */
    public void hitSolid(){
        this.power = 0;
        this.direction = 0;
    }

    /**
     * Get the nodes power, which is its ability to pass through multiple breakables. 
     * This should be 1 for standard bombs. 
     * @return power
     */
    public int getPower() {
        return this.power;
    }

}


