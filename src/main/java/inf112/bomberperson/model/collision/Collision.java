package inf112.bomberperson.model.collision;

import java.util.ArrayList;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

import inf112.bomberperson.model.map.Map;

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

    public void setPowerupLayer(TiledMapTileLayer layer) {
        this.powerUpLayer = layer;
    }

    public String containsPowerup(Vector2 position){
        try {
            TiledMapTileLayer layer = getPowerupLayer();
            int col = (Math.round(position.x / Map.TILE_SIZE));
            int row = (Math.round(position.y / Map.TILE_SIZE));

            TiledMapTileLayer.Cell cell = layer.getCell(col,row);
            
            if (cell == null){
                return "none";
            }

            if (cell.getTile().getProperties().containsKey("powerup")){
                return (String)cell.getTile().getProperties().get("powerup");
            }
            return "none";
        }
        catch (RuntimeException e){
            throw e;
        }
        catch (Exception e){
            return "none";
        }
    }

    private TiledMapTileLayer getPowerupLayer() {
        return this.powerUpLayer;
    }

    /**
     * A method that checks if the a cell is blocked.
     * @param x - x-position
     * @param y - y-position
     * @param layer - check the layer is other than grass.
     * @return True if the cell blocked.
     */
    private boolean isCellBlocked(float x, float y, TiledMapTileLayer layer){
        try {
            TiledMapTileLayer.Cell cell = layer.getCell((int) (x / layer.getTileWidth()), (int) (y / layer.getTileHeight()));
            return cell != null && cell.getTile() != null && cell.getTile().getProperties().containsKey(blockedKey);
        }
        catch (RuntimeException e){
            throw e;
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
        for(float step = 0; step < collidable.getHeight() ; step += layer.getTileHeight()/2.0){
            try {
                collides = isCellBlocked(collidable.getX() + collidable.getWidth(), collidable.getY() + step, layer);
                if (collides){
                    break;
                }
            }
            catch (RuntimeException e){
                throw e;
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
        for(float step = 0; step < collidable.getHeight() ; step += layer.getTileHeight()/2.0){
            try {
                collides = isCellBlocked(collidable.getX() , collidable.getY() + step, layer);
                if (collides){
                    break;
                }
            }
            catch (RuntimeException e){
                throw e;
            }
            catch (Exception e){
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
    for(float step = 0; step < collidable.getWidth() ; step += layer.getTileWidth()/2.0){
            try {
                collides = isCellBlocked(collidable.getX() + step, collidable.getY() + collidable.getHeight(), layer);
                if (collides){
                    break;
                }
            }
            catch (RuntimeException e){
                throw e;
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

        for(float step = 0; step < collidable.getWidth(); step += layer.getTileWidth()/2.0){
            try {
                collides = isCellBlocked(collidable.getX() + step, collidable.getY(), layer);
                if (collides){
                    break;
                }
            } 
            catch (RuntimeException e){
                throw e;
            }
            catch (Exception e){
                continue;
            }
        }
        return collides;
    }
}
