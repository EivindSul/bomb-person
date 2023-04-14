package inf112.bomberperson.model;

import java.util.ArrayList;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class Collision {
    String blockedKey = "blocked";
    ArrayList<TiledMapTileLayer> collisionList;
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
    
    public boolean isCellBlocked(float x, float y, TiledMapTileLayer layer){
        try {

            TiledMapTileLayer.Cell cell = layer.getCell((int) (x / layer.getTileWidth()), (int) (y / layer.getTileHeight()));
            // System.out.println(cell.getTile().getId());
            return cell != null && cell.getTile() != null && cell.getTile().getProperties().containsKey(blockedKey);
        }
        catch (Exception e){
            return false;

        }

    }
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
