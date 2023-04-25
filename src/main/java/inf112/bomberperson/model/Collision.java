package inf112.bomberperson.model;

import java.util.ArrayList;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class Collision {
    String blockedKey = "blocked";
    ArrayList<TiledMapTileLayer> collisionList;
    private TiledMapTileLayer powerUpLayer;

    public Collision(ArrayList<TiledMapTileLayer> collisionList){
        this.collisionList = collisionList;
    }
    /**
     * A genereal method gathering all collision logic in one method
     * @param collidable checks the collidable if it collides collisionList
     * @return true if collides, false if not
     */
    public boolean checkCollisionOfCollidable(Collidable collidable){
        for (TiledMapTileLayer layer : collisionList) {
            if (checkCollisionOnOnlyLayer(collidable, layer)) {
                return true;
            }
        }
        return false;
    }
    /**
     * A method checking collision of spesific layer
     * @param collidable to check if collides with layer
     * @param layer to check if collides with collidable
     * @return true if Collidable collides with layer
     */
    private boolean checkCollisionOnOnlyLayer(Collidable collidable, TiledMapTileLayer layer){
        if (
            collidesTop(collidable, layer) ||
            collidesBottom(collidable, layer) ||
            collidesRight(collidable, layer) ||
            collidesLeft(collidable, layer)
        ) {return true;}
        return false;
    }

    public boolean checkCollisionOnPowerup(Collidable collidable){
        checkCollisionOnOnlyLayer(collidable, this.getPowerupLayer());
        return true;
    }

    public void setPowerupLayer(TiledMapTileLayer layer) {
        this.powerUpLayer = layer;
    }

    public String containsPowerup(Vector2 position){
        float x = position.x;
        float y = position.y;
        try {
            TiledMapTileLayer layer = getPowerupLayer();
            TiledMapTileLayer.Cell cell = layer.getCell((int) (x / layer.getTileWidth()), (int) (y / layer.getTileHeight()));
            
            if (cell == null){
                return "none";
            }
            if (cell.getTile().getProperties().containsKey("powerup")){
                return (String)cell.getTile().getProperties().get("powerup");
            }
            return "none";
        }
        catch (Exception e){
            return "none";
        }
    }

    public TiledMapTileLayer getPowerupLayer() {
        return this.powerUpLayer;
    }
    
    public boolean isCellBlocked(float x, float y, TiledMapTileLayer layer){
        try {

            TiledMapTileLayer.Cell cell = layer.getCell((int) (x / layer.getTileWidth()), (int) (y / layer.getTileHeight()));
            return cell != null && cell.getTile() != null && cell.getTile().getProperties().containsKey(blockedKey);
        }
        catch (Exception e){
            return false;

        }

    }

    /**
     * A method that checks if it collides with something on right side.
     * @param collidable check if collides with layer
     * @param layer to check if collides with collidable
     * @return true if Collidable collides with layer on right side.
     */
    public boolean collidesRight(Collidable collidable, TiledMapTileLayer layer){
        boolean collides = false;
        for(float step = 0; step < collidable.getHeight() ; step += layer.getTileHeight()/2){
            try {
                collides = isCellBlocked(collidable.getX() + collidable.getWidth(), collidable.getY() + step, layer);
                if (collides){
                    break;
                }
            }
            catch (Exception e){
                continue;
            }
        }

        return collides;
    }

    /**
     * A method that checks if it collides with something on left side.
     * @param collidable check if collides with layer
     * @param layer to check if collides with collidable
     * @return true if Collidable collides with layer on left side.
     */
    public boolean collidesLeft(Collidable collidable , TiledMapTileLayer layer){
        boolean collides = false;
        for(float step = 0; step < collidable.getHeight() ; step += layer.getTileHeight()/2){
            try {
                collides = isCellBlocked(collidable.getX() , collidable.getY() + step, layer);
                if (collides){
                    break;
                }
            }catch (Exception e){
                continue;
            }
        }

        return collides;
    }


    /**
     * A method that checks if it collides with something on top side.
     * @param collidable check if collides with layer
     * @param layer to check if collides with collidable
     * @return true if Collidable collides with layer on top side.
     */
    public boolean collidesTop(Collidable collidable , TiledMapTileLayer layer){
    boolean collides = false;
    for(float step = 0; step < collidable.getWidth() ; step += layer.getTileWidth()/2){
            try {
                collides = isCellBlocked(collidable.getX() + step, collidable.getY() + collidable.getHeight(), layer);
                if (collides){
                    break;
                }
            }
            catch (Exception e){
                continue;
            }
        }

        return collides;
    }

    /**
     * A method that checks if it collides with something on bottom side.
     * @param collidable check if collides with layer
     * @param layer to check if collides with collidable
     * @return true if Collidable collides with layer on bottom.
     */
    public boolean collidesBottom(Collidable collidable , TiledMapTileLayer layer){
        boolean collides = false;

        for(float step = 0; step < collidable.getWidth(); step += layer.getTileWidth()/2){
            try {
                collides = isCellBlocked(collidable.getX() + step, collidable.getY(), layer);
                if (collides){
                    break;
                }
            } catch (Exception e){
                continue;
            }
        }
        return collides;
    }

}
