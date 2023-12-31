package inf112.bomberperson.model.tiles;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;

import inf112.bomberperson.model.map.Map;

// Explosion is a list of ExplosionTiles. It contains a timer to tell when it is to be removed from the map, and all its related ExplosionTiles.

public class Explosion {
    
    private Vector2 center;
    private int range;
    private ArrayList<ExplosionTile> explosion = new ArrayList<ExplosionTile>();
    private ArrayList<ExplosionTile> explosionBorder = new ArrayList<ExplosionTile>();

    // TODO: make TileOffset into a system that actually aligns the tiles to grid, instead of using Vector2.
    private float tileOffset = (float) Map.TILE_SIZE;
    
    public Explosion(Vector2 position, int bombRange, int bombPower){
        this.center = position;
        this.range = bombRange;
        ExplosionTile centerTile = new ExplosionTile(center);
        this.explosion.add(centerTile);
        this.explosionBorder.add(new ExplosionTile(center, 1, bombPower));
        this.explosionBorder.add(new ExplosionTile(center, 2, bombPower));
        this.explosionBorder.add(new ExplosionTile(center, 3, bombPower));
        this.explosionBorder.add(new ExplosionTile(center, 4, bombPower));
    }

    // TODO: Add method to draw ExplosionTiles

    
    public ArrayList<ExplosionTile> getExplosion(){
        return this.explosion;
    }
    public void addExplosionTile(ExplosionTile tile){
        this.explosion.add(tile);
    }
    
    public ArrayList<ExplosionTile> getBorder(){
        return this.explosionBorder;
    }
    
    
    /**
     * Expands a node.
     * A node is one line of the explosion. The explosion is shaped like a plus, so there are 4 nodes out of it.
     * This is only used for the explosionBorder, and needs the tile do be directed. 
     * @param ExplosionTile The tile for which to find next tile
     * @return The neighboring tile in the same direction
     */
    public ExplosionTile expandNode(ExplosionTile directedTile){
        
        ExplosionTile neighbor;
        int direction = directedTile.getDirection();
        int power = directedTile.getPower();
        
        switch (direction){
            case 1:  // Up
            neighbor = getAboveNeighbor(directedTile);
            break;
            case 2:  // Right
            neighbor = getRightNeighbor(directedTile);
            break;
            case 3:  // Down
            neighbor = getBelowNeighbor(directedTile);
            break;
            case 4:  // Left
            neighbor = getLeftNeighbor(directedTile);
            break;
            default: 
            return directedTile;
        }
        neighbor.setDirection(direction);
        neighbor.setPower(power);
        return neighbor;
    }
    
    /**
     * get range of an explosion.
     *
     * @return how long the explosion will be when unobstructed.
     */
    public int getRange(){
        return this.range;
    }
    
    public void setBorder(ArrayList<ExplosionTile> newBorder) {
        this.explosionBorder = newBorder;
    }
    
    public void setBorder(int index, ExplosionTile tile) {
        this.explosionBorder.set(index, tile);
    }

    private ExplosionTile getAboveNeighbor(ExplosionTile tile){
        Vector2 neighborPosition = new Vector2 (tile.getX() + tileOffset, tile.getY());
        ExplosionTile neighbor = new ExplosionTile(neighborPosition);
        return neighbor;
    }
    private ExplosionTile getRightNeighbor(ExplosionTile tile){
        Vector2 neighborPosition = new Vector2 (tile.getX(), tile.getY() + tileOffset);
        ExplosionTile neighbor = new ExplosionTile(neighborPosition);
        return neighbor;

    }
    private ExplosionTile getBelowNeighbor(ExplosionTile tile){
        Vector2 neighborPosition = new Vector2 (tile.getX() - tileOffset, tile.getY());
        ExplosionTile neighbor = new ExplosionTile(neighborPosition);
        return neighbor;
    }
    
    private ExplosionTile getLeftNeighbor(ExplosionTile tile){
        Vector2 neighborPosition = new Vector2 (tile.getX(), tile.getY() - tileOffset);
        ExplosionTile neighbor = new ExplosionTile(neighborPosition);
        return neighbor;
    }
    
    
    
    /*------------------- GET POSITION -------------------*/
    public Vector2 getPositionUp(){
        return new Vector2(getPositionX(),getPositionY() + getTileOffset());
    }
    public Vector2 getPositionRight(){
        return new Vector2(getPositionX() + getTileOffset(),getPositionY());
    }
    public Vector2 getPositionDown(){
        return new Vector2(getPositionX(),getPositionY() - getTileOffset());
    }
    public Vector2 getPositionLeft(){
        return new Vector2(getPositionX() - getTileOffset(),getPositionY());
    }
    
    public float getTileOffset() {
        return this.tileOffset;
    }
    public float getPositionX(){
        return this.center.x;
    }
    public float getPositionY(){
        return this.center.y;
    }
    public Vector2 getPosition(){
        return this.center;
    }


}


